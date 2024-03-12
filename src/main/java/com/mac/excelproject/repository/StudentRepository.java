package com.mac.excelproject.repository;

import com.mac.excelproject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
