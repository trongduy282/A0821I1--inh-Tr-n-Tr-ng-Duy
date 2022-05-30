package model.service.impl;

import model.bean.Student;
import model.repository.IStudentRepository;
import model.repository.impl.StudentRepository;
import model.service.IStudentService;

import java.util.List;

public class StudentService implements IStudentService {
    // gọi lai doi tuong StudentRepository de su dung lai ham cua no
    IStudentRepository studentRepository = new StudentRepository();
    @Override
    public List<Student> getAllStudent() {
        //vidu su dung lai ham getAllstudent ben StudentRepository
        return studentRepository.getAllStudent();
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public void save(Student student) {
        // cần kiểm tra dự liệu
        // +nếu mà ok => gọi repository để lưu.
        studentRepository.save(student);

    }

    @Override
    public void edit(Student student) {

    }

}
