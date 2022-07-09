package com.codegym.controller;

import com.codegym.model.Song;
import com.codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping (value = "/list")
    public String getAllSong(Model model){
        List<Song> list = songService.getAll();
        model.addAttribute("listSong",list);
        return "list";
    }
    @GetMapping (value = "/create")
    public String createPage(Model model){
        model.addAttribute("song",new Song());
        return "create";
    }
    @PostMapping(value = "/create")
    public String createSong(@ModelAttribute("song") Song song){
        songService.save(song);
        return "redirect:/list";
    }
    @GetMapping ("/edit/{songId}")
    public String edit(@PathVariable(value = "songId") Integer songId, Model model ){
        Song song = songService.findById(songId);
        model.addAttribute("song",song);
        return "edit";
    }
    @PostMapping(value = "/edit")
    public String save(@ModelAttribute("song") Song song){
        songService.save(song);
        return "redirect:/list";
    }
    @GetMapping("/delete/{songId}")
    public String delete(@PathVariable(value = "songId")Integer songId){
        songService.delete(songService.findById(songId));
        return "redirect:/list";
    }
}
