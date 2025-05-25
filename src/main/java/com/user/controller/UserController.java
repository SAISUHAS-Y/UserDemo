package com.user.controller;

import com.user.entity.UserEntity;
import com.user.service.UserService;
import com.user.utility.ResponseStructure;
import com.user.utility.RestResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
     @Autowired
     private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<ResponseStructure<UserEntity>> addUser(@RequestBody UserEntity user){
        UserEntity users=userService.addUser(user);
        return RestResponseBuilder.success(HttpStatus.CREATED,"Successfully inserted one record in DB",users);
    }

    @GetMapping("/users")
    public ResponseEntity<ResponseStructure<List<UserEntity>>> findAllUser(){
        List<UserEntity> users=userService.findAllUser();
        return RestResponseBuilder.success(HttpStatus.FOUND,"Successfully found all the records",users);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<ResponseStructure<UserEntity>> findById(@PathVariable int userId){
        UserEntity users=userService.findById(userId);
        return RestResponseBuilder.success(HttpStatus.FOUND,"Found the use by using userId",users);
    }

    @PutMapping("users/{userId}")
    public ResponseEntity<ResponseStructure<UserEntity>> updateUser(@PathVariable int userId,@RequestBody UserEntity updatedUser){
        UserEntity users=userService.updateUser(userId,updatedUser);
        return RestResponseBuilder.success(HttpStatus.OK,"updated the record successfully",users);
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<ResponseStructure<UserEntity>> deleteUser(@PathVariable int userId){
        UserEntity users= userService.deleteUser(userId);
        return RestResponseBuilder.success(HttpStatus.OK,"deleted the record by using Id in DB",users);
    }

    @DeleteMapping("users/name/{name}")
    public ResponseEntity<ResponseStructure<UserEntity>> deleteUserByName(@PathVariable String name){
        UserEntity users= userService.deleteUserByName(name);
        return RestResponseBuilder.success(HttpStatus.OK,"deleted the record by using Id in DB",users);
    }

    @GetMapping("/users/marks/{marks1}/{marks2}")
    public ResponseEntity<ResponseStructure<List<UserEntity>>> FindMarksBetween(@PathVariable double marks1, @PathVariable double marks2){
        List<UserEntity> users= userService.findByMarksBetween(marks1,marks2);
        return RestResponseBuilder.success(HttpStatus.FOUND,"found records in between",users);
    }
}
