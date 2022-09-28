package com.example.rest.student;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table
public class Student {
    private Long uid;
    private String name;
    private LocalDate dateOfBirth;
    private Integer age;

    public Student() {
    }

    public Student(Long uid) {
        this.uid = uid;
    }

    public Student(Long uid, String name, LocalDate dateOfBirth, Integer age) {
        this.uid = uid;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", age=" + age +
                '}';
    }
}
