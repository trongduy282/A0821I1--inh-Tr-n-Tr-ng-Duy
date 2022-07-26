package com.codegym.music.validate;

import com.codegym.music.entity.Music;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class MusicValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Music.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Music music = (Music) target;
        if(!music.getName().matches("[a-z A-Z]*")) {
            errors.rejectValue("name","song.symbol","Invalid input");
        }
        if(!music.getArtist().matches("[a-z A-Z]*")) {
            errors.rejectValue("artist","song.symbol","Invalid input");
        }
        if(!music.getGenre().matches("[a-z A-Z \\,]*")) {
            errors.rejectValue("genre","song.symbol","Invalid input");
        }
    }
}
