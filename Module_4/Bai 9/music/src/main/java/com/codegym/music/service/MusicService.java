package com.codegym.music.service;

import com.codegym.music.entity.Music;

import java.util.List;

public interface MusicService {
    void create(Music music);

    void update(Music music);

    List<Music> findAll();
}
