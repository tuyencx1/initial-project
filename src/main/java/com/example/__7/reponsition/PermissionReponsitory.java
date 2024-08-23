package com.example.__7.reponsition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.__7.entity.Permission;

@Repository
public interface PermissionReponsitory extends JpaRepository<Permission, String> {}
