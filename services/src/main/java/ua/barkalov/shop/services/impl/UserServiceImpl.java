package ua.barkalov.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.barkalov.shop.DAO.model.User;
import ua.barkalov.shop.DAO.repository.UserDao;
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

    @Transactional
    public void create(UserDto user) {
        User userEntity = userConverter.toEntity(user);
        userDao.create(userEntity);
    }

    @Transactional(readOnly = true)
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
