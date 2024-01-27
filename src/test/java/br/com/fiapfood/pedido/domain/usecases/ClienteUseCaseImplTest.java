package br.com.fiapfood.pedido.domain.usecases;

import br.com.fiapfood.pedido.domain.entities.Cliente;
import br.com.fiapfood.pedido.domain.entities.Cpf;
import br.com.fiapfood.pedido.domain.exceptions.DominioException;
import br.com.fiapfood.pedido.domain.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class ClienteUseCaseImplTest {

    @Mock
    private ClienteRepository clienteRepository;

    private ClienteUseCaseImpl clienteUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        clienteUseCase = new ClienteUseCaseImpl(clienteRepository);
    }

    @Test
    void testSalvarCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome("Test");
        cliente.setCpf(new Cpf(45071025027L));
        when(clienteRepository.salvarCliente(any())).thenReturn(cliente);
        Cliente result = clienteUseCase.salvarCliente(cliente);
        assertEquals(cliente, result);
        verify(clienteRepository).salvarCliente(cliente);
    }

    @Test
    void testBuscarClientePorCpf() {
        Cliente cliente = new Cliente();
        when(clienteRepository.buscarClientePorCpf(anyLong())).thenReturn(cliente);
        Cliente result = clienteUseCase.buscarClientePorCpf(12345678901L);
        assertEquals(cliente, result);
        verify(clienteRepository).buscarClientePorCpf(12345678901L);
    }

    @Test
    void testBuscarClientePorCpfThrowsException() {
        when(clienteRepository.buscarClientePorCpf(anyLong())).thenReturn(null);
        assertThrows(DominioException.class, () -> clienteUseCase.buscarClientePorCpf(12345678901L));
        verify(clienteRepository).buscarClientePorCpf(12345678901L);
    }

    @Test
    void testValidarDadosClienteThrowsException() {
        Cliente cliente = new Cliente();
        cliente.setNome("Test");
        cliente.setCpf(new Cpf(45071025027L));
        when(clienteRepository.buscarClientePorCpf(anyLong())).thenReturn(cliente);
        assertThrows(DominioException.class, () -> clienteUseCase.salvarCliente(cliente));
        verify(clienteRepository).buscarClientePorCpf(cliente.getCpf().getNumero());
    }
}