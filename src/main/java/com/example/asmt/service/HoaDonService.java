package com.example.asmt.service;

import com.example.asmt.entity.HoaDon;
import com.example.asmt.repository.IHoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoaDonService implements IHoaDonService{
    @Autowired
    private IHoaDonRepository repository;

    @Override
    public List<HoaDon> findAll() {
        return repository.findAll();
    }

    @Override
    public void addHD(HoaDon hd) {
        repository.save(hd);
    }

    @Override
    public List<HoaDon> findAllByIdAccount_Id(int id) {
        return repository.findAllByIdAccount_Id(id);
    }

    @Override
    public HoaDon findById(int id) {
        return repository.findById(id).get();
    }
}
