package com.example.asmt.request;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoaiSPViewModel {

    private int id;

    @NotBlank(message = "Mã không được để trống")
    private String ma;

    @NotBlank(message = "Không được để trống")
    private String ten;


}
