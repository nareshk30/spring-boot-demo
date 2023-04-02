package com.spring.springbootdemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.springbootdemo.entity.Department;
import com.spring.springbootdemo.error.DepartmentNotFoundException;

@Service
public interface DepartmentService {

	public Department saveDepartment(Department department);
	public List<Department> fetchDepartments();
	public Department getDepartmentByID(Long departmentID) throws DepartmentNotFoundException;
    public void deleteDepartmentById(Long departmentId);
    public Department updateDepartment(Long departmentId, Department department);
    Department fetchDepartmentByName(String departmentName);
}
