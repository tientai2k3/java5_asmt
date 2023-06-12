package com.example.asmt.service;

import com.example.asmt.entity.GioHang;

import java.util.List;

public interface IGioHangService {
    GioHang findGioHangByIdAccount_Id(int id);
    List<GioHang> list();
    GioHang addGioHang(GioHang gh);
    void deleteGioHang(int id);
    GioHang findById(int id);
}
