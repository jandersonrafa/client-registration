package com.br.client.mapper;

import com.br.client.dto.ClientDto;
import com.br.client.dto.RiskDto;
import com.br.client.model.Client;
import com.br.client.model.Risk;
import org.springframework.stereotype.Component;


@Component
public class RiskMapper {

    public RiskDto toDto(Risk model) {
        return RiskDto
                .builder()
                .riskId(model.getRiskId())
                .name(model.getTxName())
                .percentageInterest(model.getDcPercentageInterest())
                .build();
    }

}
