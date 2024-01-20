package br.com.fiapfood.pedido.application.services;

import br.com.fiapfood.pedido.application.payload.request.ClienteRequest;
import br.com.fiapfood.pedido.application.payload.response.ClienteResponse;
import br.com.fiapfood.pedido.domain.entities.Cliente;
import br.com.fiapfood.pedido.domain.entities.Cpf;
import br.com.fiapfood.pedido.domain.interfaces.ClienteUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class ClienteServiceImplTest {

    @Mock
    private ClienteUseCase clienteUseCase;

    private ClienteServiceImpl clienteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        clienteService = new ClienteServiceImpl(clienteUseCase);
    }

    @Test
    void testSalvarCliente() {
        ClienteRequest clienteRequest = new ClienteRequest();
        Long cpf = 45071025027L;
        Cliente cliente = new Cliente();
        cliente.setCpf(new Cpf(45071025027L));
        when(clienteUseCase.salvarCliente(any())).thenReturn(cliente);

        ClienteResponse result = clienteService.salvarCliente(clienteRequest);

        assertNotNull(result);
        verify(clienteUseCase, times(1)).salvarCliente(any());
    }

    @Test
    void testBuscarClientePorCpf() {
        Long cpf = 45071025027L;
        Cliente cliente = new Cliente();
        cliente.setCpf(new Cpf(45071025027L));
        when(clienteUseCase.buscarClientePorCpf(anyLong())).thenReturn(cliente);

        ClienteResponse result = clienteService.buscarClientePorCpf(cpf);

        assertNotNull(result);
        verify(clienteUseCase, times(1)).buscarClientePorCpf(cpf);
    }
}