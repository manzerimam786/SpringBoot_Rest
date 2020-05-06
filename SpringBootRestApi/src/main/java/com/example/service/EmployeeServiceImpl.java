package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.EmployeeDao;
import com.example.model.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeedao;
	
	public List<Employee> getAllEmployees() {
		return employeedao.getAllEmployees();
	}

	@Override
	public Employee getEmployee(int id) {
		return employeedao.getEmployee(id);
	}

	public boolean createEmployee(Employee employee) {
		return employeedao.createEmployee(employee);
	}
	
	public Employee deleteEmployee(int id) {
		return employeedao.deleteEmployee(id);
	}

	public void deleteAllEmployees() {
		employeedao.deleteAllEmployees();
	}

	@Override
	public boolean updateEmployee(int id, Employee employee) {
		return employeedao.updateEmployee(id, employee);
	}
}
