package com.film.service;

import com.film.model.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FilmService {
    Page<Film> findAll(Pageable pageable);
    Film save(Film film);
    void deleteById(Integer id);
    Film findById(Integer id);
//    Page<Film> searchByNameOrDirectorOrCategory(Pageable pageable, String searchVal);

    Page<Film> searchByNameOrDirectorOrCategory(Pageable pageable, String searchValName, String searchValDirector, String searchValCategory);
}
