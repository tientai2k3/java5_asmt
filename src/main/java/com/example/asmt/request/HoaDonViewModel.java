package com.example.asmt.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HoaDonViewModel {
    @NotBlank(message = "Phải nhập tên người nhận")
    private String tenNguoiNhan;


    @NotBlank(message = "Phải nhập địa chỉ")
    private String diaChi;


    @NotBlank(message = "Phải nhập số điện thoại")
    private String sdt;
}
