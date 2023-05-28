package com.example.asmt.repository;

import com.example.asmt.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface ISanPhamRepository extends JpaRepository<SanPham, Integer> {
    SanPham findSanPhamById(int id);
    Page<SanPham> findAll(Pageable pageable);
    Page<SanPham> findByTenContainsAndDonGiaBetween(String ten, BigDecimal min, BigDecimal max,Pageable pageable);
//    Page<SanPham> findByTenContains(String ten)
    Page<SanPham> findByTenContains(String keyword,Pageable pageable);
}
