package ua.barkalov.shop.services.converters;

import ua.barkalov.shop.DAO.model.Order;
import ua.barkalov.shop.services.dto.OrderDto;

public interface OrderConverter {
    Order toEntity(OrderDto dto);
    OrderDto toDto(Order order);
}
