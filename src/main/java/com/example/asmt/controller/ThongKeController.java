package com.example.asmt.controller;

import com.example.asmt.entity.SanPham;
import com.example.asmt.service.IHoaDonChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/thong-ke")
public class ThongKeController {
    @Autowired
    private IHoaDonChiTietService hoaDonChiTietService;

    @GetMapping("/ban-chay-theo-ngay")
    public String thongKeTheoNgay(Model model){
        long millis = System.currentTimeMillis();
        List<SanPham> list = hoaDonChiTietService.top10BestSellingProductsByDay(new Date(millis));
        model.addAttribute("ds",list);
        model.addAttribute("a","NGÀY");
        return "thong-ke/ban-chay-theo-ngay";
    }

    @GetMapping("/ban-chay-theo-tuan")
    public String thongKeTheoTuan(Model model){
        long millis = System.currentTimeMillis();
        List<SanPham> list = hoaDonChiTietService.top10BestSellingProductsByWeek(new Date(millis));
        model.addAttribute("ds",list);
        model.addAttribute("a","TUẦN");
        return "thong-ke/ban-chay-theo-ngay";
    }

    @GetMapping("/ban-chay-theo-Thang")
    public String thongKeTheoThang(Model model){
        long millis = System.currentTimeMillis();
        List<SanPham> list = hoaDonChiTietService.top10BestSellingProductsByMonth(new Date(millis));
        model.addAttribute("ds",list);
        model.addAttribute("a","THÁNG");
        return "thong-ke/ban-chay-theo-ngay";
    }

    @GetMapping("/hang-ton-theo-ngay")
    public String hangTonTheoNgay(Model model){
        long millis = System.currentTimeMillis();
        List<SanPham> list = hoaDonChiTietService.getLongestLastingProductsByDay(new Date(millis));
        model.addAttribute("ds",list);
        model.addAttribute("a","NGÀY");
        return "thong-ke/hang-ton";
    }

    @GetMapping("/hang-ton-theo-tuan")
    public String hangTonTheoNTuan(Model model){
        long millis = System.currentTimeMillis();
        List<SanPham> list = hoaDonChiTietService.getLongestLastingProductsByWeek(new Date(millis));
        model.addAttribute("ds",list);
        model.addAttribute("a","TUẦN");
        return "thong-ke/hang-ton";
    }


    @GetMapping("/hang-ton-theo-thang")
    public String hangTonTheoThang(Model model){
        long millis = System.currentTimeMillis();
        List<SanPham> list = hoaDonChiTietService.getLongestLastingProductsByMonth(new Date(millis));
        model.addAttribute("ds",list);
        model.addAttribute("a","THÁNG");
        return "thong-ke/hang-ton";
    }

}
