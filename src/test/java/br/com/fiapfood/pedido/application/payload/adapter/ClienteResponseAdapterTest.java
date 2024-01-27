package br.com.fiapfood.pedido.application.payload.adapter;

import br.com.fiapfood.pedido.application.exceptions.ApplicationException;
import br.com.fiapfood.pedido.application.payload.response.ClienteResponse;
import br.com.fiapfood.pedido.domain.entities.Cliente;
import br.com.fiapfood.pedido.domain.entities.Cpf;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClienteResponseAdapterTest {

    @Test
    void adaptWithNullClienteShouldThrowException() {
        ClienteResponseAdapter adapter = ClienteResponseAdapter.build();

        assertThrows(ApplicationException.class, () -> adapter.adapt((Cliente) null));
    }

    @Test
    void adaptWithValidClienteShouldReturnClienteResponse() {
        ClienteResponseAdapter adapter = ClienteResponseAdapter.build();
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("test");
        cliente.setCpf(new Cpf(12345678901L));

        ClienteResponse response = adapter.adapt(cliente);

        assertEquals(1L, response.getId());
        assertEquals("TEST", response.getNome());
        assertEquals(12345678901L, response.getCpf());
    }

    @Test
    void adaptWithNullListShouldThrowException() {
        ClienteResponseAdapter adapter = ClienteResponseAdapter.build();

        assertThrows(ApplicationException.class, () -> adapter.adapt((List<Cliente>) null));
    }

    @Test
    void adaptWithEmptyListShouldThrowException() {
        ClienteResponseAdapter adapter = ClienteResponseAdapter.build();

        assertThrows(ApplicationException.class, () -> adapter.adapt(Arrays.asList()));
    }

    @Test
    void adaptWithValidListShouldReturnList() {
        ClienteResponseAdapter adapter = ClienteResponseAdapter.build();
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("Test");
        cliente.setCpf(new Cpf(12345678901L));

        List<ClienteResponse> responses = adapter.adapt(Arrays.asList(cliente, cliente));

        assertEquals(2, responses.size());
        assertEquals(1L, responses.get(0).getId());
        assertEquals("TEST", responses.get(0).getNome());
        assertEquals(12345678901L, responses.get(0).getCpf());
        assertEquals(1L, responses.get(1).getId());
        assertEquals("TEST", responses.get(1).getNome());
        assertEquals(12345678901L, responses.get(1).getCpf());
    }
}