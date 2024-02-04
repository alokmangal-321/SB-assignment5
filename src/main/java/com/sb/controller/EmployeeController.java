package com.sb.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sb.entity.Employee;

@RestController
public class EmployeeController {
	
	 Map<Long, Employee> store=new HashMap<Long,Employee>();
	 
	 @PostMapping("/add")
	 public ResponseEntity<?> addEmployee(@RequestBody Employee emp){
		 if(store.containsKey(emp.getId())) {
			 return new ResponseEntity("Already done with this id",HttpStatus.BAD_REQUEST);
		 }else{
			 store.put(emp.getId(), emp);
			 return new ResponseEntity(emp,HttpStatus.OK);
		 }
	 }
	 
	 @GetMapping("/get-all")
	 public List<Employee> getAllEmployee(){
		 List<Employee> empList=new ArrayList();
		 Collection<Employee> s=store.values();
		 return new ArrayList(s);
	 }
	 
	 
	 @PutMapping("/update")
	 public Employee updateEmployee(@RequestBody Employee emp) {
		 if(store.containsKey(emp.getId())){
			 store.put(emp.getId(), emp);
			 return emp;
		 }
		 return null;
	 }
	 
	 public Employee deleteEmployee(@PathVariable Long id) {
		 if(store.containsKey(id)) {
			 Employee employee=store.remove(id);
			 return employee;
		 }
		 return null;
	 }
	 
	 

}
