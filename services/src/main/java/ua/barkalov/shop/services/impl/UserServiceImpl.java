package ua.barkalov.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.barkalov.shop.dao.model.User;
import ua.barkalov.shop.dao.repository.UserDao;
import ua.barkalov.shop.services.UserService;
import ua.barkalov.shop.services.converters.UserConverter;
import ua.barkalov.shop.services.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final UserConverter userConverter;

    @Autowired
    public UserServiceImpl(UserDao userDao, UserConverter userConverter) {
        this.userDao = userDao;
        this.userConverter = userConverter;
    }

    public void create(UserDto user) {
        User userEntity = userConverter.toEntity(user);
        userDao.create(userEntity);
    }

    public List<UserDto> findAll() {
        List<User> users = userDao.findAll();

        List<UserDto> userDtos = new ArrayList<>();

        for (User user : users) {
            UserDto dto = userConverter.toDto(user);
            userDtos.add(dto);
        }

        return userDtos;
    }
}
