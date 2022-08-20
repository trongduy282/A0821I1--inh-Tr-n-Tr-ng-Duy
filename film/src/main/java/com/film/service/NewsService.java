package com.film.service;

import com.film.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NewsService {
    Page<News> findAll(Pageable pageable);
    News save(News news);
    void deleteById(Integer id);
    News findById(Integer id);
//    Page<Film> searchByNameOrDirectorOrCategory(Pageable pageable, String searchVal);

    Page<News> searchByTitleOrCategory(Pageable pageable, String searchValTitle, String searchValCategory);
}
