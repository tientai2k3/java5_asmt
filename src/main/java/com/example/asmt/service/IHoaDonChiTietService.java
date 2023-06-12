package com.example.asmt.service;

import com.example.asmt.entity.HoaDonChiTiet;
import com.example.asmt.entity.SanPham;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface IHoaDonChiTietService {
    List<HoaDonChiTiet> findAll();
    void addHDCT(HoaDonChiTiet hdct);

    List<SanPham> top10BestSellingProductsByDay(@Param("date") Date date);

    List<SanPham> top10BestSellingProductsByWeek(@Param("date") Date date);

    List<SanPham> top10BestSellingProductsByMonth(@Param("date") Date date);

    List<SanPham> getLongestLastingProductsByDay(@Param("date") Date date);
    List<SanPham> getLongestLastingProductsByWeek(@Param("date") Date date);
    List<SanPham> getLongestLastingProductsByMonth(@Param("date") Date date);
}
