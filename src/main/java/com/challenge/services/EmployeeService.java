package com.challenge.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.dto.requests.SaveEmployeeRequest;
import com.challenge.dto.requests.UpdateEmployeeRequest;
import com.challenge.dto.responses.AllEmployeesResponse;
import com.challenge.entities.Employee;
import com.challenge.repositories.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<AllEmployeesResponse> getAllEmployees() {
        return employeeRepository.findAll().stream().map(AllEmployeesResponse::new).collect(Collectors.toList());
    }

    @Override
    public void saveEmployee(@Valid SaveEmployeeRequest saveEmployee) throws Exception {
        if (employeeRepository.existsByTaxIdNumber(saveEmployee.getTaxIdNumber()))
        throw new Exception("There is an employee with the same Tax ID Number");

        Employee employee = new Employee(saveEmployee.getTaxIdNumber(), saveEmployee.getName(), saveEmployee.getLastname(), saveEmployee.getBirthdate(), saveEmployee.getEmail(), saveEmployee.getCellPhone(), null);
        employee.setTaxIdNumber(employee.getTaxIdNumber().toUpperCase());
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(UpdateEmployeeRequest updateEmployee) throws Exception {
        if (!employeeRepository.existsByTaxIdNumber(updateEmployee.getTaxIdNumber()))
        throw new Exception("There isn't any employee with this Tax ID Number");

        Employee employee = new Employee(updateEmployee.getTaxIdNumber(), updateEmployee.getName(), updateEmployee.getLastname(), updateEmployee.getBirthdate(), updateEmployee.getEmail(), updateEmployee.getCellPhone(), null);
        employee.setTaxIdNumber(employee.getTaxIdNumber().toUpperCase());
        employeeRepository.save(employee);
    }
    
}
