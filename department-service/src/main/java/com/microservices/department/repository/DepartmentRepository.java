package com.microservices.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.department.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department,Long>{

}
