package br.com.fiapfood.pedido.infra.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class ClienteEntityTest {

    private ClienteEntity clienteEntity;

    @BeforeEach
    void setUp() {
        clienteEntity = new ClienteEntity();
    }

    @Test
    void testId() {
        Long id = 1L;
        clienteEntity.setId(id);
        assertEquals(id, clienteEntity.getId());
    }

    @Test
    void testNome() {
        String nome = "Test";
        clienteEntity.setNome(nome);
        assertEquals(nome, clienteEntity.getNome());
    }

    @Test
    void testCpf() {
        CpfEntity cpf = new CpfEntity(45071025027L);
        clienteEntity.setCpf(cpf);
        assertEquals(cpf, clienteEntity.getCpf());
    }

    @Test
    void testPedidos() {
        PedidoEntity pedido = new PedidoEntity();
        clienteEntity.setPedidos(Collections.singletonList(pedido));
        assertEquals(1, clienteEntity.getPedidos().size());
        assertEquals(pedido, clienteEntity.getPedidos().get(0));
    }

    @Test
    void testEquals() {
        ClienteEntity clienteEntity1 = new ClienteEntity(1L, "Test",  new CpfEntity(45071025027L), Collections.singletonList(new PedidoEntity()));
        ClienteEntity clienteEntity2 = new ClienteEntity(1L, "Test",  new CpfEntity(45071025027L), Collections.singletonList(new PedidoEntity()));
        assertEquals(clienteEntity1, clienteEntity2);
    }

    @Test
    void testHashCode() {
        ClienteEntity clienteEntity1 = new ClienteEntity(1L, "Test", new CpfEntity(45071025027L), Collections.singletonList(new PedidoEntity()));
        ClienteEntity clienteEntity2 = new ClienteEntity(1L, "Test", new CpfEntity(45071025027L), Collections.singletonList(new PedidoEntity()));
        assertEquals(clienteEntity1.hashCode(), clienteEntity2.hashCode());
    }

    @Test
    void testToString() {
        ClienteEntity clienteEntity = new ClienteEntity(1L, "Test", new CpfEntity(45071025027L), Collections.singletonList(new PedidoEntity()));
        String expected = "ClienteEntity(id=1, nome=Test, cpf=CpfEntity(numero=45071025027), pedidos=[PedidoEntity(id=null, cliente=null, status=null, pedidoItens=null, pedidoCombos=null)])";
        assertEquals(expected, clienteEntity.toString());
    }

    @Test
    void testBuilder() {
        ClienteEntity clienteEntity = ClienteEntity.builder()
                .id(1L)
                .nome("Test")
                .cpf(new CpfEntity(45071025027L))
                .pedidos(Collections.singletonList(new PedidoEntity()))
                .build();

        assertNotNull(clienteEntity);
        assertEquals(1L, clienteEntity.getId());
        assertEquals("Test", clienteEntity.getNome());
        assertEquals(new CpfEntity(45071025027L), clienteEntity.getCpf());
        assertEquals(1, clienteEntity.getPedidos().size());
    }
}