package com.challenge.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findByTaxIdNumber(String taxIdNumber);
    boolean existsByTaxIdNumber(String taxIdNumber);
}
