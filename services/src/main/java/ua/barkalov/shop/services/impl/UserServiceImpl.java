package ua.barkalov.shop.services.impl;

import ua.barkalov.shop.dao.repository.UserDao;
import ua.barkalov.shop.services.UserService;
import ua.barkalov.shop.services.dto.UserDto;

public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public void create(UserDto user) {
    }
}
