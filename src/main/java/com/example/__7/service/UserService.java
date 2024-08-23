package com.example.__7.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.__7.dto.respon.UserResponse;
import com.example.__7.dto.resquest.UserResquest;
import com.example.__7.entity.Role;
import com.example.__7.entity.User;
import com.example.__7.mapper.UserMapper;
import com.example.__7.reponsition.RoleReponsitory;
import com.example.__7.reponsition.UserReponsitory;

import lombok.val;

@Service
public class UserService {
    @Autowired
    private UserReponsitory userRepon;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleReponsitory roleReponsitory;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserResponse CreateUser(UserResquest resquest) {

        if (userRepon.existsByUsername(resquest.getUsername())) {
            throw new RuntimeException("Username already exists");
        } else {
            User user = userMapper.toUser(resquest);
            user.setPassword(passwordEncoder.encode(resquest.getPassword()));
            List<Role> roles = roleReponsitory.findAllById(resquest.getRoles());
            user.setRoles(roles);
            return userMapper.toUserRsponse(userRepon.save(user));
        }
    }

    @PreAuthorize("hasRole('ADMIN')") // chỉ admin mới truy cập đc
    public List<User> GetAllUser() {
        return userRepon.findAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    public User GetFinfById(String id) {
        return userRepon.findById(id).orElseThrow(() -> new RuntimeException("User Not Found"));
    }

    @PostAuthorize("returnObject.username == authentication.name") // tk ai người đó mới sửa đc
    public UserResponse UpdateUser(String id, UserResquest userCreatDto) {
        User user = GetFinfById(id);
        userMapper.updateUser(user, userCreatDto);
        user.setPassword(passwordEncoder.encode(userCreatDto.getPassword()));
        List<Role> roles = roleReponsitory.findAllById(userCreatDto.getRoles());
        user.setRoles(roles);
        return userMapper.toUserRsponse(userRepon.save(user));
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void DeleteUser(String id) {
        if (!checkId(id)) {
            throw new RuntimeException("User Not Found");
        } else {
            userRepon.deleteById(id);
        }
    }
    //    Kt ai đang đăng nhập
    public User getMyInfo() {
        val context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();
        User byUsername = userRepon.findByUsername(name).orElseThrow(() -> new RuntimeException("User Not Found"));
        return userRepon.save(byUsername);
    }

    public boolean checkId(String id) {
        return userRepon.findById(id).isPresent();
    }
}
