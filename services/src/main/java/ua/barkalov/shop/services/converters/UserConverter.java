package ua.barkalov.shop.services.converters;

import ua.barkalov.shop.dao.model.User;
import ua.barkalov.shop.services.dto.UserDto;

public interface UserConverter {

    User toEntity(UserDto dto);

    UserDto toDto(User entity);
}
