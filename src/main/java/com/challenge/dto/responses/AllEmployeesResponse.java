package com.challenge.dto.responses;

import java.util.Date;

import com.challenge.entities.Employee;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class AllEmployeesResponse {
    private String fullName;
    private String taxIdNumber;
    private String email;
    private String contractName;
    private Date contractDateFrom;
    private Date contractDateTo;
    private Double salaryPerDay;

    public AllEmployeesResponse(Employee employee) {
        this.taxIdNumber = employee.getTaxIdNumber();
        this.email = employee.getEmail();
        this.fullName = employee.getName() + " " + employee.getLastname();

        if (employee.getContract() != null) {
            this.contractDateFrom = employee.getContract().getDateFrom();
            this.contractDateTo = employee.getContract().getDateTo();
            this.contractName = employee.getContract().getContractType().getName();
            this.salaryPerDay = employee.getContract().getSalaryPerDay().doubleValue();
        }
    }
}
