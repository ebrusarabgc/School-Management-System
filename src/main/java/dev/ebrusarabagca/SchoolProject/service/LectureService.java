package dev.ebrusarabagca.SchoolProject.service;

import dev.ebrusarabagca.SchoolProject.entity.Lecture;
import dev.ebrusarabagca.SchoolProject.entity.Lecturer;
import dev.ebrusarabagca.SchoolProject.entity.Student;
import dev.ebrusarabagca.SchoolProject.repository.LectureRepository;
import dev.ebrusarabagca.SchoolProject.repository.LecturerRepository;
import dev.ebrusarabagca.SchoolProject.repository.StudentRepository;
import dev.ebrusarabagca.SchoolProject.request.AddLecture;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class LectureService {
    private final LectureRepository lectureRepository;
    private final LecturerRepository lecturerRepository;
    private final StudentRepository studentRepository;

    public Lecture addLecture(Long lecturerId, AddLecture addLecture) {
        Lecture lecture = new Lecture();
        Lecturer lecturer = lecturerRepository.findById(lecturerId).orElseThrow(NoSuchElementException::new);

        lecture.setLectureName(addLecture.getLectureName());
        lecture.setCredit(addLecture.getCredit());
        lecture.setLecturer(lecturer);

        lecturer.getLectureList().add(lecture);
        lecturerRepository.save(lecturer);
        return lectureRepository.save(lecture);
    }

    public void deleteLecture(Long lectureId, Long lecturerId) {
        Lecture lecture = getLectureById(lectureId);
        Lecturer lecturer = lecturerRepository.findById(lecturerId).orElseThrow(NoSuchElementException::new);

        for (int i = 0; i < lecture.getStudentList().size(); i++) {
            lecture.getStudentList().get(i).getSemesterLectureList().remove(lecture);
        }
        lecturer.getLectureList().remove(lecture);
        lectureRepository.delete(lecture);
    }

    public Lecture getLectureById(Long lectureId) {
        return lectureRepository.findById(lectureId).orElseThrow(NoSuchElementException::new);
    }

    public void deleteStudentById(Long studentId, Long lectureId) {
        Student student = studentRepository.findById(studentId).orElseThrow(NoSuchElementException::new);
        Lecture lecture = getLectureById(lectureId);

        lecture.getStudentList().remove(student);
        student.getSemesterLectureList().remove(lecture);
    }
}
