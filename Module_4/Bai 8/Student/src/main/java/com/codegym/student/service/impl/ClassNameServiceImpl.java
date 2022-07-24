package com.codegym.student.service.impl;

import com.codegym.student.entity.ClassName;
import com.codegym.student.repository.ClassNameRepository;
import com.codegym.student.service.ClassNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassNameServiceImpl implements ClassNameService {

    @Autowired
    ClassNameRepository classNameRepository;

    @Override
    public void create(ClassName className) {
        classNameRepository.save(className);
    }

    @Override
    public void update(ClassName className) {
        classNameRepository.save(className);

    }

    @Override
    public void delete(Integer id) {
        classNameRepository.deleteById(id);
    }

    @Override
    public List<ClassName> getAll() {
        return classNameRepository.findAll();
    }

    @Override
    public ClassName findById(Integer id) {
        return classNameRepository.findById(id).orElse(null);
    }
}
