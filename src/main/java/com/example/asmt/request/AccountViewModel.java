package com.example.asmt.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountViewModel {
    @NotBlank(message = "Email phải được nhập")
    private String email;

    @NotBlank(message = "Mật khẩu phải được nhập")
    private String matKhau;
}
