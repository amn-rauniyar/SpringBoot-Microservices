package com.microservices.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.user.entity.User;
import com.microservices.user.repository.UserRepository;
import com.microservices.user.vo.Department;
import com.microservices.user.vo.ResponseTemplateVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		log.info("Inside saveUser Repository");
		return userRepository.save(user);
	}

	public ResponseTemplateVO getUserWithDept(Long userId) {
		log.info("Inside getUserWithDept Repository");
		ResponseTemplateVO vo = new ResponseTemplateVO();
		User user = userRepository.findById(userId).get();
		
		Department dept = 
		restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/"+user.getDeptId()
			, Department.class);
		
		vo.setUser(user);
		vo.setDepartment(dept);
		return vo;
	}

}
