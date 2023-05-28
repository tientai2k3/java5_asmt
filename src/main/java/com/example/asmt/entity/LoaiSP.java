package com.example.asmt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Table(name = "loaisp")
@Entity
public class LoaiSP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    private String ten;

    @OneToMany(mappedBy = "loaiSP", cascade = CascadeType.ALL)
    private List<SanPham> sanPhamList;

    public LoaiSP(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }
}
