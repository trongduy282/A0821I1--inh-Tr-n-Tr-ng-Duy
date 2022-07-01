package codegym.vn.controller;

import codegym.vn.entity.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailController {
    public Email EmailSave = new Email();
    @GetMapping("/view")
    public String viewCreate(Model model) {
        String[] language = {"English", "Vietnamese", "Japanese","Chinese"};
        String[] pageSize = {"5", "10", "15","20","25"};

        model.addAttribute("email", new Email());
        model.addAttribute("language", language);
        model.addAttribute("pageSize", pageSize);
        return "/views/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("email") Email email,Model model) {
        model.addAttribute("Email",email);
        return "/views/home";
    }
}
