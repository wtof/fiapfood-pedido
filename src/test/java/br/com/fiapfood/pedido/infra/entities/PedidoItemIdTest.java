package br.com.fiapfood.pedido.infra.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoItemIdTest {

    private PedidoItemId pedidoItemId;

    @BeforeEach
    void setUp() {
        pedidoItemId = new PedidoItemId();
    }

    @Test
    void testSetPedido() {
        PedidoEntity pedido = new PedidoEntity();
        pedidoItemId.setPedido(pedido);
        assertEquals(pedido, pedidoItemId.getPedido());
    }
}