package com.example.asmt.controller;

import com.example.asmt.entity.LoaiSP;
import com.example.asmt.entity.NSX;
import com.example.asmt.entity.SanPham;
import com.example.asmt.service.ILoaiSPService;
import com.example.asmt.service.INsxService;
import com.example.asmt.service.ISanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/dong-ho")
public class SanPhamController {
    @Autowired
    private ISanPhamService sanPhamService;
    @Autowired
    private ILoaiSPService loaiSPService;

    @Autowired
    private INsxService nsxService;

    @GetMapping
    public String findAll(Model model
            , @RequestParam(defaultValue = "1") int page
            ,@RequestParam(required = false,name = "tenSanPham")String keyword
            ,@RequestParam(name = "min",defaultValue = "0") BigDecimal min,
                          @RequestParam(name = "max",defaultValue = "10000000000")BigDecimal max){

        Page<SanPham> list;
        if (page<1)page=1;
        Pageable pageable = PageRequest.of(page-1,3);
//        list = sanPhamService.findByTenContains(keyword,pageable);
        if (keyword==null || min==null || max==null){
            list=sanPhamService.findAll(pageable);
        }
        else {
            list = sanPhamService.findByTenContainsAndDonGiaBetween(keyword,min,max,pageable);
        }
        model.addAttribute("ds",list);
        return "san-pham/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable(name = "id")int id){
        sanPhamService.delete(id);
        return "redirect:/dong-ho";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable(name = "id")int id,Model model){
        SanPham sanPham = sanPhamService.findSanPhamById(id);
        List<LoaiSP> listLoaiSP = loaiSPService.getAll();
        List<NSX> listNSX = nsxService.getAll();
        model.addAttribute("dsNSX",listNSX);
        model.addAttribute("dsLoaiSP",listLoaiSP);
        model.addAttribute("sp", sanPham);
        return "san-pham/edit";
    }

    @GetMapping("/create")
    public String viewAdd(Model model){
        List<LoaiSP> listLoaiSP = loaiSPService.getAll();
        model.addAttribute("dsLoaiSP",listLoaiSP);
        List<NSX> listNSX = nsxService.getAll();
        model.addAttribute("dsNSX",listNSX);
        return "san-pham/create";
    }

    @PostMapping("/add")
    public String add(Model model,
                      @RequestParam(name = "ma")String ma,
                      @RequestParam(name = "ten")String ten,
                      @RequestParam(name = "mauSac")String mauSac,
                      @RequestParam(name = "size")int size,
                      @RequestParam(name = "namBH")Integer namBH,
                      @RequestParam(name = "moTa")String moTa,
                      @RequestParam(name = "soLuongTon")int soLuongTon,
                      @RequestParam(name = "donGia")BigDecimal donGia,
                      @RequestParam(name = "loaiSP")int loaiSP,
                      @RequestParam(name = "nsx")int idNsx){
        LoaiSP lsp = loaiSPService.findLoaiSPById(loaiSP);
        NSX nsx1 = nsxService.findNSXById(idNsx);
        SanPham sp = new SanPham(lsp,nsx1,ma,ten,mauSac,size,namBH,moTa,soLuongTon,donGia);
        sanPhamService.addSanPham(sp);
        return "redirect:/dong-ho";
    }



    @PostMapping("/update/{id}")
    public String update(Model model,
                      @PathVariable(name = "id")int id,
                      @RequestParam(name = "ma")String ma,
                      @RequestParam(name = "ten")String ten,
                      @RequestParam(name = "mauSac")String mauSac,
                      @RequestParam(name = "size")int size,
                      @RequestParam(name = "namBH")Integer namBH,
                      @RequestParam(name = "moTa")String moTa,
                      @RequestParam(name = "soLuongTon")int soLuongTon,
                      @RequestParam(name = "donGia")BigDecimal donGia,
                      @RequestParam(name = "loaiSP")int loaiSP,
                      @RequestParam(name = "nsx")int idNsx
    ){
        LoaiSP lsp = loaiSPService.findLoaiSPById(loaiSP);
        NSX nsx1 = nsxService.findNSXById(idNsx);
        SanPham sp = sanPhamService.findSanPhamById(id);
        sp.setNsx(nsx1);
        sp.setLoaiSP(lsp);
        sp.setMa(ma);
        sp.setTen(ten);
        sp.setMauSac(mauSac);
        sp.setSize(size);
        sp.setNamBH(namBH);
        sp.setSoLuongTon(soLuongTon);
        sp.setMoTa(moTa);
        sp.setDonGia(donGia);
        sanPhamService.updateSanPham(sp);
        return "redirect:/dong-ho";
    }

}
