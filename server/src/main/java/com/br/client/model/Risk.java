package com.br.client.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.math.BigDecimal;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Builder
public class Client {

    @NotNull
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long clientId;

    @NotNull
    @Size(min = 1, max = 200)
    private String txName;

    @NotNull
    @Digits(integer = 12, fraction = 2)
    private BigDecimal dcCreditLimit;

    @NotEmpty
    Set<Risk> risks;
}
