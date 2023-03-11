package dev.ebrusarabagca.SchoolProject.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRegister {
    private String firstname;
    private String lastname;
    private double GPA;
}
