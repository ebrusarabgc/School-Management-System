package dev.ebrusarabagca.SchoolProject.controller;

import dev.ebrusarabagca.SchoolProject.entity.Lecture;
import dev.ebrusarabagca.SchoolProject.request.AddLecture;
import dev.ebrusarabagca.SchoolProject.service.LectureService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/lecturer")
public class LectureController {
    private LectureService service;

    @GetMapping("lectures/{lectureId}")
    public Lecture getLectureById(@PathVariable Long lectureId) {
        return service.getLectureById(lectureId);
    }

    @PostMapping("/{lecturerId}/lectures")
    public Lecture addLecture(@PathVariable Long lecturerId, @RequestBody AddLecture addLecture) {
        return service.addLecture(lecturerId, addLecture);
    }

    @DeleteMapping("/{lecturerId}/lectures/{lectureId}")
    public void deleteLecture(@PathVariable Long lectureId, @PathVariable Long lecturerId) {
        service.deleteLecture(lectureId, lecturerId);
    }

    @DeleteMapping("lectures/{lectureId}/student/{studentId}")
    public void deleteStudentById(@PathVariable Long lectureId, @PathVariable Long studentId) {
        service.deleteStudentById(studentId, lectureId);
    }
}
