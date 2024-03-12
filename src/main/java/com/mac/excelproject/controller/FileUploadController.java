package com.mac.excelproject.controller;

import com.mac.excelproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/upload")
    public String uploadExcelFile(@RequestParam("file") MultipartFile file, Model model) {
        if (file.isEmpty()) {
            model.addAttribute("message", "Please select a file to upload.");
            return "upload-status";
        }

        try {
            studentService.saveStudentsFromExcel(file);
            model.addAttribute("message", "File uploaded successfully.");
        } catch (Exception e) {
            model.addAttribute("message", "Failed to upload file: " + e.getMessage());
        }

        return "upload-status";
    }
}
