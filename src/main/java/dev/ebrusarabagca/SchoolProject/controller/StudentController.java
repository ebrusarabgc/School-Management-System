package dev.ebrusarabagca.SchoolProject.controller;

import dev.ebrusarabagca.SchoolProject.entity.Student;
import dev.ebrusarabagca.SchoolProject.request.StudentRegister;
import dev.ebrusarabagca.SchoolProject.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentService service;

    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable Long studentId) {
        return service.getStudentById(studentId);
    }

    @GetMapping("/canGraduate/{studentId}")
    public String canGraduate(@PathVariable Long studentId) {
        return service.canGraduate(studentId);
    }

    @GetMapping("/passLecture/{studentId}/lecture/{lectureId}")
    public void passLecture(@PathVariable Long studentId, @PathVariable Long lectureId) {
        service.passLecture(studentId, lectureId);
    }

    @PostMapping
    public Student register(@RequestBody StudentRegister register) {
        return service.register(register);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        service.deleteStudent(studentId);
    }

    @PostMapping("/{studentId}/lecture/{lectureId}")
    public void registerLecture(@PathVariable Long studentId, @PathVariable Long lectureId){
        service.registerLecture(studentId, lectureId);
    }

    @DeleteMapping("/{studentId}/lecture/{lectureId}")
    public void withdrawLecture(@PathVariable Long studentId,@PathVariable Long lectureId){
        service.withdrawLecture(studentId, lectureId);
    }
}
