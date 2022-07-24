package com.codegym.student.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 5, max = 15, message = "Tên độ dài từ 5 đến 15")
    @NotEmpty(message = "Tên không được rỗng")
    private String name;

    @Email
    private String email;

    private boolean gender;

    @Size(min = 10, max = 10)
    private String phoneNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @ManyToOne(targetEntity = ClassName.class)
    private ClassName className;

    public Student() {
    }

    public Student(Integer id, String name, String email, boolean gender, String phoneNumber, Date birthday, ClassName className) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.className = className;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public ClassName getClassName() {
        return className;
    }

    public void setClassName(ClassName className) {
        this.className = className;
    }
}
