package com.challenge.services;

import java.util.List;

import com.challenge.dto.requests.SaveEmployeeRequest;
import com.challenge.dto.requests.UpdateEmployeeRequest;
import com.challenge.dto.responses.AllEmployeesResponse;

public interface IEmployeeService {
    List<AllEmployeesResponse> getAllEmployees();
    void saveEmployee(SaveEmployeeRequest saveEmployee) throws Exception;
    void updateEmployee(UpdateEmployeeRequest updateEmployee) throws Exception;
}
