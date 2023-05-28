package com.example.asmt.service;

import com.example.asmt.entity.SanPham;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;

import java.math.BigDecimal;

public interface ISanPhamService {
    Page<SanPham> findAll(Pageable pageable);
    void addSanPham(SanPham sp);
    void updateSanPham(SanPham sp);
    void delete(int id);
    SanPham findSanPhamById(int id);
    Page<SanPham> findByTenContainsAndDonGiaBetween(String ten, BigDecimal min, BigDecimal max, Pageable pageable);
    Page<SanPham> findByTenContains(String keyword,Pageable pageable);
}
