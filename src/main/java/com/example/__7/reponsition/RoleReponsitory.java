package com.example.__7.reponsition;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.__7.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoleReponsitory extends JpaRepository<Role, String> {
    List<Role> findByName(String roleName);
}
