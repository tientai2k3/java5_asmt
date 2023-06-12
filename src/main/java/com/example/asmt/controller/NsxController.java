package com.example.asmt.controller;

import com.example.asmt.entity.LoaiSP;
import com.example.asmt.entity.NSX;
import com.example.asmt.service.INsxService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/nsx")
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
        model.addAttribute("data",new NSX());
        return "nsx/nsx";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable(name = "id")int id){
        service.deleteNSX(id);
        return "redirect:/admin/nsx";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute(name = "data") NSX nsx,
                            BindingResult result){
        if (result.hasErrors()){
            return "nsx/nsx";
        }
        if (service.findNSXByMa(nsx.getMa())!=null){
            result.rejectValue("ma","aaaa","Mã đã bị trùng");
            return "nsx/nsx";
        }
        service.addNSX(nsx);
        return "redirect:/admin/nsx";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable(name = "id")int id, Model model){
        NSX nsx = service.findNSXById(id);
        model.addAttribute("nsx", nsx);
        model.addAttribute("data",new NSX());
        return "nsx/detail-nsx";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable(name = "id") int id,
                         @Valid @ModelAttribute(name = "data") NSX nsx,
                         BindingResult result,
                         Model model){

        NSX nsx1 = service.findNSXById(id);
        if (result.hasErrors()){
            return "nsx/detail-nsx";
        }
        if (service.findNSXByMa(nsx.getMa())!=null){
            if (nsx1.getMa().equalsIgnoreCase(nsx.getMa())){
                nsx1.setMa(nsx.getMa());
                nsx1.setTen(nsx.getTen());
                service.updateNSX(nsx1);
                return "redirect:/admin/nsx";
            }
            result.rejectValue("ma","aaaa","Mã đã bị trùng");
            return "nsx/nsx";
        }
        nsx1.setMa(nsx.getMa());
        nsx1.setTen(nsx.getTen());
        service.updateNSX(nsx1);
        return "redirect:/admin/nsx";
    }
}
