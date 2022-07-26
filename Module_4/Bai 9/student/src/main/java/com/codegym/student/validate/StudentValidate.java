package com.codegym.student.validate;

import com.codegym.student.entity.Student;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StudentValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Student.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Student student = (Student) target;
        if (String.valueOf(student.getAge()).length() > 2) {
            errors.rejectValue("age", "age", "Mày nên chết đi, già quá rồi");
        } else if (!String.valueOf(student.getAge()).startsWith("3")) {
            errors.rejectValue("age", "age", "Đừng đi học nữa");
        }
    }
}
