package com.example.rest;

import com.example.rest.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@RestController
public class SprinBootRestApplication {

    private static String username = "";
    private static IdentityCache cacheRef;
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SprinBootRestApplication.class, args);
        IdentityCache reference = context.getBean(IdentityCache.class);
        SprinBootRestApplication.cacheRef = reference;
        reference.setUserName("Himesh");
        SprinBootRestApplication.username = reference.getUserName();
        SprinBootRestApplication.username = reference.getUserName();
    }

    @GetMapping
//    Use of the generic type in java
    public List<Object> demoEndpoint() {
        List<Student> studentDetails = List.of(new Student(1L, "Kane",  LocalDate.of(2000, 5, 12),23));
        List<String> loginDetails = List.of("Hello", SprinBootRestApplication.username, SprinBootRestApplication.cacheRef.showLogin());
        return List.of(studentDetails, loginDetails);
    }
}
