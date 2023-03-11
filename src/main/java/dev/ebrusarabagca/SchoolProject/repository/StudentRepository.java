package dev.ebrusarabagca.SchoolProject.repository;

import dev.ebrusarabagca.SchoolProject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
