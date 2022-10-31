package com.challenge.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "EMPLOYEES")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    @Column(nullable = false, length = 13, unique = true)
    private String taxIdNumber;

    @Column(nullable = false, length = 60)
    private String name;

    @Column(nullable = false, length = 120)
    private String lastname;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthdate;

    @Column(nullable = false, length = 80)
    private String email;

    @Column(nullable = false, length = 20)
    private String cellPhone;

    @OneToOne(mappedBy="employee", cascade=CascadeType.ALL)
    private Contract contract;

    public Employee(String taxIdNumber, String name, String lastname, Date birthdate, String email, String cellPhone,
            Contract contract) {
        this.taxIdNumber = taxIdNumber;
        this.name = name;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.email = email;
        this.cellPhone = cellPhone;
        this.contract = contract;
    }

    public String getFullName() {
        return this.name + " " + this.lastname;
    }
}
