package com.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.entities.ContractType;

@Repository
public interface ContractTypeRepository extends JpaRepository<ContractType, Short> {
    
}
