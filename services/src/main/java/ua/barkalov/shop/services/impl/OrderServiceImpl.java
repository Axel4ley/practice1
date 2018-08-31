package ua.barkalov.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.barkalov.shop.DAO.model.Order;
import ua.barkalov.shop.DAO.model.Product;
import ua.barkalov.shop.DAO.repository.OrderDao;
import ua.barkalov.shop.DAO.repository.ProductDao;
import ua.barkalov.shop.DAO.repository.UserDao;
import ua.barkalov.shop.services.OrderService;
import ua.barkalov.shop.services.converters.OrderConverter;
import ua.barkalov.shop.services.converters.UserConverter;
import ua.barkalov.shop.services.dto.OrderDto;
import ua.barkalov.shop.services.dto.UserDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao;
    private final OrderConverter orderConverter;
    private final UserConverter userConverter;
    private final ProductDao productDao;
    private final UserDao userDao;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao, OrderConverter orderConverter, UserConverter userConverter, ProductDao productDao, UserDao userDao) {
        this.orderDao = orderDao;
        this.orderConverter = orderConverter;
        this.userConverter = userConverter;
        this.productDao = productDao;
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void create(OrderDto order) {
        orderDao.create(orderConverter.toEntity(order));
    }

    @Override
    @Transactional
    public List<OrderDto> findAll() {
        List<Order> orders = orderDao.findAll();
        List<OrderDto> orderDtos = new ArrayList<>();

        orders.forEach(order -> orderDtos.add(orderConverter.toDto(order)));

        return orderDtos;
    }

    @Override
    @Transactional
    public List<OrderDto> findAllUserOrders(UserDto user) {
        List<Order> userOrders = orderDao.findAllUserOrders(userConverter.toEntity(user));
        List<OrderDto> userOrderDtos = new ArrayList<>();

        userOrders.forEach(userOrder -> userOrderDtos.add(orderConverter.toDto(userOrder)));

        return userOrderDtos;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Order order = orderDao.get(id);
        Set<Product> productsInOrder = order.getProducts();

        for (Product product: productsInOrder) {
            product.getOrders().remove(order);
            productDao.update(product.getId(), product);
        }

        order.setStatus("deleted");
        orderDao.delete(id);
    }

    @Override
    @Transactional
    public void update(Long id, OrderDto order) {
        orderDao.update(id, orderConverter.toEntity(order));
    }

    @Override
    @Transactional
    public OrderDto get(Long id) {
        return orderConverter.toDto(orderDao.get(id));
    }
}
