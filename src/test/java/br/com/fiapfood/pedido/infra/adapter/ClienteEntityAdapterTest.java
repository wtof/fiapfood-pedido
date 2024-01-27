package br.com.fiapfood.pedido.infra.adapter;

import br.com.fiapfood.pedido.domain.entities.Cliente;
import br.com.fiapfood.pedido.domain.entities.Cpf;
import br.com.fiapfood.pedido.infra.entities.ClienteEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ClienteEntityAdapterTest {

    private ClienteEntityAdapter clienteEntityAdapter;

    @BeforeEach
    void setUp() {
        clienteEntityAdapter = ClienteEntityAdapter.build();
    }

    @Test
    void testAdaptList() {
        Cliente cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("Test1");
        cliente1.setCpf(new Cpf(45071025027L));

        Cliente cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setNome("Test2");
        cliente2.setCpf(new Cpf(45071025027L));

        List<ClienteEntity> clienteEntities = clienteEntityAdapter.adapt(Arrays.asList(cliente1, cliente2));

        assertEquals(2, clienteEntities.size());
        assertEquals(cliente1.getId(), clienteEntities.get(0).getId());
        assertEquals(cliente1.getNome(), clienteEntities.get(0).getNome());
        assertEquals(cliente1.getCpf().getNumero(), clienteEntities.get(0).getCpf().getNumero());
        assertEquals(cliente2.getId(), clienteEntities.get(1).getId());
        assertEquals(cliente2.getNome(), clienteEntities.get(1).getNome());
        assertEquals(cliente2.getCpf().getNumero(), clienteEntities.get(1).getCpf().getNumero());
    }

    @Test
    void testAdaptListNull() {
        List<ClienteEntity> clienteEntities = clienteEntityAdapter.adapt((List<Cliente>) null);
        assertNull(clienteEntities);
    }

    @Test
    void testAdaptListEmpty() {
        List<ClienteEntity> clienteEntities = clienteEntityAdapter.adapt(Arrays.asList());
        assertNull(clienteEntities);
    }
}