package com.codegym.music.controller;

import com.codegym.music.entity.Music;
import com.codegym.music.service.MusicService;
import com.codegym.music.validate.MusicValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MusicController {

    @Autowired
    MusicService musicService;

     @GetMapping("/list")
    public ModelAndView listMusics(){
      return new ModelAndView("list","musics",musicService.findAll());
    }

    @GetMapping("/create")
    public String CreateForm(Model model) {
        model.addAttribute("music", new Music());
        return "/create";
    }

    @PostMapping("/create")
    public String SaveMusic(@Validated @ModelAttribute Music music, BindingResult bindingResult) {
        MusicValidate validate = new MusicValidate();
        validate.validate(music, bindingResult);
        if(bindingResult.hasFieldErrors()) {
            return "/create";
        }
        musicService.create(music);
        return "redirect:/list";
    }

//    @GetMapping("/edit/{id}")
//    public ModelAndView showFormEdit(@PathVariable("id") Integer id, Model model) {
//        return new ModelAndView("/edit", "music", musicService.findById(id));
//    }
//
//    @PostMapping("/edit/{id}")
//    public String updateStudent(@PathVariable Integer id, @ModelAttribute Student student) {
//        student.setId(id);
//        studentService.update(student);
//        return "redirect:/student/list";
//    }
}
