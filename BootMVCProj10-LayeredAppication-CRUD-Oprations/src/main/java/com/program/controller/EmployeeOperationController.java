package com.program.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.program.entity.Employee;
import com.program.service.IEmployeeService;

@Controller
public class EmployeeOperationController {
	
	@Autowired
	private IEmployeeService empService;
	
	
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}

	@GetMapping("/report")
	public String showAllEmployee(Map<String,Object> map) {
		System.out.println("EmployeeOperationController.showAllEmployee()");
		Iterable<Employee> list=empService.getAllEmployee();
		//put result in SharedMemory
		map.put("empList", list);
		return "empDetails";
	}
	
	@GetMapping("/register") //for saving form
	public String showFormSaveEmp(@ModelAttribute("emp") Employee employee) {
		
		return "addEmp";
	}
	/*
	@PostMapping("/register")//for submission of form
	public String SaveEmp(@ModelAttribute("emp") Employee employee,
							Map<String,Object> map) {
		String msg=empService.registerEmployee(employee);
		Iterable<Employee> it=empService.getAllEmployee();
		map.put("resultMsg", msg);
		map.put("empList", it);
		
		return "empDetails";
	}*/

	//******Best
	//by redirecting to main report page by PRG method
	//By using redirection scope. in this scope msg will disapper after refresh page
	@PostMapping("/register") //for submission of form
	public String addEmp(@ModelAttribute("emp") Employee employee, RedirectAttributes attr) {
	
		System.out.println("EmployeeOperationController.SaveEmp()");
		String msg = empService.registerEmployee(employee);
		//we redirecting to get handler method contains same logic no need of this logic
		//Iterable<Employee> it = empService.getAllEmployee();
		//attr.addFlashAttribute("empList", it);
		attr.addFlashAttribute("resultMsg", msg);
	
	
		return "redirect:report";
	}

	//By using Session scope
	//in this scope msg will not disapper after refresh page
	/*@PostMapping("/register") //for submission of form
	public String SaveEmp(@ModelAttribute("emp") Employee employee, HttpSession ses) {
	
		System.out.println("EmployeeOperationController.SaveEmp()");
		String msg = empService.registerEmployee(employee);
		//we redirecting to get handler method contains same logic no need of this logic
		//Iterable<Employee> it = empService.getAllEmployee();
		//attr.addFlashAttribute("empList", it);
		ses.setAttribute("resultMsg", msg);
	
	
		return "redirect:report";
	}*/

	@GetMapping("/editEmp") //to launch form page
	public String showEditFormPage(@RequestParam("no") int id, @ModelAttribute("emp") Employee emp) {
		System.out.println("EmployeeOperationController.showEditFormPage()");
		//use service
		Employee employee= empService.findEmployeeById(id);
		//copy data from object to model attribute object
		BeanUtils.copyProperties(employee, emp);
		return "editDetails";
	}

	@PostMapping("/editEmp") //for submission of form
	public String updateEmp(@ModelAttribute("emp") Employee employee, RedirectAttributes attr) {

		System.out.println("EmployeeOperationController.SaveEmp()");
		String msg = empService.modifyEmpDetails(employee);
		//add result msg as flash attribute
		attr.addFlashAttribute("resultMsg", msg);
		return "redirect:report";
	}

	@GetMapping("/deleteEmp")
	public String deleteEmployeeDetailsById(RedirectAttributes attr,@RequestParam("empNo") int id) {
		System.out.println("EmployeeOperationController.deleteEmployeeDetailsById()");
		String msg = empService.deleteEmployee(id);
		attr.addFlashAttribute("resultMsg", msg);
		return "redirect:report";
	}

}
