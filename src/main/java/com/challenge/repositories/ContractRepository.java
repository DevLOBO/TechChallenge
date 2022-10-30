package com.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.entities.Contract;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
    
}
