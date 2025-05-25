package com.user.serviceImpl;

import com.user.entity.UserEntity;
import com.user.exception.UserNotFoundException;
import com.user.service.UserService;
import com.user.userRepo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserEntity addUser(UserEntity user) {
        return userRepo.save(user);
    }

    @Override
    public List<UserEntity> findAllUser() {
        List<UserEntity> users=userRepo.findAll();
        if(users.isEmpty()){
            throw new UserNotFoundException("Users noe=t found");
        }
        else {
            return users;
        }
    }

    @Override
    public UserEntity findById(int userId) {
        Optional<UserEntity> optional=userRepo.findById(userId);
        if(optional.isEmpty()){
            throw new UserNotFoundException("user Not Found By Id");
        }else{
            return optional.get();
        }
    }

    @Override
    public UserEntity updateUser(int userId, UserEntity updatedUser) {
        Optional<UserEntity> optional=userRepo.findById(userId);
        if(optional.isEmpty()){
            throw new UserNotFoundException("User Not found By Id to Updated the Values");
        }
        else{
            UserEntity oldUser=optional.get();
            oldUser.setName(updatedUser.getName());
            oldUser.setEmail(updatedUser.getEmail());
            oldUser.setMarks(updatedUser.getMarks());
            return userRepo.save(updatedUser);
        }
    }

    @Override
    public UserEntity deleteUser(int userId) {
        Optional<UserEntity> optional=userRepo.findById(userId);
        if(optional.isEmpty()){
            throw new UserNotFoundException("User not found by id to delete the record");
        }
        else{
            UserEntity user=optional.get();
            userRepo.delete(user);
            return user;
        }
    }

    @Override
    public UserEntity deleteUserByName(String name) {
        Optional<UserEntity> optional=userRepo.findByName(name);
        if(optional.isEmpty()){
            throw new UserNotFoundException("user not found by name");
        }
        else{
            UserEntity user=optional.get();
            userRepo.delete(user);
            return user;
        }
    }

    @Override
    public List<UserEntity> findByMarksBetween(double marks1, double marks2) {
        List<UserEntity> users=userRepo.findByMarksBetween(marks1,marks2);
        if(users.isEmpty()){
            throw new UserNotFoundException("user not found by marks");
        }
        else{
            return users;
        }
    }
}
