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
public class Lecturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long lecturerId;

    private String firstname;
    private String lastname;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Lecture> lectureList = new ArrayList<>();
}
