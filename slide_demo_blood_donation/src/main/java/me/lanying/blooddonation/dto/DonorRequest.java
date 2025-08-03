package me.lanying.blooddonation.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DonorRequest {

    @NotBlank(message = "Tên không được để trống.")
    private String name;

    @Email(message = "Email không hợp lệ.")
    private String email;

    @Pattern(regexp = "^(A|B|AB|O) [+-]$", message = "Nhóm máu phải là A, B, AB hoặc O (có thể kèm + hoặc -)")
    private String bloodType;

    @Min(value = 18, message ="Phải đủ 18 tuổi để hiến máu.")
    @Max(value = 65, message = "Vượt qua giới hạn tuổi cho phép hiến máu.")
    private int age;
}
