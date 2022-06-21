package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TranslateController {
    @GetMapping("/home")
    public String getHome() {
        return "home";
    }
    //    @RequestParam dùng để nhận tham số từ view gửi về
//    model dùng để truyền dữ liệu từ controller -> View
    @PostMapping("/converter")
    public String getData(@RequestParam String text, Model model) {
        model.addAttribute("text", text);
        System.out.println(text);
        String translate = null;
        if(text.equals("hi")){
            translate="xin chao";
        }
        System.out.println(translate);
        model.addAttribute("translate", translate);
        System.out.println(translate);
        return "home";
    }

}
