package ua.barkalov.shop.services;

import ua.barkalov.shop.DAO.model.User;
import ua.barkalov.shop.services.dto.UserDto;

import java.util.List;

public interface UserService {

    void create(UserDto user);
    List<UserDto> findAll();
    void delete(Long id);
    void update(Long id, UserDto user);
    User get(Long id);
}
