package com.example.asmt.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    private String ten;

    @Column(name = "mausac")
    private String mauSac;

    @Column(name = "size")
    private int size;

    @Column(name = "nambh")
    private Integer namBH;

    @Column(name = "mota")
    private String moTa;

    @Column(name = "soluongton")
    private int soLuongTon;

    @Column(name = "giaban")
    private BigDecimal donGia;

    public SanPham(LoaiSP loaiSP, NSX nsx, String ma, String ten, String mauSac, int size, Integer namBH, String moTa, int soLuongTon, BigDecimal donGia) {
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
    }
}
