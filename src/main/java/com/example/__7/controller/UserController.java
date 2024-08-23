package com.example.__7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.example.__7.dto.respon.UserResponse;
import com.example.__7.dto.resquest.ResponsiData;
import com.example.__7.dto.resquest.UserResquest;
import com.example.__7.entity.User;
import com.example.__7.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponsiData<User> addUser(@RequestBody UserResquest resquest) {
        ResponsiData responsiData = new ResponsiData();
        responsiData.setCode("200 OK");
        responsiData.setData(userService.CreateUser(resquest));
        return responsiData;
    }

    @GetMapping("/")
    public List<User> getAllUsers() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info(authentication.getName());
        authentication.getAuthorities().forEach(grantedAuthority -> log.info(grantedAuthority.getAuthority()));
        return userService.GetAllUser();
    }

    @GetMapping("/myInfo")
    public ResponsiData<User> getMyInfo() {
        return ResponsiData.<User>builder().data(userService.getMyInfo()).build();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.GetFinfById(id);
    }

    @PutMapping("/update/{id}")
    public UserResponse updateUser(@PathVariable String id, @RequestBody UserResquest userCreatDto) {
        return userService.UpdateUser(id, userCreatDto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable String id) {
        userService.DeleteUser(id);
        return "Deleted user with id " + id;
    }
}
