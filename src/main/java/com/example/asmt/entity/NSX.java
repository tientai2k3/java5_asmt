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

@Table(name = "nsx")
@Entity
public class NSX {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    private String ten;

    @OneToMany(mappedBy = "nsx", cascade = CascadeType.ALL)
    private List<SanPham> sanPhamList;

    public NSX(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }
}