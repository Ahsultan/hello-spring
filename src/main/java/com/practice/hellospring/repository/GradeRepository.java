package com.practice.hellospring.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.practice.hellospring.pojo.Grade;

@Repository
public class GradeRepository {

    private List<Grade> studentGrades = new ArrayList<>();

    // Arrays.asList(
    //     new Grade("Sabina", "Java", "A+"),
    //     new Grade("Rumana", "SQL", "B+"),
    //     new Grade("Mahina", "Python", "A++")
    // );
    
    public List<Grade> getGrades() {
        return studentGrades;
    }

    public Grade getGrade(int index) {
        return studentGrades.get(index);
    }

    public void addGrade(Grade grade) {
        studentGrades.add(grade);
    }

    public void updateGrade(Grade grade, int index) {
        studentGrades.set(index, grade);
    }

}
