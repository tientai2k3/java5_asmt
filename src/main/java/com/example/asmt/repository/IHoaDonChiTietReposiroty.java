package com.example.asmt.repository;

import com.example.asmt.entity.HoaDonChiTiet;
import com.example.asmt.entity.HoaDonChiTietId;
import com.example.asmt.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface IHoaDonChiTietReposiroty extends JpaRepository<HoaDonChiTiet, HoaDonChiTietId> {

    @Query("SELECT s " +
            "FROM SanPham s " +
            "JOIN HoaDonChiTiet h ON s.id = h.idSanPham.id " +
            "WHERE FUNCTION('DATE', h.idHoaDon.ngayTao) = FUNCTION('DATE', :date) " +
            "GROUP BY s " +
            "ORDER BY SUM(h.soLuong) DESC")
    List<SanPham> top10BestSellingProductsByDay(@Param("date") Date date);


    @Query("SELECT s " +
            "FROM SanPham s " +
            "JOIN HoaDonChiTiet h ON s.id = h.idSanPham.id " +
            "WHERE YEARWEEK(h.idHoaDon.ngayTao) = YEARWEEK(:date) " +
            "GROUP BY s " +
            "ORDER BY SUM(h.soLuong) DESC")
    List<SanPham> top10BestSellingProductsByWeek(@Param("date") Date date);




    @Query("SELECT s " +
            "FROM SanPham s " +
            "JOIN HoaDonChiTiet h ON s.id = h.idSanPham.id " +
            "WHERE YEAR(h.idHoaDon.ngayTao) = YEAR(:date) " +
            "AND MONTH(h.idHoaDon.ngayTao) = MONTH(:date) " +
            "GROUP BY s " +
            "ORDER BY SUM(h.soLuong) DESC")
    List<SanPham> top10BestSellingProductsByMonth(@Param("date") Date date);

    @Query("SELECT s " +
            "FROM SanPham s " +
            "LEFT JOIN HoaDonChiTiet h ON s.id = h.idSanPham.id " +
            "WHERE s.soLuongTon > 0 " +
            "AND FUNCTION('DATE', h.idHoaDon.ngayTao) = FUNCTION('DATE', :date) " +
            "GROUP BY s " +
            "ORDER BY COUNT(h) ASC")
    List<SanPham> getLongestLastingProductsByLeastOccurrencesByDay(@Param("date") Date date);


    @Query("SELECT s " +
            "FROM SanPham s " +
            "JOIN HoaDonChiTiet h ON s.id = h.idSanPham.id " +
            "WHERE s.soLuongTon > 0 " +
            "AND YEARWEEK(h.idHoaDon.ngayTao) = YEARWEEK(:date) " +
            "GROUP BY s " +
            "ORDER BY MIN(h.idHoaDon.ngayTao) ASC")
    List<SanPham> getLongestLastingProductsByWeek(@Param("date") Date date);


    @Query("SELECT s " +
            "FROM SanPham s " +
            "JOIN HoaDonChiTiet h ON s.id = h.idSanPham.id " +
            "WHERE s.soLuongTon > 0 " +
            "AND FUNCTION('YEAR', h.idHoaDon.ngayTao) = FUNCTION('YEAR', :date) " +
            "AND FUNCTION('MONTH', h.idHoaDon.ngayTao) = FUNCTION('MONTH', :date) " +
            "GROUP BY s " +
            "ORDER BY MIN(h.idHoaDon.ngayTao) ASC")
    List<SanPham> getLongestLastingProductsByMonth(@Param("date") Date date);


}
