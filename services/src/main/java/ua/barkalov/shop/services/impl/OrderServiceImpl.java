package ua.barkalov.shop.services.impl;

import org.springframework.transaction.annotation.Transactional;
import ua.barkalov.shop.DAO.model.Order;
import ua.barkalov.shop.DAO.repository.OrderDao;
import ua.barkalov.shop.services.OrderService;
import ua.barkalov.shop.services.converters.OrderConverter;
import ua.barkalov.shop.services.converters.UserConverter;
import ua.barkalov.shop.services.dto.OrderDto;
import ua.barkalov.shop.services.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao;
    private final OrderConverter orderConverter;
    private final UserConverter userConverter
    private final
    private final



    @Override
    @Transactional
    public void create(OrderDto order) {
        orderDao.create(orderConverter.toEntity(order));
    }

    @Override
    public List<OrderDto> findAll() {
        List<Order> orders = orderDao.findAll();
        List<OrderDto> orderDtos = new ArrayList<>();

        orders.forEach(order -> orderDtos.add(orderConverter.toDto(order)));

        return orderDtos;
    }

    @Override
    public List<OrderDto> findAllUserOrders(UserDto user) {
        List<Order> userOrders = orderDao.findAllUserOrders(userConverter.toEntity(user));
        List<OrderDto> userOrderDtos = new ArrayList<>();

        userOrders.forEach(userOrder -> userOrderDtos.add(orderConverter.toDto(userOrder)));

        return userOrderDtos;
    }

    @Override
    public void delete(Long id) {
        orderDao.delete(id);
    }

    @Override
    public void update(Long id, OrderDto order) {

    }

    @Override
    public OrderDto get(Long id) {
        return null;
    }
}
