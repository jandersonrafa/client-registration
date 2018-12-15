package com.br.client.service.client;

import com.br.client.dto.ClientDto;
import com.br.client.mapper.ClientMapper;
import com.br.client.model.Client;
import com.br.client.model.Risk;
import com.br.client.repository.ClientRepository;
import com.br.client.service.risk.RiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RiskService riskService;

    @Autowired
    private ClientMapper clientMapper;

    @Override
    public void save(ClientDto dto) {
        Client model = clientMapper.toModel(dto);
        Risk risk = riskService.findById(dto.getRiskId()).get();
        model.setRisk(risk);
        clientRepository.save(model);
    }

    @Override
    public List<ClientDto> findAll() {
        return clientRepository
                .findAll()
                .stream()
                .map(clientMapper::toDto)
                .sorted().collect(toList());
    }

    @Override
    public Optional<ClientDto> findDtoById(Long clientId) {
        return clientRepository.findById(clientId).map(clientMapper::toDto);
    }

}
