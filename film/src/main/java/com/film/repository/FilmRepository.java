package com.film.repository;

import com.film.model.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {
    Page<Film> findAll(Pageable pageable);
    Page<Film> findByNameContainingAndDirectorContainingAndCategory_NameContaining (Pageable pageable, String searchValName,String searchValDirector, String searchValCategory);
//    findByNameContainingOrEmailContainingOrClassName_NameContaining
}
