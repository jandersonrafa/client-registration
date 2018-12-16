package com.br.client.dto;

import com.br.client.model.Risk;
import lombok.*;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto implements Comparable<ClientDto>{

    private Long clientId;

    @NotNull
    @Size(min = 1, max = 200)
    private String name;

    @NotNull
    @Digits(integer = 12, fraction = 2)
    private BigDecimal creditLimit;

    @Digits(integer = 3, fraction = 2)
    private BigDecimal percentageInterest;

    @NotNull
    private Long riskId;

    @Override
    public int compareTo(ClientDto o) {
        return this.getName().compareTo(o.getName());
    }
}
