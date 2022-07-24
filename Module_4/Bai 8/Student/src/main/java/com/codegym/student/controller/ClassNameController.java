package com.codegym.student.controller;

import com.codegym.student.entity.ClassName;
import com.codegym.student.entity.Student;
import com.codegym.student.service.ClassNameService;
import com.codegym.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
@Controller
@RequestMapping("/className")
public class ClassNameController {
    @Autowired
    StudentService studentService;

    @Autowired
    ClassNameService classNameService;

    @GetMapping("/list")
    public ModelAndView GetAll(){
        //pageNow - 1
        return new ModelAndView("/className/list","classNames",classNameService.getAll());
    }

    @GetMapping("/create")
    public String CreateForm(Model model){
        model.addAttribute("className", new ClassName());
//        model.addAttribute("classNames",classNameService.getAll());
        return "/className/create";
    }

    @PostMapping("/create")
    public String SaveClassName(@ModelAttribute ClassName className ){
        classNameService.create(className);
        return "redirect:/className/list";
    }

    @GetMapping("/edit/{classId}")
    public ModelAndView showFormEdit(@PathVariable("classId") Integer classId, Model model) {
//        model.addAttribute("classNames",classNameService.getAll());
        return new ModelAndView("/className/edit", "className", classNameService.findById(classId));
    }

    @PostMapping("/edit/{classId}")
    public String updateStudent(@PathVariable Integer classId, @ModelAttribute ClassName className) {
        className.setId(classId);
        classNameService.update(className);
        return "redirect:/className/list";
    }

    @GetMapping("/delete/{classId}")
    public ModelAndView showFormDelete(@PathVariable Integer classId) {
        return new ModelAndView("/className/delete", "className", classNameService.findById(classId));
    }

    @PostMapping("/delete/{classId}")
    public String delete(@PathVariable Integer classId) {
        classNameService.delete(classId);
        return "redirect:/className/list";
    }

    //phân trang bước 3
//    @GetMapping(value = "/listpaging")
//    public String listpaging(Model model, @RequestParam("page") Optional<Integer> page,
//                             @RequestParam("size") Optional<Integer> size) {
//        int currentPage = page.orElse(1);
//        int pageSize = size.orElse(2);
//        Page<Student> students = studentService.findAllWithPaging(PageRequest.of(currentPage - 1, pageSize));
//
//        model.addAttribute("students", students);
//        int totalPages = students.getTotalPages();
//        if (totalPages > 1) {
//            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
//                    .boxed()
//                    .collect(Collectors.toList());
//            model.addAttribute("pageNumbers", pageNumbers);
//        }
//        return "list";
//    }
}
