package com.example.asmt.service;

import com.example.asmt.entity.LoaiSP;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ILoaiSPService {
    Page<LoaiSP> findAll(Pageable pageable);
    void addDongSP(LoaiSP loaiSP);
    void updateLoaiSP(LoaiSP loaiSP);
    void deleteLoaiSP(int id);
    LoaiSP findLoaiSPById(int id);
    List<LoaiSP> getAll();
    LoaiSP findAllByMaContains(String ma);
}
