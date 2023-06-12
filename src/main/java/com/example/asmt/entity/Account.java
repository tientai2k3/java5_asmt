package com.example.asmt.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Table(name = "account")
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

//    @NotBlank(message = "Mã phải được nhập")
    @Column(name = "ma")
    private String ma;

    @NotBlank(message = "Tên phải được nhập")
    @Column(name = "ten")
    private String ten;

    @Column(name = "gioitinh")
    private String gioiTinh;

    @NotNull(message = "Ngày sinh phải được chọn")
    @Column(name = "ngaysinh")
    private Date ngaySinh;

    @NotBlank(message = "Địa chỉ phải được nhập")
    @Column(name = "diachi")
    private String diaChi;

    @NotBlank(message = "Số điện thoại phải được nhập")
    @Column(name = "sdt")
    private String sdt;

    @NotBlank(message = "Email phải hợp lệ")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "Mật khẩu phải được nhập")
    @Column(name = "matkhau")
    private String matKhau;

    @ManyToOne
    @JoinColumn(name = "idcv")
    private ChucVu chucVu;


    @Column(name = "trangthai")
    private int trangThai;

//    @OneToMany(mappedBy = "idaccount", cascade = CascadeType.ALL)
//    private List<HoaDon> hoaDonList;
}
