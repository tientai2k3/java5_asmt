package com.example.asmt.service;

import com.example.asmt.entity.ChucVu;
import com.example.asmt.repository.IChucVuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChucVuService implements IChucVuService{
    @Autowired
    private IChucVuRepository repository;
    @Override
    public ChucVu findById(int id) {
        return repository.findChucVuById(id);
    }
}
