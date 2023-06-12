package com.example.asmt.controller;

import com.example.asmt.entity.Account;
import com.example.asmt.entity.GioHang;
import com.example.asmt.entity.GioHangChiTiet;
import com.example.asmt.entity.HoaDon;
import com.example.asmt.entity.HoaDonChiTiet;
import com.example.asmt.entity.LoaiSP;
import com.example.asmt.entity.NSX;
import com.example.asmt.entity.SanPham;
import com.example.asmt.request.HoaDonViewModel;
import com.example.asmt.service.IGioHangChiTietService;
import com.example.asmt.service.IGioHangService;
import com.example.asmt.service.IHoaDonChiTietService;
import com.example.asmt.service.IHoaDonService;
import com.example.asmt.service.ILoaiSPService;
import com.example.asmt.service.INsxService;
import com.example.asmt.service.ISanPhamService;
import com.example.asmt.utilities.AccDangNhap;
import com.example.asmt.utilities.MaTuSinh;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/shop-dong-ho")
public class ShopController {

    @Autowired
    HttpSession session;

    @Autowired
    private AccDangNhap accDangNhap;

    @Autowired
    private IHoaDonChiTietService hoaDonChiTietService;

    @Autowired
    private IGioHangService gioHangService;

    @Autowired
    private IHoaDonService hoaDonService;

    @Autowired
    private ISanPhamService sanPhamService;
    @Autowired
    private ILoaiSPService loaiSPService;

    @Autowired
    private INsxService nsxService;

    @Autowired
    private IGioHangChiTietService gioHangChiTietService;

    @GetMapping
    public String findAll(Model model
            , @RequestParam(defaultValue = "1") int page
            , @RequestParam(required = false, name = "tenSanPham") String keyword
            , @RequestParam(name = "min", defaultValue = "0") BigDecimal min,
                          @RequestParam(name = "max", defaultValue = "10000000000") BigDecimal max) {

        Account account =accDangNhap.account();
        session.setAttribute("userLogin",account);
        Page<SanPham> list;
        if (page < 1) page = 1;
        Pageable pageable = PageRequest.of(page - 1, 6);
//        list = sanPhamService.findByTenContains(keyword,pageable);
        if (keyword == null) {
            list = sanPhamService.findAll(pageable);
        } else {
            list = sanPhamService.findByTenContainsAndDonGiaBetween(keyword, min, max, pageable);
        }
        model.addAttribute("ds", list);
        model.addAttribute("data", new SanPham());
        return "shop/shop";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable(name = "id") int id, Model model) {
        SanPham sanPham = sanPhamService.findSanPhamById(id);
        List<LoaiSP> listLoaiSP = loaiSPService.getAll();
        List<NSX> listNSX = nsxService.getAll();
        model.addAttribute("dsNSX", listNSX);
        model.addAttribute("dsLoaiSP", listLoaiSP);
        model.addAttribute("sp", sanPham);
        return "shop/detail-san-pham";
    }

    @GetMapping("/add-gio-hang/{idSanPham}")
    public String addGioHang(@PathVariable(name = "idSanPham") int idSanPham, @RequestParam(name = "soLuong") int soLuong, Model model) {

        Account acc = (Account) session.getAttribute("userLogin");
        System.out.println(acc.getMa());
        GioHang gh = gioHangService.findGioHangByIdAccount_Id(acc.getId());
        SanPham sp = sanPhamService.findSanPhamById(idSanPham);
        long millis = System.currentTimeMillis();
        if (gh == null) {
            gh = new GioHang();
            gh.setMa(MaTuSinh.gen("GH"));
            gh.setIdAccount(acc);
            gh.setNgayTao(new Date(millis));
            gh.setNgayThanhToan(null);
            gh.setTinhTrang(0);
            gh.setId(gioHangService.addGioHang(gh).getId());

        }
        GioHangChiTiet gioHangChiTiet = new GioHangChiTiet();
        if (gioHangChiTietService.findGioHangChiTietByIdGioHang_IdAndIdSanPham_Id(gh.getId(), idSanPham).isEmpty()) {

            gioHangChiTiet.setIdGioHang(gh);
            gioHangChiTiet.setIdSanPham(sp);
            gioHangChiTiet.setDonGia(sp.getDonGia());
            gioHangChiTiet.setDonGiaKhiGiam(sp.getDonGia());
            gioHangChiTiet.setSoLuong(soLuong);
        } else {
            gioHangChiTiet = gioHangChiTietService.findGioHangChiTietByIdGioHang_IdAndIdSanPham_Id(gh.getId(), idSanPham).get();
            gioHangChiTiet.setSoLuong(gioHangChiTiet.getSoLuong() + soLuong);
        }
        sp.setSoLuongTon(sp.getSoLuongTon() - soLuong);
        sanPhamService.updateSanPham(sp);
        gioHangChiTietService.addGHCT(gioHangChiTiet);
        return "redirect:/shop-dong-ho";

    }

    @GetMapping("/indexGioHangCT")
    public String indexGioHangChiTiet(Model model) {
        Account acc = (Account) session.getAttribute("userLogin");
        GioHang gh = gioHangService.findGioHangByIdAccount_Id(acc.getId());
        List<GioHangChiTiet> list = gh.getGioHangChiTiets();
        model.addAttribute("gh", gh);
        model.addAttribute("ds", list);
        return "shop/ds-gio-hang";
    }

    @GetMapping("/indexGioHangCT/detele/{idGHCT}")
    private String deleteSPinGHCT(@PathVariable(name = "idGHCT") int idGHCT) {

        GioHangChiTiet ghct = gioHangChiTietService.findById(idGHCT);
        SanPham sp = sanPhamService.findSanPhamById(ghct.getIdSanPham().getId());
        sp.setSoLuongTon(sp.getSoLuongTon() + ghct.getSoLuong());
        sanPhamService.updateSanPham(sp);
        gioHangChiTietService.deleteGHCT(idGHCT);
        return "redirect:/shop-dong-ho/indexGioHangCT";
    }

    @GetMapping("/indexGioHangCT/update/{idGHCT}")
    private String updateSPinGHCT(@PathVariable(name = "idGHCT") int idGHCT, @RequestParam(name = "sl") int sl) {
        GioHangChiTiet ghct = gioHangChiTietService.findById(idGHCT);

        SanPham sp = sanPhamService.findSanPhamById(ghct.getIdSanPham().getId());
        sp.setSoLuongTon(sp.getSoLuongTon() + (ghct.getSoLuong() - sl));
        sanPhamService.updateSanPham(sp);
        ghct.setSoLuong(sl);
        gioHangChiTietService.addGHCT(ghct);
        return "redirect:/shop-dong-ho/indexGioHangCT";
    }

    @GetMapping("/create-hoa-don/{idGioHang}")
    private String createHoaDon(@PathVariable(name = "idGioHang") int idGioHang,
                                Model model) {
        Account acc = (Account) session.getAttribute("userLogin");
        GioHang gh = gioHangService.findById(idGioHang);
        model.addAttribute("gh", gh);
        List<GioHangChiTiet> list = gh.getGioHangChiTiets();
        model.addAttribute("ds", list);

        int tong = 0;
        for (GioHangChiTiet x : gh.getGioHangChiTiets()) {
            tong += x.getDonGia().intValue() * x.getSoLuong();
        }
        model.addAttribute("tongTien",tong);
        model.addAttribute("hoadon", new HoaDonViewModel());
        return "shop/tao-hoa-don";
    }

    @GetMapping("ds-hoa-don")
    private String dsHoaDon(Model model) {

        Account acc = (Account) session.getAttribute("userLogin");
        List<HoaDon> list = hoaDonService.findAllByIdAccount_Id(acc.getId());
        model.addAttribute("ds", list);
        return "shop/ds-hoa-don";
    }

    @GetMapping("ds-hoa-don/xem-chi-tiet/{idHoaDon}")
    private String xemChiTietHD(Model model, @PathVariable(name = "idHoaDon") int idHoaDon) {

        HoaDon hoaDon = hoaDonService.findById(idHoaDon);
        List<HoaDonChiTiet> list = hoaDon.getHoaDonChiTiets();
        int tong = 0;
        for (HoaDonChiTiet x:list) {
            tong += x.getDonGia().intValue() * x.getSoLuong();
        }
        model.addAttribute("tongTien",tong);
        model.addAttribute("ds", list);
        return "shop/hoa-don-chi-tiet";
    }


    @PostMapping("/xac-nhan/{idGioHang}")
    public String thanhToan(@PathVariable(name = "idGioHang") int idGioHang,
                            Model model,
                            @Valid @ModelAttribute(name = "hoadon") HoaDonViewModel hoaDonViewModel,
                            BindingResult result) {

        if (result.hasErrors()) {
            return "shop/tao-hoa-don";
        }

        Account acc = (Account) session.getAttribute("userLogin");
        HoaDon hd = new HoaDon();
        hd.setIdAccount(acc);
        hd.setMa(MaTuSinh.gen("HD"));
        long millis = System.currentTimeMillis();
        hd.setNgayTao(new Date(millis));
        hd.setTinhTrang(1);
        hd.setDiaChi(hoaDonViewModel.getDiaChi());
        hd.setSdt(hoaDonViewModel.getSdt());
        hd.setTenNguoiNhan(hoaDonViewModel.getTenNguoiNhan());
        hd.setNgayThanhToan(new Date(millis));
        hoaDonService.addHD(hd);

        GioHang gh = gioHangService.findById(idGioHang);
        for (GioHangChiTiet x : gh.getGioHangChiTiets()) {
            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
            hoaDonChiTiet.setIdHoaDon(hd);
            hoaDonChiTiet.setDonGia(x.getDonGia());
            hoaDonChiTiet.setSoLuong(x.getSoLuong());
            hoaDonChiTiet.setIdSanPham(x.getIdSanPham());
            hoaDonChiTietService.addHDCT(hoaDonChiTiet);


            gioHangChiTietService.deleteGHCT(x.getId());

        }
        return "redirect:/shop-dong-ho/ds-hoa-don";
    }
}

