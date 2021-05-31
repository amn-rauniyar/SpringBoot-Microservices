package com.microservices.department.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.department.entity.Department;
import com.microservices.department.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/department")
@Slf4j
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/")
	public Department saveDepartment(@RequestBody Department dept) {
		log.info("Inside Save Dept Controller");
		return departmentService.saveDept(dept);
	}
	
	@GetMapping("/{id}")
	public Department getDeptById(@PathVariable("id") Long id) {
		log.info("Inside GetDeptById controller");
		return departmentService.getDeptById(id);
	}

}
