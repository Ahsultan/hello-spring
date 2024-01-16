package com.practice.hellospring.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.practice.hellospring.pojo.Show;




@Controller
public class MovieController {
        

    @GetMapping("/")
    public ModelAndView getShows() {
        HashMap<String, Show> model = new HashMap<String, Show>();

        model.put("first", new Show("Breaking Bad", "Ozymandias", 10.0));
        model.put("second", new Show("Test", "Tiger1", 8.5));

        return new ModelAndView("shows", model);
    }

    @GetMapping("/conditions")
    public String getConditions(Model model) {

        model.addAttribute("speed", 45);
        model.addAttribute("flower", "red");

        model.addAttribute("budget", 10000);
        model.addAttribute("make", "Toyota");

        model.addAttribute("name", "Ahmed");


        return "conditions";
    }
    
    
    
    
}
