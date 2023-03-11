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
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentId;

    private String firstname;
    private String lastname;
    private double GPA;
    private int totalCredit;

    @ManyToMany
    private List<Lecture> semesterLectureList = new ArrayList<>();

    @ManyToMany
    private List<Lecture> passedLectureList = new ArrayList<>();
}
