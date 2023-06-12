package com.example.asmt.repository;

import com.example.asmt.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAccountRepository extends JpaRepository<Account,Integer> {
    Account findByEmailContains(String email);

    @Query("SELECT acc FROM Account acc WHERE acc.email =:email AND acc.matKhau =:matKhau")
    Account checkLogin(@Param("email") String email,@Param("matKhau") String matKhau);

    List<Account> findAccountByChucVu_Ten(String ten);
}
