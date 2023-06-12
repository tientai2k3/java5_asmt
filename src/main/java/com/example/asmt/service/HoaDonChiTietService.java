package com.example.asmt.service;

import com.example.asmt.entity.HoaDonChiTiet;
import com.example.asmt.entity.SanPham;
import com.example.asmt.repository.IHoaDonChiTietReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class HoaDonChiTietService implements IHoaDonChiTietService{
    @Autowired
    private IHoaDonChiTietReposiroty hoaDonChiTietReposiroty;
    @Override
    public List<HoaDonChiTiet> findAll() {
        return hoaDonChiTietReposiroty.findAll();
    }

    @Override
    public void addHDCT(HoaDonChiTiet hdct) {
        hoaDonChiTietReposiroty.save(hdct);
    }

    @Override
    public List<SanPham> top10BestSellingProductsByDay(Date date) {
        return hoaDonChiTietReposiroty.top10BestSellingProductsByDay(date);
    }

    @Override
    public List<SanPham> top10BestSellingProductsByWeek(Date date) {
        return hoaDonChiTietReposiroty.top10BestSellingProductsByWeek(date);
    }

    @Override
    public List<SanPham> top10BestSellingProductsByMonth(Date date) {
        return hoaDonChiTietReposiroty.top10BestSellingProductsByMonth(date);
    }

    @Override
    public List<SanPham> getLongestLastingProductsByDay(Date date) {
        return hoaDonChiTietReposiroty.getLongestLastingProductsByLeastOccurrencesByDay(date);
    }

    @Override
    public List<SanPham> getLongestLastingProductsByWeek(Date date) {
        return hoaDonChiTietReposiroty.getLongestLastingProductsByWeek(date);
    }

    @Override
    public List<SanPham> getLongestLastingProductsByMonth(Date date) {
        return hoaDonChiTietReposiroty.getLongestLastingProductsByMonth(date);
    }
}
