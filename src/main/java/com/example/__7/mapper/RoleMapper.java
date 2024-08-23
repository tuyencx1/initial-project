package com.example.__7.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.__7.dto.respon.RoleRespon;
import com.example.__7.dto.resquest.RoleResquest;
import com.example.__7.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleResquest resquest);

    RoleRespon toRoleRespon(Role role);
}
