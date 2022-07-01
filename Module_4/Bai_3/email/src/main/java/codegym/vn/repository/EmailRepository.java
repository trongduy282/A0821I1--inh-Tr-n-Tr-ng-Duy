package codegym.vn.repository;

import codegym.vn.entity.Email;

import java.util.List;

public interface EmailRepository {
    void create(Email email);
    void update(Email email);
//    void delete(String id);
//    List<Email> findAll();
//    Email findById(String id);
}
