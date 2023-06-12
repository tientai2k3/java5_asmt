package com.example.asmt.repository;

import com.example.asmt.entity.LoaiSP;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ILoaiSPRepository extends JpaRepository<LoaiSP,Integer> {
    LoaiSP findLoaiSPById(int id);
    Page<LoaiSP> findAll(Pageable pageable);

    LoaiSP findAllByMaContains(String ma);
    @Query("SELECT lsp FROM LoaiSP lsp")
    List<LoaiSP> getAll();
}
