package com.film.repository;

import com.film.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {
    Page<News> findAll(Pageable pageable);

//    Page<News> findByTitleContainingAndCategory_NameContaining (Pageable pageable, String searchValTitle, String searchValCategory);
//    findByNameContainingOrEmailContainingOrClassName_NameContaining
Page<News> findByTitleContainingAndCategory_NameContaining(Pageable pageable, String searchValTitle, String searchValCategory);

}
