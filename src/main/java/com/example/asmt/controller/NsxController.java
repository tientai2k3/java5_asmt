package com.example.asmt.controller;

import com.example.asmt.entity.LoaiSP;
import com.example.asmt.entity.NSX;
import com.example.asmt.service.INsxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/nsx")
public class NsxController {
    @Autowired
    private INsxService service;

    @GetMapping
    public String findAll(Model model
            , @RequestParam(defaultValue = "1") int page){

        Page<NSX> list;
        if (page<1)page=1;
        Pageable pageable = PageRequest.of(page-1,3);
        list=service.findAll(pageable);
        model.addAttribute("ds",list);
        return "nsx/nsx";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable(name = "id")int id){
        service.deleteNSX(id);
        return "redirect:/nsx";
    }

    @PostMapping("/add")
    public String addMauSac(
            @RequestParam(name = "ma")String ma,
            @RequestParam(name = "ten")String ten){
        NSX nsx = new NSX(ma,ten);
        service.addNSX(nsx);
        return "redirect:/nsx";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable(name = "id")int id, Model model){
        NSX nsx = service.findNSXById(id);
        model.addAttribute("nsx", nsx);
        return "nsx/detail-nsx";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable(name = "id") int id,
                         @RequestParam(name = "ma")String ma,
                         @RequestParam(name = "ten")String ten){

        NSX nsx = service.findNSXById(id);
        nsx.setMa(ma);
        nsx.setTen(ten);
        service.updateNSX(nsx);
        return "redirect:/nsx";
    }
}
