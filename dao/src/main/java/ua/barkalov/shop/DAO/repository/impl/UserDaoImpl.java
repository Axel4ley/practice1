package ua.barkalov.shop.DAO.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.barkalov.shop.DAO.model.User;
import ua.barkalov.shop.DAO.repository.UserDao;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> findAll() {

        TypedQuery<User> findAllUsers =
                entityManager.createQuery("SELECT u FROM User u", User.class);
        return findAllUsers.getResultList();
    }

    @Override
    public void delete(Long id) {

        Query query = entityManager.createQuery("DELETE FROM User u WHERE u.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void update(Long id, User user) {
        user.setId(id);
        entityManager.merge(user);
    }

    @Override
    public User get(Long id) {
        return entityManager.find(User.class, id);
    }
}
