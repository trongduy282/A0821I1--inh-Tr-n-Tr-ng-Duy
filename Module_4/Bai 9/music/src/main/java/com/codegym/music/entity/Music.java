package com.codegym.music.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Music {
    @Id
    @NotEmpty
    @Column(columnDefinition = "varchar(10)")
    private String id;

    @Size(max = 800)
    @NotEmpty
//    @Pattern(regexp = "^[a-zA-Z0-9]", message = "Tên không được chứa ký tự đặc biệt")
    private String name;

    @NotEmpty
    @Size(max = 300)
//    @Pattern(regexp = "^[a-zA-Z0-9]", message = "Tên không được chứa ký tự đặc biệt")
    private String artist;

    @NotEmpty
    @Size(max = 1000)

    private String genre;

    public Music() {
    }

    public Music(@NotEmpty String id, @Size(max = 800) @NotEmpty String name, @NotEmpty @Size(max = 300) String artist, @NotEmpty @Size(max = 1000) String genre) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.genre = genre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
