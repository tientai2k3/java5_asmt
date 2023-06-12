package com.example.asmt.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Table(name = "sanpham")
@Entity
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "idloaisp")
    private LoaiSP loaiSP;

    @ManyToOne
    @JoinColumn(name = "idnsx")
    private NSX nsx;

    @NotBlank(message = "Mã không được để trống")
    @Column(name = "ma")
    private String ma;

    @NotBlank(message = "Tên không được để trống")
    @Column(name = "ten")
    private String ten;

    @Column(name = "mausac")
    private String mauSac;

    @Column(name = "size")
    private int size;

    @NotNull(message = "Năm bảo hành không được để trống")
    @Column(name = "nambh")
    private Integer namBH;

    @NotBlank(message = "Mô tả không được để trống")
    @Column(name = "mota",length = 255)
    private String moTa;

    @NotNull(message = "Số lượng không được để trống")
    @Column(name = "soluongton")
    private int soLuongTon;

    @NotNull(message = "Đơn giá không được để trống")
    @Column(name = "dongia")
    private BigDecimal donGia;

    @Column(name = "hinhanh")
    private String image;

    public SanPham(LoaiSP loaiSP, NSX nsx, @NotBlank(message = "Mã không được để trống") String ma, @NotBlank(message = "Tên không được để trống") String ten, String mauSac, int size, @NotNull(message = "Năm bảo hành không được để trống") Integer namBH, @NotBlank(message = "Mô tả không được để trống") String moTa, @NotNull(message = "Số lượng không được để trống") int soLuongTon, @NotNull(message = "Đơn giá không được để trống") BigDecimal donGia, String image) {
        this.loaiSP = loaiSP;
        this.nsx = nsx;
        this.ma = ma;
        this.ten = ten;
        this.mauSac = mauSac;
        this.size = size;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.donGia = donGia;
        this.image = image;
    }
}
