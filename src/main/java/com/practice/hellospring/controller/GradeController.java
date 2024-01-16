package com.practice.hellospring.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.practice.hellospring.pojo.Grade;
import com.practice.hellospring.service.GradeService;

import jakarta.validation.Valid;

@Controller
public class GradeController {
    
    @Autowired
    GradeService gradeService;
    

    @GetMapping("/grades")
    public String getGrades(Model model) {
        model.addAttribute("grades", gradeService.getGrades());
        return "grades";
    }

    @GetMapping("/addGrades")
    public String getGradeForm(Model model, @RequestParam(required = false) String id) {
        model.addAttribute("grade", gradeService.getGradeById(id));
        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitForm(@Valid Grade grade, BindingResult result) {
        if(result.hasErrors()) return "form";
        //System.out.println(grade);
        gradeService.submitGrade(grade);
        return "redirect:/grades";
    }
}
