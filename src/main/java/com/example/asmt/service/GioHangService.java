package com.example.asmt.service;

import com.example.asmt.entity.GioHang;
import com.example.asmt.repository.IGioHangReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GioHangService implements IGioHangService{

    @Autowired
    private IGioHangReposiroty reposiroty;
    @Override
    public GioHang findGioHangByIdAccount_Id(int id) {
        return reposiroty.findGioHangByIdAccount_Id(id);
    }

    @Override
    public List<GioHang> list() {
        return reposiroty.findAll();
    }

    @Override
    public GioHang addGioHang(GioHang gh) {
        return reposiroty.save(gh);
    }

    @Override
    public void deleteGioHang(int id) {
        reposiroty.deleteById(id);
    }

    @Override
    public GioHang findById(int id) {
        return reposiroty.findById(id).get();
    }
}
