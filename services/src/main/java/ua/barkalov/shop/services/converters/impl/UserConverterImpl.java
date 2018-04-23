package ua.barkalov.shop.services.converters.impl;

import org.springframework.stereotype.Component;
import ua.barkalov.shop.dao.model.User;
import ua.barkalov.shop.services.converters.UserConverter;
import ua.barkalov.shop.services.dto.UserDto;

@Component
public class UserConverterImpl implements UserConverter {

    public User toEntity(UserDto dto) {
        return new User(
                null,
                dto.getFirstName(),
                dto.getLastName(),
                dto.getAge()
        );
    }

    public UserDto toDto(User entity) {
        return new UserDto(
                entity.getFirstName(),
                entity.getLastName(),
                entity.getAge()
        );
    }
}
