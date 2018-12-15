package com.br.client.model;

import lombok.*;

import javax.persistence.*;
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
public class Client {

    @NotNull
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long clientId;

    @NotNull
    @Size(min = 1, max = 200)
    private String txName;

    @NotNull
    @Digits(integer = 10, fraction = 2)
    private BigDecimal dcCreditLimit;

    @NotNull
    @Digits(integer = 3, fraction = 2)
    private BigDecimal dcPercentageInterest;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="risk_id")
    private Risk risk;
}
