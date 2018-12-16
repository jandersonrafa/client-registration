package com.br.client.service;

import com.br.client.dto.ClientDto;
import com.br.client.model.Client;
import com.br.client.model.Risk;
import com.br.client.service.client.ClientService;
import net.bytebuddy.utility.RandomString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ClientServiceImplIntegrationTest {

    @Autowired
    private ClientService clientService;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void save() {
        // Arrange
        Risk risk = entityManager.find(Risk.class, 1L);
        ClientDto dto = getClientDto(risk);
        // Act
        Long clientId = clientService.save(dto);
        entityManager.flush();
        entityManager.clear();

        // Assert
        assertNotNull(entityManager.find(Client.class, clientId ));
    }

    @Test
    public void deleteById() {
        // Arrange
        Risk risk = entityManager.find(Risk.class, 1L);
        ClientDto dto = getClientDto(risk);
        Long clientId = clientService.save(dto);
        entityManager.flush();
        entityManager.clear();

        // Act
        clientService.deleteById(clientId);
        entityManager.flush();
        entityManager.clear();

        // Assert
        assertNull(entityManager.find(Client.class, clientId ));
    }

    @Test
    public void findAll() {
        // Arrange
        Risk risk = entityManager.find(Risk.class, 1L);
        ClientDto dto = getClientDto(risk);
        Long clientId = clientService.save(dto);
        entityManager.flush();
        entityManager.clear();

        // Act
        List<ClientDto> result = clientService.findAll();

        // Assert
        ClientDto clientResult = result.stream().filter(r -> r.getClientId().equals(clientId)).findFirst().get();
        assertEquals(dto.getName(), clientResult.getName());
        assertEquals(dto.getCreditLimit().setScale(2,2 ), clientResult.getCreditLimit().setScale(2,2 ));
        assertEquals(risk.getDcPercentageInterest().setScale(2,2 ), clientResult.getPercentageInterest().setScale(2,2 ));
        assertEquals(dto.getRiskId(), clientResult.getRiskId());
    }

    private ClientDto getClientDto(Risk risk) {
        return ClientDto
                    .builder()
                    .creditLimit(BigDecimal.TEN)
                    .name(new RandomString().nextString())
                    .percentageInterest(BigDecimal.ONE)
                    .riskId(risk.getRiskId())
                    .build();
    }
}
