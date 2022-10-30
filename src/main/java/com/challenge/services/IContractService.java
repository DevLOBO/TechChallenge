package com.challenge.services;

import com.challenge.commons.exceptions.ContractInactiveOrNullException;
import com.challenge.commons.exceptions.NotFoundException;
import com.challenge.dto.requests.AddContractRequest;

public interface IContractService {
    void addContract(String taxIdNumber, AddContractRequest addContract) throws NotFoundException;
    void disableContract(String taxIdNumber) throws NotFoundException, ContractInactiveOrNullException;
}
