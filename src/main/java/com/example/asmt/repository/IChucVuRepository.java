package com.example.asmt.repository;

import com.example.asmt.entity.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IChucVuRepository extends JpaRepository<ChucVu,Integer> {
    ChucVu findChucVuById(int id);
}
