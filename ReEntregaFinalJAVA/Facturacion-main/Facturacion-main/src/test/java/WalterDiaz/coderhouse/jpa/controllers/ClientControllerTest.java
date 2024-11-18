package WalterDiaz.coderhouse.jpa.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import WalterDiaz.coderhouse.jpa.entities.Client;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClientControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testCreateClient() {
        Client client = new Client();
        client.setName("Walter");
        client.setLastName("Diaz");
        client.setDocNumber("123456789");

        ResponseEntity<Client> response = restTemplate.postForEntity("/api/clientes", client, Client.class);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody().getId());
    }

    @Test
    void testGetClientNotFound() {
        int nonExistentId = 9999;
        ResponseEntity<Client> response = restTemplate.getForEntity("/api/clientes/" + nonExistentId, Client.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}

