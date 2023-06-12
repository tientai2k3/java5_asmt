package com.example.asmt.repository;

import com.example.asmt.entity.GioHangChiTiet;
//import com.example.asmt.entity.GioHangChiTietId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IGioHangChiTietRepository extends JpaRepository<GioHangChiTiet, Integer> {
    GioHangChiTiet findGioHangChiTietByIdGioHang_Id(int id);

    Optional<GioHangChiTiet> findGioHangChiTietByIdGioHang_IdAndIdSanPham_Id(int idGioHang, int idSanPham);
}
