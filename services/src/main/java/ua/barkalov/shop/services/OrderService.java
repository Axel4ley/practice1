package ua.barkalov.shop.services;

import ua.barkalov.shop.services.dto.OrderDto;
import ua.barkalov.shop.services.dto.UserDto;

import java.util.List;


public interface OrderService {

    void create(OrderDto order);
    List<OrderDto> findAll();
    List<OrderDto> findAllUserOrders(UserDto user);
    void delete(Long id);
    void update(Long id, OrderDto order);
    OrderDto get(Long id);
}
