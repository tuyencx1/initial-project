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
public class RoleResquest {
    private String name;
    private String description;
    private List<String> permissions;
}
