package com.br.client.service;

import com.br.client.dto.ClientDto;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    void save(ClientDto dto);

    List<ClientDto> findAll();

    Optional<ClientDto> findDtoById(Long clientId);
}
