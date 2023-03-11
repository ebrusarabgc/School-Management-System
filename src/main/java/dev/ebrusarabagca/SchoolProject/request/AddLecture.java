package dev.ebrusarabagca.SchoolProject.request;

import dev.ebrusarabagca.SchoolProject.entity.Lecturer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddLecture {
    private String lectureName;
    private int credit;
    private Lecturer lecturer;
}
