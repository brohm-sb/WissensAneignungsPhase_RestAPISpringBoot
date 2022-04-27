package com.example.restapispringboot.controller;

import com.example.restapispringboot.model.Employee;
import com.example.restapispringboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService empService;

    @RequestMapping(value="/employees", method = RequestMethod.POST)
    public Employee createEmployee(@RequestBody Employee emp){
        return empService.createEmployee(emp);
    }

    @RequestMapping(value="/employees", method = RequestMethod.GET)
    public List<Employee> getAllEmployees(){
        return empService.getAllEmployees();
    }

    @RequestMapping(value="/employees/{empId}", method = RequestMethod.GET)
    public Employee getSpecificEmployee(@PathVariable(value="empId") Long id) {
        return empService.getSpecificEmployee(id);
    }

    @RequestMapping(value="/employees/{empId}", method = RequestMethod.PUT)
    public Employee updateEmployee(@PathVariable(value="empId") Long id, @RequestBody Employee empDetails){
        return empService.updateEmployee(id, empDetails);
    }

    @RequestMapping(value="/employees/{empId}", method = RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable(value="empId") Long id){
        empService.deleteEmployee(id);
    }

}
