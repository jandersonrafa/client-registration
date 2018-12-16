package com.br.client.service.client;

import com.br.client.dto.ClientDto;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    Long save(ClientDto dto);

    List<ClientDto> findAll();

    Optional<ClientDto> findDtoById(Long clientId);

    void deleteById(Long clientId);
}
