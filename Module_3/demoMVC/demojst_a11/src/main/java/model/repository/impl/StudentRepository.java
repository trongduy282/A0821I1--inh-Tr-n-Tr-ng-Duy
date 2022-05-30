package model.repository.impl;

import model.bean.Student;
import model.repository.IStudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    // tạo 1 list giả để dùng tạm
    //lay du lieu tu database len de xu ly
    public static List<Student> studentList = new ArrayList<>();
    static {
        studentList.add(new Student(1, "tuấn", true, "12/12/2022", 9, "tuanvn", 1, "chanhtv235@gmial.com"));
        studentList.add(new Student(2, "trâm", false, "12/12/2022", 8, "tram", 2, "chanhtv235@gmial.com"));
        studentList.add(new Student(3, "lịch", true, "12/12/2022", 7, "lichhn", 2, "chanhtv235@gmial.com"));
        studentList.add(new Student(4, "hải", true, "12/12/2022", 6, "haitt", 3, "chanhtv235@gmial.com"));
        studentList.add(new Student(5, "chánh", true, "12/12/2022", 4, "chanhtv", 1, "chanhtv235@gmial.com"));

    }
    @Override
    //implement cac phuong thuc cua interface cuar IStudentRepository
    public List<Student> getAllStudent() {
        // kết nối database => lấy list
        return studentList;
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public void save(Student student) {
        studentList.add(student);
    }

    @Override
    public void edit(Student student) {

    }
}
