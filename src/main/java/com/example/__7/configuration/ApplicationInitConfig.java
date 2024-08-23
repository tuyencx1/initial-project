package com.example.__7.configuration;

import java.util.HashSet;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.__7.entity.RoleEnum;
import com.example.__7.entity.User;
import com.example.__7.reponsition.UserReponsitory;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ApplicationInitConfig {

    PasswordEncoder passwordEncoder;

    @Bean
    ApplicationRunner applicationRunner(UserReponsitory userReponsitory) {
        return args -> {
            if (userReponsitory.findByUsername("admin").isEmpty()) {
                var roles = new HashSet<String>();
                roles.add(RoleEnum.ADMIN.name());

                User user = User.builder()
                        .username("admin")
                        .password(passwordEncoder.encode("admin"))
                        //                        .roles(roles)
                        .build();
                userReponsitory.save(user);
                log.warn("User admin has been created with account and password: admin");
            }
        };
    }
}