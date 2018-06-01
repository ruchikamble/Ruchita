package com.test.spring.SpringBootBank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.spring.SpringBootBank.pojo.ATM;

@Repository
public interface IAtmDao extends JpaRepository<ATM, Long> 
{

}
