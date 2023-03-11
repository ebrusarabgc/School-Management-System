package dev.ebrusarabagca.SchoolProject.repository;

import dev.ebrusarabagca.SchoolProject.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
}
