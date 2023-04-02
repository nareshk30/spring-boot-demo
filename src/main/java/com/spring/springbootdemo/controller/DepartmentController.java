package com.spring.springbootdemo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springbootdemo.entity.Department;
import com.spring.springbootdemo.error.DepartmentNotFoundException;
import com.spring.springbootdemo.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	private final Logger LOGGER = LoggerFactory.getLogger(Department.class);
	
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		LOGGER.info("Inside Save Department Controller");
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/departments")
	public List<Department> fetchDepartments() {
		LOGGER.info("Inside Get Department Controller");
		return departmentService.fetchDepartments();
	}
	
	@GetMapping("/departments/{id}")
	public Department getDepartmentByID(@PathVariable("id") Long departmentID)throws DepartmentNotFoundException {
		return departmentService.getDepartmentByID(departmentID);
	}

	@DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted Successfully!!";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department) {
        return departmentService.updateDepartment(departmentId,department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
