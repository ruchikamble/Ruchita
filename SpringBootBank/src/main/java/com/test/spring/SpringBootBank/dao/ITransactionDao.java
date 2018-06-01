package com.test.spring.SpringBootBank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.spring.SpringBootBank.pojo.Transaction;

@Repository
public interface ITransactionDao extends JpaRepository<Transaction, Long> {

}
