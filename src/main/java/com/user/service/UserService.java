package com.user.service;

import com.user.entity.UserEntity;

import java.util.List;

public interface UserService {
    public UserEntity addUser(UserEntity user);

    public List<UserEntity> findAllUser();

    public UserEntity findById(int userId);

    public UserEntity updateUser(int userId, UserEntity updatedUser);

    public UserEntity deleteUser(int userId);

    public UserEntity deleteUserByName(String name);

    public List<UserEntity> findByMarksBetween(double marks1, double marks2);
}
