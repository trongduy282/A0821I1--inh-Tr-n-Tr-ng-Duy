package com.codegym.repository;

import com.codegym.model.Song;

import java.util.List;

public interface ISongRepository {
    List<Song> getAll();
    void save(Song song);
    void delete(Song song);
    Song findById(Integer songId);
}
