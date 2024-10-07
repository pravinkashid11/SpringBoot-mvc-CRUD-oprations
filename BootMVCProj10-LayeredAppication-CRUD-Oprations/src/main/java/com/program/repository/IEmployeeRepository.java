package com.program.repository;

import org.springframework.data.repository.CrudRepository;

import com.program.entity.Employee;

public interface IEmployeeRepository extends CrudRepository<Employee, Integer> {

}
