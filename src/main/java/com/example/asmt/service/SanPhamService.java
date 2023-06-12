package com.example.asmt.service;

import com.example.asmt.entity.SanPham;
import com.example.asmt.repository.ISanPhamRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SanPhamService implements ISanPhamService{
    @Autowired
    private ISanPhamRepository repository;
    @Override
    public Page<SanPham> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void addSanPham(SanPham sp) {
        repository.save(sp);
    }

    @Override
    public void updateSanPham(SanPham sp) {
        repository.save(sp);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public SanPham findSanPhamById(int id) {
        return repository.findSanPhamById(id);
    }

    @Override
    public Page<SanPham> findByTenContainsAndDonGiaBetween(String ten, BigDecimal min, BigDecimal max, Pageable pageable) {
        return repository.findByTenContainsAndDonGiaBetween(ten,min,max,pageable);
    }

    @Override
    public Page<SanPham> findByTenContains(String keyword,Pageable pageable) {
        return repository.findByTenContains(keyword,pageable);
    }

    @Override
    public List<SanPham> getAll() {
        return repository.getAll();
    }

    @Override
    public SanPham findSanPhamByMaContains(String ma) {
        return repository.findSanPhamByMaContains(ma);
    }
}
