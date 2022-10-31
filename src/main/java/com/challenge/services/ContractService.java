package com.challenge.services;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.commons.exceptions.ContractInactiveOrNullException;
import com.challenge.commons.exceptions.NotFoundException;
import com.challenge.dto.requests.AddContractRequest;
import com.challenge.entities.Contract;
import com.challenge.entities.ContractType;
import com.challenge.entities.Employee;
import com.challenge.repositories.ContractRepository;
import com.challenge.repositories.ContractTypeRepository;
import com.challenge.repositories.EmployeeRepository;

@Service
public class ContractService implements IContractService {
    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ContractTypeRepository contractTypeRepository;

    @Override
    public void addContract(String taxIdNumber, @Valid AddContractRequest addContract) throws NotFoundException {
        Employee employee = employeeRepository.findByTaxIdNumber(taxIdNumber).orElseThrow(() -> new NotFoundException("The employee was not found."));
        ContractType contractType = contractTypeRepository.findById(addContract.getContractTypeId()).orElseThrow(() -> new NotFoundException("The Contract Type selected doesn't exist."));
        Contract oldContract = employee.getContract(), newContract = new Contract(addContract.getDateFrom(), addContract.getDateTo(), new BigDecimal(addContract.getSalaryPerDay()), contractType);

        if (oldContract != null) {
            oldContract.disable();
            contractRepository.save(oldContract);
        }

        newContract.setEmployee(employee);
        employee.setContract(newContract);
        employeeRepository.save(employee);
    }

    @Override
    public void disableContract(String taxIdNumber) throws NotFoundException, ContractInactiveOrNullException {
    	System.out.println("Estoy en el servicio");	
        Employee employee = employeeRepository.findByTaxIdNumber(taxIdNumber).orElseThrow(() -> new NotFoundException("The Tax ID Number doesn't exist"));
        Contract contract = employee.getContract();
        
        if (contract == null || contract.getDateTo().before(new Date()))
        throw new ContractInactiveOrNullException("There was an error with the Contract for this Employee.");

        contract.disable();
        contractRepository.save(contract);
    }
}
