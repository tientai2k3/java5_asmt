package com.example.asmt.repository;

import com.example.asmt.entity.GioHang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGioHangReposiroty extends JpaRepository<GioHang, Integer> {

    GioHang findGioHangByIdAccount_Id(int id);
}
