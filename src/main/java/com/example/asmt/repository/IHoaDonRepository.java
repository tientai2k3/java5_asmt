package com.example.asmt.repository;

import com.example.asmt.entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IHoaDonRepository extends JpaRepository<HoaDon, Integer> {
    List<HoaDon> findAllByIdAccount_Id(int id);
}
