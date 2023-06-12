package com.example.asmt.service;

import com.example.asmt.entity.NSX;
import com.example.asmt.repository.INsxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NsxService implements INsxService{
    @Autowired
    private INsxRepository repository;
    @Override
    public Page<NSX> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void addNSX(NSX nsx) {
        repository.save(nsx);
    }

    @Override
    public void updateNSX(NSX nsx) {
        repository.save(nsx);
    }

    @Override
    public void deleteNSX(int id) {
        repository.deleteById(id);
    }

    @Override
    public NSX findNSXById(int id) {
        return repository.findNSXById(id);
    }

    @Override
    public List<NSX> getAll() {
        return repository.getAll();
    }

    @Override
    public NSX findNSXByMa(String ma) {
        return repository.findNSXByMaContains(ma);
    }
}
