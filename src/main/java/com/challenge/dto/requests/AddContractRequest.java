package com.challenge.dto.requests;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddContractRequest {
    @NotNull @Min(1)
    private Short contractTypeId;

    @NotNull
    private Date dateFrom;

    @NotNull
    private Date dateTo;

    @NotNull
    private Double salaryPerDay;
}
