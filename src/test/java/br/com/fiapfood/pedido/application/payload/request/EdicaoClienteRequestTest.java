package br.com.fiapfood.pedido.application.payload.request;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EdicaoClienteRequestTest {

    @Test
    void testNome() {
        EdicaoClienteRequest edicaoClienteRequest = new EdicaoClienteRequest("Teste", 12345678910L);
        String expected = "Teste";
        assertEquals(expected, edicaoClienteRequest.getNome());
    }

    @Test
    void testCpf() {
        EdicaoClienteRequest edicaoClienteRequest = new EdicaoClienteRequest("Teste", 12345678910L);
        Long expected = 12345678910L;
        assertEquals(expected, edicaoClienteRequest.getCpf());
    }

    @Test
    void testIdCliente() {
        EdicaoClienteRequest edicaoClienteRequest = new EdicaoClienteRequest("Teste", 12345678910L);
        Long expected = 1L;
        edicaoClienteRequest.setIdCliente(expected);
        assertEquals(expected, edicaoClienteRequest.getIdCliente());
    }
}