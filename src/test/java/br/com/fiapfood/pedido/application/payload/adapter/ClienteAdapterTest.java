package br.com.fiapfood.pedido.application.payload.adapter;

import br.com.fiapfood.pedido.application.exceptions.ApplicationException;
import br.com.fiapfood.pedido.application.payload.request.ClienteRequest;
import br.com.fiapfood.pedido.domain.entities.Cliente;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ClienteAdapterTest {

    @Test
    void convertWithNullClienteRequestShouldThrowException() {
        ClienteAdapter adapter = ClienteAdapter.build();

        assertThrows(ApplicationException.class, () -> adapter.convert((ClienteRequest) null));
    }

    @Test
    void convertWithValidClienteRequestShouldReturnCliente() {
        ClienteAdapter adapter = ClienteAdapter.build();
        ClienteRequest request = new ClienteRequest();
        request.setNome("Test");
        request.setCpf(12345678901L);

        Cliente cliente = adapter.convert(request);

        assertEquals("Test", cliente.getNome());
        assertEquals(12345678901L, cliente.getCpf().getNumero());
    }

    @Test
    void convertWithNullListShouldThrowException() {
        ClienteAdapter adapter = ClienteAdapter.build();

        assertThrows(ApplicationException.class, () -> adapter.convert((List<ClienteRequest>) null));
    }

    @Test
    void convertWithEmptyListShouldThrowException() {
        ClienteAdapter adapter = ClienteAdapter.build();

        assertThrows(ApplicationException.class, () -> adapter.convert(Arrays.asList()));
    }

    @Test
    void convertWithValidListShouldReturnList() {
        ClienteAdapter adapter = ClienteAdapter.build();
        ClienteRequest request = new ClienteRequest();
        request.setNome("Test");
        request.setCpf(12345678901L);

        List<Cliente> clientes = adapter.convert(Arrays.asList(request, request));

        assertEquals(2, clientes.size());
        assertEquals("Test", clientes.get(0).getNome());
        assertEquals(12345678901L, clientes.get(0).getCpf().getNumero());
        assertEquals("Test", clientes.get(1).getNome());
        assertEquals(12345678901L, clientes.get(1).getCpf().getNumero());
    }
}