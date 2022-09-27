package com.example.rest.student;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class StudentService {
    public List<Student> getStudent() {
        List<Student> studentDetails = List.of(new Student(1L, "Kane",  LocalDate.of(2000, 5, 12),23));
        return studentDetails;
    }
}
