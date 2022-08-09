package com.film.service.impl;

import com.film.model.Film;
import com.film.repository.FilmRepository;
import com.film.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    private FilmRepository filmRepository;
    @Override
    public Page<Film> findAll(Pageable pageable) {
        return filmRepository.findAll(pageable);
    }

    @Override
    public Film save(Film film) {
        return filmRepository.save(film);
    }

    @Override
    public void deleteById(Integer id) {
        filmRepository.deleteById(id);
    }

    @Override
    public Film findById(Integer id) {
        return filmRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Film> searchByNameOrDirectorOrCategory(Pageable pageable, String searchValName, String searchValDirector, String searchValCategory) {
        return filmRepository.findByNameContainingAndDirectorContainingAndCategory_NameContaining(pageable,searchValName,searchValDirector,searchValCategory);
    }

//    @Override
//    public Page<Film> searchByNameOrDirectorOrCategory(Pageable pageable, String searchVal) {
//        return filmRepository.findByNameContainingOrDirectorContainingOrCategory_NameContaining(pageable, searchVal, searchVal, searchVal);
//    }
}
