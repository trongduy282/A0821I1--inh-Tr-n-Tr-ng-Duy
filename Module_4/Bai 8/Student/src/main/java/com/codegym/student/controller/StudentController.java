package com.codegym.student.controller;


import com.codegym.student.entity.ClassName;
import com.codegym.student.entity.Student;
import com.codegym.student.service.ClassNameService;
import com.codegym.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @Autowired
    ClassNameService classNameService;

    //Search có paging 1 trường cách james
//    @GetMapping("/list")
//    public ModelAndView listCustomers(@RequestParam("search") Optional<String> search, Pageable pageable){
//        Page<Student> students;
//        if(search.isPresent()){
//            students = studentService.findByNameContaining(search.get(), pageable);
//        } else {
//            students = studentService.findAllWithPaging(pageable);
//        }
//        ModelAndView modelAndView = new ModelAndView("/student/list");
//        modelAndView.addObject("students", students);
//        return modelAndView;
//    }

    //Cách Toàn, rối tàn bạo, có cả paging, sort, search
    @GetMapping("/list")
    public ModelAndView GetAll(Pageable page, @RequestParam Optional<String> sortBy,
                               @RequestParam(required = false) String searchBy,
                               @RequestParam(required = false) String searchVal,
                               Model model) {
//        Sort
//        String sortByTemp = sortBy.isPresent() ? sortBy.get() : "";
//        model.addAttribute("sortBy", sortByTemp);
//        return new ModelAndView("/student/list","students",studentService.sort(page, sortByTemp));
        Pageable pageable = page;
        if(sortBy.isPresent()) {
            if(sortBy.get() != "") {
                model.addAttribute("sortBy", sortBy.get());
                pageable = PageRequest.of(page.getPageNumber(), 3, Sort.by(sortBy.get()));
            }
        }
//        else model.addAttribute("sortBy", "");

        if(searchBy != null) {
            model.addAttribute("searchBy", searchBy);
            model.addAttribute("searchVal", searchVal);
        }
//        else {
//            model.addAttribute("searchBy", "");
//            model.addAttribute("searchVal", "");
//        }
        return new ModelAndView("/student/list", "students", studentService.searchAndSort(pageable, searchBy, searchVal));



//        if(sortBy.isPresent()) {
//            model.addAttribute("sortBy", sortBy.get());
//            return new ModelAndView("/student/list","students",studentService.sort(page, sortBy.get()));
//        }
//        model.addAttribute("sortBy", "");
//        //pageNow - 1
//        return new ModelAndView("/student/list", "students", studentService.findAllWithPaging(page));
    }

    @GetMapping("/create")
    public String CreateForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("classNames", classNameService.getAll());
        return "/student/create";
    }

    @PostMapping("/create")
    public String SaveStudent(@Validated @ModelAttribute Student student, BindingResult bindingResult, Model model) {
        if(bindingResult.hasFieldErrors()) {
            model.addAttribute("classNames", classNameService.getAll());
            return "/student/create";
        }
        studentService.create(student);
        return "redirect:/student/list";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("classNames", classNameService.getAll());
        return new ModelAndView("/student/edit", "student", studentService.findById(id));
    }

    @PostMapping("/edit/{id}")
    public String updateStudent(@PathVariable Integer id, @ModelAttribute Student student) {
        student.setId(id);
        studentService.update(student);
        return "redirect:/student/list";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showFormDelete(@PathVariable Integer id) {
        return new ModelAndView("/student/delete", "student", studentService.findById(id));
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        studentService.delete(id);
        return "redirect:/student/list";
    }

    //phân trang bước 3
    @GetMapping(value = "/student/listpaging")
    public String listpaging(Model model, @RequestParam("page") Optional<Integer> page,
                             @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(2);
        Page<Student> students = studentService.findAllWithPaging(PageRequest.of(currentPage - 1, pageSize));

        model.addAttribute("students", students);
        int totalPages = students.getTotalPages();
        if (totalPages > 1) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "/student/list";
    }
}
