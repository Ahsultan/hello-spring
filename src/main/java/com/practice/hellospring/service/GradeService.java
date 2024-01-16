package com.practice.hellospring.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.hellospring.pojo.Grade;
import com.practice.hellospring.repository.GradeRepository;

@Service
public class GradeService {

    @Autowired
    GradeRepository gradeRepository;

    public List<Grade> getGrades() {
        return gradeRepository.getGrades();
    }

    public Grade getGrade(int index) {
        return gradeRepository.getGrade(index);
    }

    public void addGrade(Grade grade) {
        gradeRepository.addGrade(grade);
    }

    public void updateGrade(Grade grade, int index) {
        gradeRepository.updateGrade(grade, index);
    }

    public int getGradeIndex(String id) {
        //getGrades().stream().filter(grade -> grade.getId() == id).findFirst();

        for(int i = 0; i < getGrades().size(); i++) {
            if(getGrade(i).getId().equals(id)) return i;
        }

        return -1;
    }

    public Grade getGradeById(String id) {
        int index = getGradeIndex(id);
        return index == -1 ? new Grade() : getGrade(index);
    }

    public void submitGrade(Grade grade) {
        int index = getGradeIndex(grade.getId());
        if(index == -1) {
            grade.setId(UUID.randomUUID().toString());
            addGrade(grade);
        } else {
            updateGrade(grade, index);
        }
    }
}
