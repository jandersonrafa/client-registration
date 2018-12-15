package com.br.client.dto;

import lombok.*;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RiskDto implements Comparable<RiskDto>{

    private Long riskId;

    @NotNull
    @Size(min = 1, max = 20)
    private String name;

    @NotNull
    @Digits(integer = 3, fraction = 2)
    private BigDecimal percentageInterest;


    @Override
    public int compareTo(RiskDto o) {
        return this.getName().compareTo(o.getName());
    }
}
