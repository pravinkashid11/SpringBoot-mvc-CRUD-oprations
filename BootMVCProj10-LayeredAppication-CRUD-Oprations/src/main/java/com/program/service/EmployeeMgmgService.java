package com.program.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.program.entity.Employee;
import com.program.repository.IEmployeeRepository;


@Service("empService")
public class EmployeeMgmgService implements IEmployeeService {

	
	@Autowired
	private IEmployeeRepository empRepo;
	
	@Override
	public Iterable<Employee> getAllEmployee() {
	
		return empRepo.findAll();
	}

	@Override
	public String registerEmployee(Employee emp) {
		int idVal=empRepo.save(emp).getEmpNo();
		return "Employee registered with Id:: "+idVal;
	}

	@Override
	public Employee findEmployeeById(int id) {
		Employee emp = empRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Employee Id"));
		return emp;
	}

	@Override
	public String modifyEmpDetails(Employee emp) {
		Employee employee = empRepo.save(emp);
		return "Employee data with id " + emp.getEmpNo() + " is updated";
	}

	@Override
	public String deleteEmployee(int id) {
		empRepo.deleteById(id);
		return "Employee data is deleted with id " + id;
	}

}
