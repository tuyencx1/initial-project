package com.example.__7.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.__7.dto.resquest.PermissionResquest;
import com.example.__7.entity.Permission;
import com.example.__7.reponsition.PermissionReponsitory;

@Service
public class PermissionService {
    @Autowired
    private PermissionReponsitory permissionReponsitory;

    public Permission getCreatPermission(PermissionResquest resquest) {
        Permission permissionRespon = new Permission();
        if (checkId(resquest.getName())) {
            throw new RuntimeException("Permission already exists");
        } else {
            permissionRespon.setName(resquest.getName());
            permissionRespon.setDescription(resquest.getDescription());
            return permissionReponsitory.save(permissionRespon);
        }
    }

    public List<Permission> getAllPermissions() {
        return permissionReponsitory.findAll();
    }

    public void deletePermission(String permissionName) {
        if (!checkId(permissionName)) {
            throw new RuntimeException("Permission Not Found");
        } else {
            permissionReponsitory.deleteById(permissionName);
        }
    }

    public boolean checkId(String id) {
        return permissionReponsitory.findById(id).isPresent();
    }
}
