package com.example.asmt.controller;

import com.example.asmt.entity.LoaiSP;
import com.example.asmt.entity.NSX;
import com.example.asmt.entity.SanPham;
import com.example.asmt.exportExcel.ExportExcelSanPham;
import com.example.asmt.service.ILoaiSPService;
import com.example.asmt.service.INsxService;
import com.example.asmt.service.ISanPhamService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import java.util.List;

@Controller
@RequestMapping("/admin/dong-ho")
public class SanPhamController {
    @Autowired
    private ISanPhamService sanPhamService;
    @Autowired
    private ILoaiSPService loaiSPService;

    @Autowired
    private INsxService nsxService;

    @Autowired
    private ExportExcelSanPham exportExcelSanPham;

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
        model.addAttribute("data",new SanPham());
        return "san-pham/index";
    }

    //xuất
    @GetMapping("/export-excel")
    public String generateExcelReport(HttpServletResponse response) throws Exception{

        response.setContentType("application/octet-stream");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment;filename=danhSachSanPham.xls";

        response.setHeader(headerKey, headerValue);

        exportExcelSanPham.generateExcel(response);

        response.flushBuffer();

        return "redirect:/dong-ho";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable(name = "id")int id){
        sanPhamService.delete(id);
        return "redirect:/admin/dong-ho";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable(name = "id")int id,Model model){
        SanPham sanPham = sanPhamService.findSanPhamById(id);
        List<LoaiSP> listLoaiSP = loaiSPService.getAll();
        List<NSX> listNSX = nsxService.getAll();
        model.addAttribute("dsNSX",listNSX);
        model.addAttribute("dsLoaiSP",listLoaiSP);
        model.addAttribute("sp", sanPham);
        model.addAttribute("data",new SanPham());
        return "san-pham/edit";
    }

    @GetMapping("/create")
    public String viewAdd(Model model){
        List<LoaiSP> listLoaiSP = loaiSPService.getAll();
        model.addAttribute("dsLoaiSP",listLoaiSP);
        List<NSX> listNSX = nsxService.getAll();
        model.addAttribute("dsNSX",listNSX);
        model.addAttribute("data",new SanPham());
        return "san-pham/create";
    }



    @PostMapping("/add")
    public String add(Model model,
                      @Valid @ModelAttribute(name = "data") SanPham sanPham,
                      BindingResult result,
                      @RequestParam(name = "loaiSP")int loaiSP,
                      @RequestParam(name = "nsx")int idNsx,
                      @RequestParam(name = "image1") MultipartFile file1){
        LoaiSP lsp = loaiSPService.findLoaiSPById(loaiSP);
        NSX nsx1 = nsxService.findNSXById(idNsx);
        if (result.hasErrors()){

            List<LoaiSP> listLoaiSP = loaiSPService.getAll();
            List<NSX> listNSX = nsxService.getAll();
            model.addAttribute("dsNSX",listNSX);
            model.addAttribute("dsLoaiSP",listLoaiSP);
            return "san-pham/create";
        }
        if (sanPhamService.findSanPhamByMaContains(sanPham.getMa())!=null){
            List<LoaiSP> listLoaiSP = loaiSPService.getAll();
            List<NSX> listNSX = nsxService.getAll();
            model.addAttribute("dsNSX",listNSX);
            model.addAttribute("dsLoaiSP",listLoaiSP);
            result.rejectValue("ma", "aaaaaa", "Mã đã bị trùng");
            return "san-pham/create";
        }


        String image1 = "a1.jpg";
        Path path = Paths.get("C:\\Users\\admin\\Desktop\\asmt\\src\\main\\webapp\\img");
                try {
                    InputStream inputStream = file1.getInputStream();
                    Files.copy(inputStream, path.resolve(file1.getOriginalFilename()),
                            StandardCopyOption.REPLACE_EXISTING);
                    image1 = file1.getOriginalFilename().toString();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        System.out.println(image1);
        SanPham sp = new SanPham(lsp,nsx1,sanPham.getMa(), sanPham.getTen(), sanPham.getMauSac(), sanPham.getSize(), sanPham.getNamBH(), sanPham.getMoTa(),sanPham.getSoLuongTon(),sanPham.getDonGia(),image1);
        sanPhamService.addSanPham(sp);
        return "redirect:/admin/dong-ho";
    }



    @PostMapping("/update/{id}")
    public String update(Model model,
                      @PathVariable(name = "id")int id,
                         @Valid @ModelAttribute(name = "data") SanPham sanPham,
                         BindingResult result,
                         @RequestParam(name = "loaiSP")int loaiSP,
                         @RequestParam(name = "nsx")int idNsx,
                         @RequestParam(name = "image1") MultipartFile file1
    ){
        LoaiSP lsp = loaiSPService.findLoaiSPById(loaiSP);
        NSX nsx1 = nsxService.findNSXById(idNsx);
        SanPham sp = sanPhamService.findSanPhamById(id);
        if (result.hasErrors()){

            model.addAttribute("sp", sp);
            List<LoaiSP> listLoaiSP = loaiSPService.getAll();
            List<NSX> listNSX = nsxService.getAll();
            model.addAttribute("dsNSX",listNSX);
            model.addAttribute("dsLoaiSP",listLoaiSP);
            return "san-pham/edit";
        }
        String ima = sp.getImage();
        if (file1!=null){
            Path path = Paths.get("C:\\Users\\admin\\Desktop\\asmt\\src\\main\\webapp\\img");
            try {
                InputStream inputStream = file1.getInputStream();
                Files.copy(inputStream, path.resolve(file1.getOriginalFilename()),
                        StandardCopyOption.REPLACE_EXISTING);
                ima = file1.getOriginalFilename().toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        sp.setTen(sanPham.getTen());
        sp.setMa(sanPham.getMa());
        sp.setNsx(nsx1);
        sp.setLoaiSP(lsp);
        sp.setMauSac(sanPham.getMauSac());
        sp.setSize(sanPham.getSize());

        sp.setDonGia(sanPham.getDonGia());
        sp.setMoTa(sanPham.getMoTa());
        sp.setNamBH(sanPham.getNamBH());
        sp.setSoLuongTon(sanPham.getSoLuongTon());

        sp.setImage(ima);
        sanPhamService.updateSanPham(sp);
        return "redirect:/admin/dong-ho";
    }

}
