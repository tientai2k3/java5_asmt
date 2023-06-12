package com.example.asmt.service;

import com.example.asmt.entity.Account;
import com.example.asmt.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountService implements IAccountService{
    @Autowired
    private IAccountRepository repository;

    @Override
    public List<Account> findAll() {
        return repository.findAll();
    }

    @Override
    public Account findByEmail(String email) {
        return repository.findByEmailContains(email);
    }

    @Override
    public void add(Account acc) {
        repository.save(acc);
    }

    @Override
    public Account checkLogin(String email, String matKhau) {
        return repository.checkLogin(email,matKhau);
    }

    @Override
    public List<Account> findAccountByChucVu_Ten(String ten) {
        return repository.findAccountByChucVu_Ten(ten);
    }


}
