package com.mac.excelproject.service;

import com.mac.excelproject.entity.Student;
import com.mac.excelproject.repository.StudentRepository;
import com.mac.excelproject.utils.ExcelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void saveStudentsFromExcel(MultipartFile file) {
        try {
            List<Student> students = ExcelHelper.excelToStudents(file.getInputStream());
            studentRepository.saveAll(students);
        } catch (Exception e) {
            throw new RuntimeException("Failed to store students data from Excel file: " + e.getMessage());
        }
    }
}