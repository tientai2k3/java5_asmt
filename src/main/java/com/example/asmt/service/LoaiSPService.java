package com.example.asmt.service;

import com.example.asmt.entity.LoaiSP;
import com.example.asmt.repository.ILoaiSPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaiSPService implements ILoaiSPService {
    @Autowired
    private ILoaiSPRepository repository;
    @Override
    public Page<LoaiSP> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void addDongSP(LoaiSP loaiSP) {
            repository.save(loaiSP);
    }

    @Override
    public void updateLoaiSP(LoaiSP loaiSP) {
        repository.save(loaiSP);
    }

    @Override
    public void deleteLoaiSP(int id) {
        repository.deleteById(id);
    }

    @Override
    public LoaiSP findLoaiSPById(int id) {
        return repository.findLoaiSPById(id);
    }

    @Override
    public List<LoaiSP> getAll() {
        return repository.getAll();
    }
}
