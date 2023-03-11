package dev.ebrusarabagca.SchoolProject.service;

import dev.ebrusarabagca.SchoolProject.entity.Lecturer;
import dev.ebrusarabagca.SchoolProject.repository.LecturerRepository;
import dev.ebrusarabagca.SchoolProject.request.LecturerRegister;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class LecturerService {
    private final LecturerRepository lecturerRepository;
    private final LectureService lectureService;

    public Lecturer register(LecturerRegister register) {
        Lecturer lecturer = new Lecturer();

        lecturer.setFirstname(register.getFirstname());
        lecturer.setLastname(register.getLastname());
        return lecturerRepository.save(lecturer);
    }

    public void deleteLecturer(Long lecturerId) {
        Lecturer lecturer = getLecturerById(lecturerId);

        for (int i = 0; i  < lecturer.getLectureList().size(); i++) {
            lectureService.deleteLecture(lecturer.getLectureList().get(i).getLectureId(), lecturerId);
        }
        lecturerRepository.delete(lecturer);
    }

    public Lecturer getLecturerById(Long lecturerId) {
        return lecturerRepository.findById(lecturerId).orElseThrow(NoSuchElementException::new);
    }
}
