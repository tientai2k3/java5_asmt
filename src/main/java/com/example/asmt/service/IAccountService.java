package com.example.asmt.service;

import com.example.asmt.entity.Account;

import java.util.List;

public interface IAccountService {
    List<Account> findAll();
    Account findByEmail(String email);
    void add(Account acc);
    Account checkLogin(String email, String matKhau);
    List<Account> findAccountByChucVu_Ten(String ten);
}
