package br.com.fiapfood.pedido.application.payload.request;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClienteRequestTest {

    @Test
    void testNome() {
        ClienteRequest clienteRequest = new ClienteRequest();
        String expected = "Teste";
        clienteRequest.setNome(expected);
        assertEquals(expected, clienteRequest.getNome());
    }

    @Test
    void testCpf() {
        ClienteRequest clienteRequest = new ClienteRequest();
        Long expected = 12345678910L;
        clienteRequest.setCpf(expected);
        assertEquals(expected, clienteRequest.getCpf());
    }
}