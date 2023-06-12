package com.example.asmt.service;

import com.example.asmt.entity.GioHangChiTiet;
import com.example.asmt.repository.IGioHangChiTietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GioHangChiTietService implements IGioHangChiTietService{
    @Autowired
    private IGioHangChiTietRepository gioHangChiTietRepository;

    @Override
    public List<GioHangChiTiet> list() {
        return gioHangChiTietRepository.findAll();
    }

    @Override
    public void addGHCT(GioHangChiTiet ghct) {
        gioHangChiTietRepository.save(ghct);
    }

    @Override
    public GioHangChiTiet findGioHangChiTietByIdGioHang_Id(int id) {
        return gioHangChiTietRepository.findGioHangChiTietByIdGioHang_Id(id);
    }

    @Override
    public GioHangChiTiet findById(int id) {
        return gioHangChiTietRepository.findById(id).get();
    }

    @Override
    public void deleteGHCT(int id) {
        gioHangChiTietRepository.deleteById(id);
    }

    @Override
    public Optional<GioHangChiTiet> findGioHangChiTietByIdGioHang_IdAndIdSanPham_Id(int idGioHang, int idSanPham) {
        return gioHangChiTietRepository.findGioHangChiTietByIdGioHang_IdAndIdSanPham_Id(idGioHang, idSanPham);
    }


}
