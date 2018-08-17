package ua.barkalov.shop.DAO.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.barkalov.shop.DAO.model.Order;
import ua.barkalov.shop.DAO.model.User;
import ua.barkalov.shop.DAO.repository.OrderDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void create(Order order) {
        order.setStatus("created");
        entityManager.persist(order);
    }

    @Override
    public List<Order> findAll() {
        TypedQuery<Order> findAllOrders = entityManager.createQuery("SELECT o FROM Order o", Order.class);
        return findAllOrders.getResultList();
    }

    @Override
    public List<Order> findAllUserOrders(User user) {
        TypedQuery<Order> findAllUserOrders = entityManager.createQuery("SELECT o FROM Order o WHERE o.user = :user", Order.class);
        findAllUserOrders.setParameter("user", user);
        return findAllUserOrders.getResultList();
    }

    @Override
    public void delete(Long id) {
        Query query = entityManager.createQuery("DELETE FROM Order o WHERE o.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void update(Long id, Order order) {
        order.setId(id);
        entityManager.merge(order);
    }

    @Override
    public Order get(Long id) {
        return entityManager.find(Order.class, id);
    }

    public OrderDaoImpl() {
    }
}
