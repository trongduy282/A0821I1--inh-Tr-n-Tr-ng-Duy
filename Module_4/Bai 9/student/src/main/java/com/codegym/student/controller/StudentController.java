package com.codegym.student.controller;

import com.codegym.student.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
    @GetMapping("/student")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("student", new Student());
        return modelAndView;
    }

    @PostMapping("/validateStudent")
    public ModelAndView checkValidation(@Validated @ModelAttribute("student") Student student, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/index");
        }
        return new ModelAndView("/result");
    }
}
