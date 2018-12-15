package com.br.client.controller;

import com.br.client.dto.ClientDto;
import com.br.client.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid ClientDto dto) {
        clientService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<ClientDto> findById(@PathVariable Long clientId) {
        return clientService.findDtoById(clientId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ClientDto>> findAll() {
        List<ClientDto> clients = clientService.findAll();
        return clients.isEmpty() ?  ResponseEntity.noContent().build() : ResponseEntity.ok(clients);
    }
}
