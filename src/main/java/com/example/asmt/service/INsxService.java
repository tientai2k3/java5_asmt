package com.example.asmt.service;

import com.example.asmt.entity.NSX;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface INsxService {
    Page<NSX> findAll(Pageable pageable);
    void addNSX(NSX nsx);
    void updateNSX(NSX nsx);
    void deleteNSX(int id);
    NSX findNSXById(int id);
    List<NSX> getAll();
    NSX findNSXByMa(String ma);
}
