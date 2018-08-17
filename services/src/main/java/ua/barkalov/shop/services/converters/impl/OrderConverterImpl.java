package ua.barkalov.shop.services.converters.impl;

import ua.barkalov.shop.DAO.model.Order;
import ua.barkalov.shop.services.converters.OrderConverter;
import ua.barkalov.shop.services.dto.OrderDto;

public class OrderConverterImpl implements OrderConverter {
    @Override
    public Order toEntity(OrderDto dto) {
        return new Order(null,
                dto.getUser(),
                dto.getProducts(),
                dto.getStatus(),
                dto.getDate());
    }

    @Override
    public OrderDto toDto(Order entity) {
        return new OrderDto(entity.getUser(), entity.getProducts(), entity.getStatus(), entity.getDate());
    }
}
