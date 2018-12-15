package com.br.client.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Risk {

    @NotNull
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long riskId;

    @NotNull
    @Size(min = 1, max = 20)
    private String txName;

    @NotNull
    @Digits(integer = 3, fraction = 2)
    private BigDecimal dcPercentageInterest;

}
