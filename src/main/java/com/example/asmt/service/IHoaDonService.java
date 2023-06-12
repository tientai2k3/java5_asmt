package com.example.asmt.service;

import com.example.asmt.entity.HoaDon;

import java.util.List;

public interface IHoaDonService {
    List<HoaDon> findAll();
    void addHD(HoaDon hd);
    List<HoaDon> findAllByIdAccount_Id(int id);
    HoaDon findById(int id);
}
