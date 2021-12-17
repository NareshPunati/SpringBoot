package com.practice.employee.controller;

import com.practice.employee.entity.Employee;
import com.practice.employee.model.EmployeeModel;
import com.practice.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public Employee add(@RequestBody EmployeeModel employee)
    {
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/get/{id}")
    public EmployeeModel getById(@PathVariable String id){
        return employeeService.getById(id);
    }

    @GetMapping("/get-all")
    public List<EmployeeModel> getEmployee() { return employeeService.getEmployees(); }


//    @GetMapping("/get-by-email/{email}")
//    public List<EmployeeModel> getByEmail(@PathVariable String email){
//        return employeeService.getByEmail(email);
//    }

//    @GetMapping("/get-holidays/{id}")
//    public Long[] sumOfHoliday(String id){
//       return employeeService.sumOfHoliday(id);
//    }
}
