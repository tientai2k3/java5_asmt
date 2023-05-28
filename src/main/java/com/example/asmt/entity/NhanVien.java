package com.example.asmt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Table(name = "nhanvien")
@Entity
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    private String ten;

    @Column(name = "gioitinh")
    private String gioiTinh;

    @Column(name = "ngaysinh")
    private Date ngaySinh;

    @Column(name = "diachi")
    private String diaChi;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "matkhau")
    private String matKhau;

    @Column(name = "idcv")
    private UUID idCV;

    @Column(name = "trangthai")
    private int trangThai;

    public NhanVien(String ma, String ten, String gioiTinh, Date ngaySinh, String diaChi, String sdt, String matKhau, UUID idCV, int trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.matKhau = matKhau;
        this.idCV = idCV;
        this.trangThai = trangThai;
    }
}
