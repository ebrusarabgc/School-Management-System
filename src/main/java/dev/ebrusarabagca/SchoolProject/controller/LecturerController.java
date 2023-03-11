package dev.ebrusarabagca.SchoolProject.controller;

import dev.ebrusarabagca.SchoolProject.entity.Lecturer;
import dev.ebrusarabagca.SchoolProject.request.LecturerRegister;
import dev.ebrusarabagca.SchoolProject.service.LecturerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/lecturer")
public class LecturerController {
    private LecturerService service;

    @GetMapping("/{lecturerId}")
    public Lecturer getLecturerById(@PathVariable Long lecturerId) {
        return service.getLecturerById(lecturerId);
    }

    @PostMapping
    public Lecturer register(@RequestBody LecturerRegister register) {
        return service.register(register);
    }

    @DeleteMapping("{lecturerId}")
    public void deleteLecturer(@PathVariable Long lecturerId) {
        service.deleteLecturer(lecturerId);
    }
}
