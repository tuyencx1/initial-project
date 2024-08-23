package com.example.__7.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.__7.dto.respon.RoleRespon;
import com.example.__7.dto.resquest.RoleResquest;
import com.example.__7.entity.Permission;
import com.example.__7.entity.Role;
import com.example.__7.mapper.RoleMapper;
import com.example.__7.reponsition.PermissionReponsitory;
import com.example.__7.reponsition.RoleReponsitory;

@Service
public class RoleService {
    @Autowired
    private RoleReponsitory roleReponsitory;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionReponsitory permissionReponsitory;

    public RoleRespon getCreatRole(RoleResquest resquest) {
        Role role = roleMapper.toRole(resquest);
        List<Permission> permissionList = permissionReponsitory.findAllById(resquest.getPermissions());
        role.setPermissions(permissionList);
        return roleMapper.toRoleRespon(roleReponsitory.save(role));
    }

    public List<RoleRespon> getAllRole() {
        return roleReponsitory.findAll().stream().map(roleMapper::toRoleRespon).toList();
    }

    public void deleteRole(String role) {
        if (!checkId(role)) {
            throw new RuntimeException("Permission Not Found");
        } else {
            roleReponsitory.deleteById(role);
        }
    }

    public boolean checkId(String id) {
        return roleReponsitory.findById(id).isPresent();
    }
}
