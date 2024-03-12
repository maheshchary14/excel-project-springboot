package com.mac.excelproject.utils;

import com.mac.excelproject.entity.Student;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {

    public static List<Student> excelToStudents(InputStream inputStream) throws IOException {
        try (Workbook workbook = WorkbookFactory.create(inputStream)) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            List<Student> students = new ArrayList<>();

            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // Skip header row
                if (currentRow.getRowNum() == 0) {
                    continue;
                }

                Iterator<Cell> cells = currentRow.iterator();
                Student student = new Student();

                while (cells.hasNext()) {
                    Cell currentCell = cells.next();
                    int columnIndex = currentCell.getColumnIndex();

                    switch (columnIndex) {
                        case 0:
                            student.setName(currentCell.getStringCellValue());
                            break;
                        case 1:
                            student.setAge((int) currentCell.getNumericCellValue());
                            break;
                        case 2:
                            student.setEmail(currentCell.getStringCellValue());
                            break;
                        default:
                            break;
                    }
                }

                students.add(student);
            }

            return students;
        }
    }
}
