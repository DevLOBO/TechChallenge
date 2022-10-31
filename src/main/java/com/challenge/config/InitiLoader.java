package com.challenge.config;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.challenge.entities.Contract;
import com.challenge.entities.ContractType;
import com.challenge.entities.Employee;
import com.challenge.repositories.ContractTypeRepository;
import com.challenge.repositories.EmployeeRepository;

@Configuration
public class InitiLoader {
@Autowired
private ContractTypeRepository ctr;

@Autowired
private EmployeeRepository er;

    @PostConstruct
    public void loadData() {
List<ContractType> contractTypes = Arrays.asList(new ContractType("Permanent"), new ContractType("Fixed-Term"), new ContractType("External"));
contractTypes = ctr.saveAll(contractTypes);
LocalDateTime dt1 = LocalDateTime.now().plusDays(2), dt2 = LocalDateTime.now().plusDays(360);
Date d1 = Date.from(dt1.atZone(ZoneId.systemDefault()).toInstant()), d2 = Date.from(dt2.atZone(ZoneId.systemDefault()).toInstant());
Contract contract = new Contract(d1, d2, new BigDecimal(967.32), contractTypes.get(0));
Employee employee = new Employee("HEHF971110TC3", "Franco", "Hernandez", new Date(), "franco@hernandez.com", "5560666173", contract);
employee.getContract().setEmployee(employee);
er.save(employee);
    }
}
