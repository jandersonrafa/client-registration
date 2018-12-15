package com.br.client.controller;

import com.br.client.dto.ClientDto;
import com.br.client.dto.RiskDto;
import com.br.client.service.client.ClientService;
import com.br.client.service.risk.RiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/risk")
public class RiskController {

    @Autowired
    private RiskService riskService;

    @GetMapping
    public ResponseEntity<List<RiskDto>> findAll() {
        List<RiskDto> risks = riskService.findAll();
        return risks.isEmpty() ?  ResponseEntity.noContent().build() : ResponseEntity.ok(risks);
    }
}
