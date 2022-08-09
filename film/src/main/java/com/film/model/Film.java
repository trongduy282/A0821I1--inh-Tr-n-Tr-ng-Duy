package com.film.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message="Tên không được để trống")
    private String name;
    @NotBlank(message="Đạo diễn không được để trống")
    private String director;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;
    @Min(20)
    @Max(1000)
    private double price;

    @ManyToOne(targetEntity = Category.class)
    private Category category;

    public void setId(Integer id) {
        this.id = id;
    }
}
