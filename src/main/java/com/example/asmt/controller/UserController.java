package com.example.asmt.controller;

import com.example.asmt.entity.Account;
import com.example.asmt.entity.ChucVu;
import com.example.asmt.request.AccountViewModel;
import com.example.asmt.service.IAccountService;
import com.example.asmt.service.IChucVuService;
import com.example.asmt.utilities.MaTuSinh;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private IAccountService service;

    @Autowired
    HttpSession session;

    @Autowired
    private IChucVuService chucVuService;

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("data", new AccountViewModel());
        return "account/login";
    }

    @PostMapping("/dang-nhap")
    public String dangNhap(@Valid @ModelAttribute(name = "data") AccountViewModel account, BindingResult result){
        if (result.hasErrors()){
            return "account/login";
        }

        if (service.checkLogin(account.getEmail(),account.getMatKhau())== null){
            result.rejectValue("email", "aaaaaa", "Email hoặc mật khẩu không đúng");
            result.rejectValue("matKhau", "aaaaaa", "Email hoặc mật khẩu không đúng");
            return "account/login";
        }else {
            System.out.println("ok");
        Account acc = service.findByEmail(account.getEmail());
        session.setAttribute("userLogin",acc);
        System.out.println("ok");
        return "redirect:/shop-dong-ho";
        }
    }

    @GetMapping("/dang-ki")
    public String dangKi(Model model){
        model.addAttribute("data", new Account());
        return "account/dang-ki";
    }

    @GetMapping("/logout")
    public String dangXuat(){
        session.removeAttribute("userLogin");
        return "redirect:/shop-dong-ho";
    }

    @PostMapping("/dang-ki")
    public String dangKi1(@Valid @ModelAttribute(name = "data") Account account, BindingResult result){
        if (result.hasErrors()){
            return "account/dang-ki";
        }
        Account acc = new Account();
        ChucVu chucVu = chucVuService.findById(2);
        acc.setChucVu(chucVu);
        acc.setMa(MaTuSinh.gen("KH"));
        acc.setTen(account.getTen());
        acc.setGioiTinh(account.getGioiTinh());
        acc.setNgaySinh(account.getNgaySinh());
        acc.setDiaChi(account.getDiaChi());
        acc.setSdt(account.getSdt());
        acc.setEmail(account.getEmail());
        acc.setMatKhau(account.getMatKhau());
        acc.setTrangThai(0);

        service.add(acc);
        return "redirect:/login";
    }
}
