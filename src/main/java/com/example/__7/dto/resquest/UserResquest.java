package com.example.__7.dto.resquest;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResquest {
    private String username;
    private String password;
    private String name;
    private List<String> roles;
}
