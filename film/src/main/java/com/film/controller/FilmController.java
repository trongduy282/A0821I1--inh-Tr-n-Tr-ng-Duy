package com.film.controller;

import com.film.dto.SearchSession;
import com.film.model.News;
import com.film.service.CategoryService;
import com.film.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@SessionAttributes("searchSession")
public class FilmController {
    @Autowired
    private NewsService newsService;
    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("searchSession")
    public SearchSession setUpSearchSession() {
        return new SearchSession("","");
    }


    @GetMapping({"/list", ""})
    public String getList(Pageable page,@ModelAttribute(name = "searchSession") SearchSession searchSession,
                          @RequestParam(required = false) String searchValTitle, String searchValCategory,
                          Model model) {

        if(searchValTitle != null) {
            searchSession.setSearchValTitle(searchValTitle);
        }
//        System.out.println(searchValName);
//        if(searchValDirector != null) {
//            searchSession.setSearchValDirector(searchValDirector);
//        }
        if(searchValCategory != null) {
            searchSession.setSearchValCategory(searchValCategory);
        }
//        System.out.println(searchSession.get());
//        System.out.println(searchSession.getSearchValCategory());
//        System.out.println(searchSession.getSearchValDirector());
        model.addAttribute("newss", newsService.searchByTitleOrCategory(page,searchSession.getSearchValTitle(),searchSession.getSearchValCategory()));
        return "list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("news", new News());
        model.addAttribute("categories", categoryService.findAll());
        return "create";
    }

    @PostMapping("/create")
    public String save(@Valid @ModelAttribute News news, BindingResult bindingResult, Model model) {
        if(bindingResult.hasFieldErrors()) {
            model.addAttribute("categories", categoryService.findAll());
            return "create";
        }
        newsService.save(news);
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable Integer id, @RequestParam int page,Model model) {
        model.addAttribute("film", newsService.findById(id));
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("page", page);
        return "edit";
    }

    @PostMapping("/edit")
    public String update(@RequestParam Integer id, @RequestParam int page, @Valid @ModelAttribute News news,
                         BindingResult bindingResult, Model model) {
        if(bindingResult.hasFieldErrors()) {
            model.addAttribute("categories", categoryService.findAll());
            return "edit";
        }

        news.setId(id);
        newsService.save(news);
        return "redirect:/list" + "?page=" + page;
    }

    @GetMapping("/delete/{id}")
    public String showFormEdit(@PathVariable Integer id) {
        newsService.deleteById(id);
        return "redirect:/list";
    }
}
