package com.example.__7.dto.resquest;

import java.util.List;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResquest {
    @Size(min = 3, message = "Ten it nhat 3 ky tu !")
    private String username;

    @Size(min = 8, message = "Mật khẩu có ít nhất 8 ký tự")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$",
            message = "Mật khẩu phải chứa ít nhất 1 chữ cái viết hoa,1 ký tự đặc biệt và 1 số")
    private String password;
    private String name;
    private List<String> roles;
}
