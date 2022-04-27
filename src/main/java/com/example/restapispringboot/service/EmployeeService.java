package com.example.restapispringboot.service;

import com.example.restapispringboot.model.Employee;
import com.example.restapispringboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository empRepository;

    // CREATE
    public Employee createEmployee(Employee emp){
        return empRepository.save(emp);
    }

    // READ
    public List<Employee> getAllEmployees(){
        return empRepository.findAll();
    }

    // READ
    public Employee getSpecificEmployee(Long empId) {
        return empRepository.findById(empId).get();
    }

    // DELETE
    public void deleteEmployee(Long empId){
        empRepository.deleteById(empId);
    }

    public Employee updateEmployee(Long empId, Employee employeeDetails){
        Employee emp = empRepository.findById(empId).get();
        emp.setFirstName(employeeDetails.getFirstName());
        emp.setLastName(employeeDetails.getLastName());
        emp.setEmail(employeeDetails.getEmail());

        return empRepository.save(emp);
    }
}
