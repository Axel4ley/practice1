package ua.barkalov.shop.DAO.repository;

import ua.barkalov.shop.DAO.model.User;

import java.util.List;

public interface UserDao {

    void create(User user);
    User get(Long id);
    List<User> findAll();
    void delete(Long id);
    void update(Long id, User user);

}
