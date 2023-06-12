package com.example.asmt.service;

import com.example.asmt.entity.GioHangChiTiet;

import java.util.List;
import java.util.Optional;

public interface IGioHangChiTietService {
    List<GioHangChiTiet> list();

    void addGHCT(GioHangChiTiet ghct);
    GioHangChiTiet findGioHangChiTietByIdGioHang_Id(int id);

    GioHangChiTiet findById(int id);
    void deleteGHCT(int id);

    Optional<GioHangChiTiet> findGioHangChiTietByIdGioHang_IdAndIdSanPham_Id(int idGioHang, int idSanPham);
}
