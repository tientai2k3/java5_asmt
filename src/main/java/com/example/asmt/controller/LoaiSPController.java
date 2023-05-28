package com.example.asmt.controller;

import com.example.asmt.entity.LoaiSP;
import com.example.asmt.service.ILoaiSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/loaisp")
public class LoaiSPController {

    @Autowired
    private ILoaiSPService service;

    @GetMapping
    public String findAll(Model model
        , @RequestParam(defaultValue = "1") int page){

        Page<LoaiSP> list;
        if (page<1)page=1;
        Pageable pageable = PageRequest.of(page-1,3);
        list=service.findAll(pageable);
        model.addAttribute("ds",list);
        return "loaisp/loaisp";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable(name = "id")int id){
        service.deleteLoaiSP(id);
        return "redirect:/loaisp";
    }

    @PostMapping("/add")
    public String addMauSac(
                            @RequestParam(name = "ma")String ma,
                            @RequestParam(name = "ten")String ten){

        LoaiSP loaiSP = new LoaiSP(ma,ten);
        service.addDongSP(loaiSP);
        return "redirect:/loaisp";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable(name = "id")int id,Model model){
        LoaiSP loaiSP = service.findLoaiSPById(id);
        model.addAttribute("ms", loaiSP);
        return "loaisp/detail-loaisp";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable(name = "id") int id,
                         @RequestParam(name = "ma")String ma,
                         @RequestParam(name = "ten")String ten){

        LoaiSP loaiSP = service.findLoaiSPById(id);
        loaiSP.setMa(ma);
        loaiSP.setTen(ten);
        service.updateLoaiSP(loaiSP);
        return "redirect:/loaisp";
    }

}
