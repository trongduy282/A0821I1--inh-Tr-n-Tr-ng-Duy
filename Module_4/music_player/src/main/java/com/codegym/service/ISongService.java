package com.codegym.service;

import com.codegym.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> getAll();
    void save(Song song);
    void delete(Song song);
    Song findById(Integer songId);
}
