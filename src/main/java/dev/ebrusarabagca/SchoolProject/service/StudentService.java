package dev.ebrusarabagca.SchoolProject.service;

import dev.ebrusarabagca.SchoolProject.entity.Lecture;
import dev.ebrusarabagca.SchoolProject.entity.Student;
import dev.ebrusarabagca.SchoolProject.repository.LectureRepository;
import dev.ebrusarabagca.SchoolProject.repository.StudentRepository;
import dev.ebrusarabagca.SchoolProject.request.StudentRegister;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final LectureRepository lectureRepository;

    private final LectureService lectureService;

    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElseThrow(NoSuchElementException::new);
    }

    public Student register(StudentRegister register) {
        Student student = new Student();

        student.setFirstname(register.getFirstname());
        student.setLastname(register.getLastname());
        student.setGPA(register.getGPA());
        return studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        Student student = getStudentById(studentId);
        studentRepository.delete(student);
    }

    public int calculateCredit(Long studentId) {
        int total = 0;
        Student student = getStudentById(studentId);

        for(int i = 0; i < student.getPassedLectureList().size(); i++) {
            total += student.getPassedLectureList().get(i).getCredit();
        }

        return total;
    }

    public String canGraduate(Long studentId) {
        if (calculateCredit(studentId) > 20)
            return "Required credit limit exceeded. The student can graduate now.";
        else
            return "Required credit limit did not exceed. The student cannot graduate now";
    }

    public void passLecture(Long studentId, Long lectureId) {
        Student student = getStudentById(studentId);
        Lecture lecture = lectureService.getLectureById(lectureId);

        student.getSemesterLectureList().remove(lecture);
        student.getPassedLectureList().add(lecture);
    }

    public void registerLecture(Long studentId, Long lectureId) {
        Student student = getStudentById(studentId);
        Lecture lecture = lectureService.getLectureById(lectureId);

        student.getSemesterLectureList().add(lecture);
        lecture.getStudentList().add(student);
        studentRepository.save(student);
        lectureRepository.save(lecture);
    }

    public void withdrawLecture(Long studentId, Long lectureId) {
        Student student = getStudentById(studentId);
        Lecture lecture = lectureService.getLectureById(lectureId);

        student.getSemesterLectureList().remove(lecture);
        lecture.getStudentList().remove(student);
    }
}
