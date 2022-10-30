package com.challenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.dto.requests.SaveEmployeeRequest;
import com.challenge.dto.requests.UpdateEmployeeRequest;
import com.challenge.dto.responses.AllEmployeesResponse;
import com.challenge.services.ContractService;
import com.challenge.services.IEmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
@Autowired
private IEmployeeService employeeService;

    @GetMapping("/all")
    public List<AllEmployeesResponse> allEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveEmployee(@RequestBody SaveEmployeeRequest saveEmployee) throws Exception {
        employeeService.saveEmployee(saveEmployee);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateEmployee(@RequestBody UpdateEmployeeRequest updateEmployee) throws Exception {
        employeeService.updateEmployee(updateEmployee);
    }
}
