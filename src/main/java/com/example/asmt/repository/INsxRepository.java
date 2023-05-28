package com.example.asmt.repository;

import com.example.asmt.entity.NSX;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface INsxRepository extends JpaRepository<NSX,Integer> {
    Page<NSX> findAll(Pageable pageable);
    NSX findNSXById(int id);

    @Query("SELECT nsx FROM NSX  nsx")
    List<NSX> getAll();
}
