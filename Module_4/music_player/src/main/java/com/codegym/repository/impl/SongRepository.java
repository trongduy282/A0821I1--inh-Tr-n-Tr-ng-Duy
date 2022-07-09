package com.codegym.repository.impl;

import com.codegym.model.Song;
import com.codegym.repository.ISongRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.List;
@Repository
public class SongRepository implements ISongRepository {


    @Override
    public List<Song> getAll() {
        List<Song> songs = BaseRepository.entityManager.createQuery("select s from Song s",Song.class).getResultList();
        return songs;
    }

    @Override
    public void save(Song song) {
        EntityTransaction entityTransaction =BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        if(song.getSongId()== null){
            BaseRepository.entityManager.persist(song);
        }
        else BaseRepository.entityManager.merge(song);
        entityTransaction.commit();
    }

    @Override
    public void delete(Song song) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        // persist tương ứng với save, create; merge tương ứng với update
        BaseRepository.entityManager.remove(song);
        entityTransaction.commit();
    }
    @Override
    public Song findById(Integer songId){
        Song song = BaseRepository.entityManager.createQuery("select s from Song s where songId = :code", Song.class).setParameter("code", songId).getSingleResult();
        return song;
    }
}
