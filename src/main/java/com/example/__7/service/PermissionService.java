package com.example.__7.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public Page<Permission> getAllPermissions(Integer page) {
        Pageable pageable = PageRequest.of(page, 2);
        return permissionReponsitory.findAll(pageable);
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
