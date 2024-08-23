package com.example.__7.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.__7.dto.respon.RoleRespon;
import com.example.__7.dto.resquest.ResponsiData;
import com.example.__7.dto.resquest.RoleResquest;
import com.example.__7.service.RoleService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleController {
    RoleService roleService;

    @PostMapping("/creat")
    public ResponsiData<RoleRespon> createPermission(@RequestBody RoleResquest resquest) {
        return ResponsiData.<RoleRespon>builder()
                .data(roleService.getCreatRole(resquest))
                .build();
    }

    @GetMapping("/")
    public List<RoleRespon> getAllRole() {
        return roleService.getAllRole();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteRole(@PathVariable String id) {
        roleService.deleteRole(id);
        return "success";
    }
}
