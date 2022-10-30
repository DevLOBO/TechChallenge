package com.challenge.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ManyToAny;

import com.challenge.commons.Auditable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="CONTRACTS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Contract extends Auditable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable=false)
    private Long contractId;

    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFrom;

    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTo;

    @Column(nullable=false, scale=2)
    private BigDecimal salaryPerDay;@ManyToOne
    
    @JoinColumn(name="FK_CONTRACT_TYPE")
    private ContractType contractType;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="FK_EMPLOYEE")
    private Employee employee;

    public Contract(Date dateFrom, Date dateTo, BigDecimal salaryPerDay, ContractType contractType) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.salaryPerDay = salaryPerDay;
        this.contractType = contractType;
    }    

    public void disable() {
        this.active = false;
        this.dateFrom = new Date();
    }
}
