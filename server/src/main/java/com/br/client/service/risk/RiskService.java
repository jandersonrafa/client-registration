package com.br.client.service.risk;

import com.br.client.dto.RiskDto;
import com.br.client.model.Risk;

import java.util.List;
import java.util.Optional;

public interface RiskService {
    Optional<Risk> findById(Long riskId);

    List<RiskDto> findAll();
}
