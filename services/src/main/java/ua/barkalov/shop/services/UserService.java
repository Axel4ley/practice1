package ua.barkalov.shop.services;

import ua.barkalov.shop.services.dto.UserDto;

import java.util.List;

public interface UserService {

    void create(UserDto user);

    List<UserDto> findAll();
}
