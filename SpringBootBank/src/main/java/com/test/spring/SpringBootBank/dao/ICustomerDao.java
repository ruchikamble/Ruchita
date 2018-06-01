package com.test.spring.SpringBootBank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.spring.SpringBootBank.pojo.Customer;

@Repository
public interface ICustomerDao extends JpaRepository<Customer, Long>
{

}
