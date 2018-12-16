package com.br.client.mapper;

import com.br.client.dto.ClientDto;
import com.br.client.model.Client;
import com.br.client.model.Risk;
import org.springframework.stereotype.Component;


@Component
public class ClientMapper {

    public Client toModel(ClientDto dto) {
        return Client
                .builder()
                .txName(dto.getName())
                .clientId(dto.getClientId())
                .dcCreditLimit(dto.getCreditLimit())
                .build();
    }

    public ClientDto toDto(Client model) {
        return ClientDto
                .builder()
                .clientId(model.getClientId())
                .creditLimit(model.getDcCreditLimit())
                .percentageInterest(model.getDcPercentageInterest())
                .name(model.getTxName())
                .riskId(model.getRisk().getRiskId())
                .build();
    }

}
