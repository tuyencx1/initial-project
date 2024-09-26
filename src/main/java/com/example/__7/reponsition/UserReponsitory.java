package com.example.__7.reponsition;

import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.__7.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReponsitory extends JpaRepository<User, String> {
    boolean existsByUsername(String userName);

    Optional<User> findByUsername(String username);
}
