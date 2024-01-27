package br.com.fiapfood.pedido.infra.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoItemEntityTest {

    private PedidoItemEntity pedidoItemEntity;

    @BeforeEach
    void setUp() {
        pedidoItemEntity = new PedidoItemEntity();
    }

    @Test
    void testGetId() {
        PedidoItemId id = new PedidoItemId();
        pedidoItemEntity.setId(id);
        assertEquals(id, pedidoItemEntity.getId());
    }

    @Test
    void testGetQuantidade() {
        Integer quantidade = 5;
        pedidoItemEntity.setQuantidade(quantidade);
        assertEquals(quantidade, pedidoItemEntity.getQuantidade());
    }

    @Test
    void testEquals() {
        PedidoItemId id = new PedidoItemId();
        Integer quantidade = 5;
        PedidoItemEntity pedidoItemEntity1 = PedidoItemEntity.builder().id(id).quantidade(quantidade).build();
        PedidoItemEntity pedidoItemEntity2 = PedidoItemEntity.builder().id(id).quantidade(quantidade).build();
        assertEquals(pedidoItemEntity1, pedidoItemEntity2);
    }

    @Test
    void testHashCode() {
        PedidoItemId id = new PedidoItemId();
        Integer quantidade = 5;
        PedidoItemEntity pedidoItemEntity = PedidoItemEntity.builder().id(id).quantidade(quantidade).build();
        assertNotNull(pedidoItemEntity.hashCode());
    }

    @Test
    void testToString() {
        PedidoItemId id = new PedidoItemId();
        Integer quantidade = 5;
        PedidoItemEntity pedidoItemEntity = PedidoItemEntity.builder().id(id).quantidade(quantidade).build();
        assertNotNull(pedidoItemEntity.toString());
    }
}