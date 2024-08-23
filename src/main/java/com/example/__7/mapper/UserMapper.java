package com.example.__7.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.example.__7.dto.respon.UserResponse;
import com.example.__7.dto.resquest.UserResquest;
import com.example.__7.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "roles", ignore = true)
    User toUser(UserResquest resquest);

    UserResponse toUserRsponse(User user);

    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget User user, UserResquest request);
}
