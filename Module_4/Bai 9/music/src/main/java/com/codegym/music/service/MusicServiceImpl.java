package com.codegym.music.service;

import com.codegym.music.entity.Music;
import com.codegym.music.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicServiceImpl implements MusicService{

    @Autowired
    MusicRepository musicRepository;

    @Override
    public void create(Music music) {
        musicRepository.save(music);
    }

    @Override
    public void update(Music music) {
        musicRepository.save(music);
    }

    @Override
    public List<Music> findAll() {
        return musicRepository.findAll();
    }
}
