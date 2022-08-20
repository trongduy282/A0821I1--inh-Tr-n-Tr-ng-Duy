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
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message="Tiêu Đề không được để trống")
//    @Max(50)

    @Size(min = 1, max = 50)
    private String title;
    @NotBlank(message="Nội Dung không được để trống")
    @Size(min = 1, max = 500)
    private String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;
//    @Min(20)
//    @Max(1000)
    @NotBlank(message="Phóng viên không được để trống")
    private String artist;

    @ManyToOne(targetEntity = Category.class)
    private Category category;

    public void setId(Integer id) {
        this.id = id;
    }
}
