package br.com.fiapfood.pedido.infra.adapter;

import br.com.fiapfood.pedido.domain.entities.Cliente;
import br.com.fiapfood.pedido.infra.entities.ClienteEntity;
import br.com.fiapfood.pedido.infra.entities.CpfEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ClienteDomainAdapterTest {

    private ClienteDomainAdapter clienteDomainAdapter;

    @BeforeEach
    void setUp() {
        clienteDomainAdapter = ClienteDomainAdapter.build();
    }

    @Test
    void testAdaptSingleEntity() {
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setId(1L);
        clienteEntity.setNome("Test");
        clienteEntity.setCpf(new CpfEntity(45071025027L));

        Cliente cliente = clienteDomainAdapter.adapt(clienteEntity);

        assertEquals(clienteEntity.getId(), cliente.getId());
        assertEquals(clienteEntity.getNome(), cliente.getNome());
        assertEquals(clienteEntity.getCpf().getNumero(), cliente.getCpf().getNumero());
    }

    @Test
    void testAdaptSingleEntityNull() {
        Cliente cliente = clienteDomainAdapter.adapt((ClienteEntity) null);
        assertNull(cliente);
    }

    @Test
    void testAdaptEntityList() {
        ClienteEntity clienteEntity1 = new ClienteEntity();
        clienteEntity1.setId(1L);
        clienteEntity1.setNome("Test1");
        clienteEntity1.setCpf(new CpfEntity(45071025027L));

        ClienteEntity clienteEntity2 = new ClienteEntity();
        clienteEntity2.setId(2L);
        clienteEntity2.setNome("Test2");
        clienteEntity2.setCpf(new CpfEntity(45071025027L));

        List<Cliente> clientes = clienteDomainAdapter.adapt(Arrays.asList(clienteEntity1, clienteEntity2));

        assertEquals(2, clientes.size());
        assertEquals(clienteEntity1.getId(), clientes.get(0).getId());
        assertEquals(clienteEntity1.getNome(), clientes.get(0).getNome());
        assertEquals(clienteEntity1.getCpf().getNumero(), clientes.get(0).getCpf().getNumero());
        assertEquals(clienteEntity2.getId(), clientes.get(1).getId());
        assertEquals(clienteEntity2.getNome(), clientes.get(1).getNome());
        assertEquals(clienteEntity2.getCpf().getNumero(), clientes.get(1).getCpf().getNumero());
    }
}