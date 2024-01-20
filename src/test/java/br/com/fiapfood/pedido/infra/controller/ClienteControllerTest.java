package br.com.fiapfood.pedido.infra.controller;

import br.com.fiapfood.pedido.application.interfaces.ClienteService;
import br.com.fiapfood.pedido.application.payload.request.ClienteRequest;
import br.com.fiapfood.pedido.application.payload.response.ClienteResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ClienteControllerTest {

    @InjectMocks
    private ClienteController clienteController;

    @Mock
    private ClienteService clienteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSalvarCliente() {
        ClienteResponse cliente = new ClienteResponse();

        when(clienteService.salvarCliente(any())).thenReturn(cliente);

        ResponseEntity<ClienteResponse> response = clienteController.salvarCliente(new ClienteRequest());
        assertEquals(cliente, response.getBody());
    }

    @Test
    void testBuscarClientePorCpf() {
        ClienteResponse cliente = new ClienteResponse();
        when(clienteService.buscarClientePorCpf(anyLong())).thenReturn(cliente);

        ResponseEntity<ClienteResponse> response = clienteController.buscarClientePorCpf(1L);
        assertEquals(cliente, response.getBody());
    }
}