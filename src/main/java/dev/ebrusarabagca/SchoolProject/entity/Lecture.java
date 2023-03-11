package dev.ebrusarabagca.SchoolProject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long lectureId;

    private String lectureName;
    private int credit;

    @ManyToOne
    private Lecturer lecturer;

    @ManyToMany
    private List<Student> studentList = new ArrayList<>();
}
