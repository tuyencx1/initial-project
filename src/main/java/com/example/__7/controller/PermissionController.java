package com.example.__7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.__7.dto.resquest.PermissionResquest;
import com.example.__7.dto.resquest.ResponsiData;
import com.example.__7.entity.Permission;
import com.example.__7.service.PermissionService;

@RestController
@RequestMapping("/per")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @PostMapping("/creat")
    public ResponsiData<Permission> createPermission(@RequestBody PermissionResquest resquest) {
        return ResponsiData.<Permission>builder()
                .data(permissionService.getCreatPermission(resquest))
                .build();
    }

    @GetMapping("/")
    public List<Permission> getAllPermission() {
        return permissionService.getAllPermissions();
    }

    @DeleteMapping("/delete/{id}")
    public String deletePermission(@PathVariable String id) {
        permissionService.deletePermission(id);
        return "success";
    }
}
