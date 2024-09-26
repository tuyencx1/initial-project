package com.example.__7.dto.respon;

import java.util.List;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import com.example.__7.entity.Role;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private String username;



    private String password;

    private String name;
    private List<Role> roles;
}
