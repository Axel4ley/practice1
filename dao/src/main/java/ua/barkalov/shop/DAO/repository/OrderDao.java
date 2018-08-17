package ua.barkalov.shop.DAO.repository;

import ua.barkalov.shop.DAO.model.Order;
import ua.barkalov.shop.DAO.model.User;

import java.util.List;

public interface OrderDao {

    void create(Order order);
    List<Order> findAll();
    List<Order> findAllUserOrders(User user);
    void delete(Long id);
    void update(Long id, Order order);
    Order get(Long id);
}
