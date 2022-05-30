package model.repository;

import model.bean.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> getAllStudent();
    Student findById(int id );
    void save(Student student);
    void edit(Student student);
}
