package com.example.asmt.controller;

import com.example.asmt.entity.LoaiSP;
import com.example.asmt.request.LoaiSPViewModel;
import com.example.asmt.service.ILoaiSPService;
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
@RequestMapping("/admin/loaisp")
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
        model.addAttribute("data", new LoaiSPViewModel());
        return "loaisp/loaisp";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable(name = "id")int id){
        service.deleteLoaiSP(id);
        return "redirect:/admin/loaisp";
    }

    @PostMapping("/add")
    public String addMauSac(@Valid @ModelAttribute(name = "data")LoaiSPViewModel lspVm, BindingResult result){
        if (result.hasErrors()) {
            return "loaisp/loaisp";
        }
        if (service.findAllByMaContains(lspVm.getMa())!=null){
            result.rejectValue("ma", "aaaaaa", "Mã đã bị trùng");
            return "loaisp/loaisp";
        }
        LoaiSP loaiSP = new LoaiSP(lspVm.getMa(),lspVm.getTen());
        service.addDongSP(loaiSP);
        return "redirect:/loaisp";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable(name = "id")int id,Model model){
        LoaiSP loaiSP = service.findLoaiSPById(id);
        model.addAttribute("ms", loaiSP);
        model.addAttribute("data", new LoaiSPViewModel());
        return "loaisp/detail-loaisp";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable(name = "id") int id,
                         @Valid @ModelAttribute(name = "data")LoaiSPViewModel lspVm,
                         BindingResult result, Model model){

        LoaiSP loaiSP = service.findLoaiSPById(id);
        if (result.hasErrors()) {
            loaiSP.setMa("");
            model.addAttribute("ms", loaiSP);
            return "loaisp/detail-loaisp";
        }
        if (service.findAllByMaContains(lspVm.getMa())!=null){
            if (loaiSP.getMa().equalsIgnoreCase(lspVm.getMa())){
                loaiSP.setMa(lspVm.getMa());
                loaiSP.setTen(lspVm.getTen());
                service.updateLoaiSP(loaiSP);
                return "redirect:/admin/loaisp";
            }
            result.rejectValue("ma", "aaaaaa", "Mã đã bị trùng");
            loaiSP.setMa("");
            model.addAttribute("ms", loaiSP);
            return "loaisp/detail-loaisp";
        }

            loaiSP.setMa(lspVm.getMa());
            loaiSP.setTen(lspVm.getTen());
            service.updateLoaiSP(loaiSP);
            return "redirect:/admin/loaisp";


    }

}
