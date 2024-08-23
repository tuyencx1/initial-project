package com.example.__7.dto.respon;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleRespon {
    private String name;
    private String description;
    private List<PermissionRespon> permissions;
}
