package com.microservices.department.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.department.entity.Department;
import com.microservices.department.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDept(Department dept) {
		log.info("Inside Save Dept Repo");
		return departmentRepository.save(dept);
	}

	public Department getDeptById(Long id) {
		log.info("Inside getDeptByID Repo");
		return departmentRepository.findById(id).get();
	}

}
