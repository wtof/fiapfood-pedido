package br.com.fiapfood.pedido.application.payload.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClienteResponseTest {

    @Test
    void testId() {
        ClienteResponse clienteResponse = ClienteResponse.builder().id(1L).build();
        Long expected = 1L;
        assertEquals(expected, clienteResponse.getId());
    }

    @Test
    void testNome() {
        ClienteResponse clienteResponse = ClienteResponse.builder().nome("Teste").build();
        String expected = "Teste";
        assertEquals(expected, clienteResponse.getNome());
    }

    @Test
    void testCpf() {
        ClienteResponse clienteResponse = ClienteResponse.builder().cpf(12345678910L).build();
        Long expected = 12345678910L;
        assertEquals(expected, clienteResponse.getCpf());
    }
}