package codegym.vn.repository;

import codegym.vn.entity.Email;

import java.util.HashMap;
import java.util.Map;

public class EmailRepositoryImpl implements EmailRepository{
    private static Map<String, Email> emailMap = new HashMap<>();
    static {
        emailMap.put("setting1", new Email("English", "25",true,"Thor"));
    }

    @Override
    public void create(Email email) {

    }

    @Override
    public void update(Email email) {

    }
}
