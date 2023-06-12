package com.example.asmt.utilities;

import com.example.asmt.entity.Account;
import com.example.asmt.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class AccDangNhap {

    @Autowired
    private IAccountService accountService;

    public Account account(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.isAuthenticated()){
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();
            return this.accountService.findByEmail(username);
        }
        return null;

    }
}

