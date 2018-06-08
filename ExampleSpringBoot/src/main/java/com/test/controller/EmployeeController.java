package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.test.service.IEmployeeService;

@Controller
public class EmployeeController 
{
	@Autowired
	private IEmployeeService service ;
	
	
}
