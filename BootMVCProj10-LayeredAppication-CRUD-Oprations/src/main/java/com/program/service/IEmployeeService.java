package com.program.service;

import com.program.entity.Employee;

public interface IEmployeeService {
		
	public Iterable<Employee> getAllEmployee();
	public String registerEmployee(Employee emp);
	public Employee findEmployeeById(int id);
	public String modifyEmpDetails(Employee emp);
	public String deleteEmployee(int id);

}
