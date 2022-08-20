package com.film.service.impl;

import com.film.model.News;
import com.film.repository.NewsRepository;
import com.film.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsRepository newsRepository;
    @Override
    public Page<News> findAll(Pageable pageable) {
        return newsRepository.findAll(pageable);
    }

    @Override
    public News save(News news) {
        return newsRepository.save(news);
    }

    @Override
    public void deleteById(Integer id) {
        newsRepository.deleteById(id);
    }

    @Override
    public News findById(Integer id) {
        return newsRepository.findById(id).orElse(null);
    }

    @Override
    public Page<News> searchByTitleOrCategory(Pageable pageable, String searchValTitle, String searchValCategory) {
        return newsRepository.findByTitleContainingAndCategory_NameContaining(pageable,searchValTitle,searchValCategory);
    }

//    @Override
//    public Page<Film> searchByNameOrDirectorOrCategory(Pageable pageable, String searchVal) {
//        return filmRepository.findByNameContainingOrDirectorContainingOrCategory_NameContaining(pageable, searchVal, searchVal, searchVal);
//    }
}
