package ua.barkalov.shop.dao.repository;

import ua.barkalov.shop.dao.model.User;

import java.util.List;

public interface UserDao {

    void create(User user);

    List<User> findAll();
}
