package com.br.client.service.risk;

import com.br.client.dto.RiskDto;
import com.br.client.mapper.RiskMapper;
import com.br.client.model.Risk;
import com.br.client.repository.RiskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class RiskServiceImpl implements  RiskService{

    @Autowired
    private RiskRepository riskRepository;

    @Autowired
    private RiskMapper riskMapper;

    @Override
    public Optional<Risk> findById(Long riskId) {
        return riskRepository.findById(riskId);
    }

    @Override
    public List<RiskDto> findAll() {
        return riskRepository.findAll().stream().map(riskMapper::toDto).sorted().collect(toList());
    }
}
