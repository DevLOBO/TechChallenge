package com.challenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.commons.exceptions.ContractInactiveOrNullException;
import com.challenge.commons.exceptions.NotFoundException;
import com.challenge.dto.requests.AddContractRequest;
import com.challenge.services.IContractService;

@RestController
@RequestMapping("/api/contract")
public class ContractController {
    @Autowired
    private IContractService contractService;

    @PostMapping("/add/{taxIdNumber}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addContract(@PathVariable String taxIdNumber, @RequestBody AddContractRequest addContract) throws NotFoundException {
        contractService.addContract(taxIdNumber, addContract);
    }

    @DeleteMapping("/disable/{taxIdNumber}")
    @ResponseStatus(HttpStatus.OK)
    public void disableContract(@PathVariable String taxIdNumber) throws NotFoundException, ContractInactiveOrNullException {
        contractService.disableContract(taxIdNumber);
    }
}
