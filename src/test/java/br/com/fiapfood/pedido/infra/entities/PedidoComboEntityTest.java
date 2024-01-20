package br.com.fiapfood.pedido.infra.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoComboIdTest {

    private PedidoComboId pedidoComboId;

    @BeforeEach
    void setUp() {
        pedidoComboId = new PedidoComboId();
    }

    @Test
    void testGetPedido() {
        PedidoEntity pedido = new PedidoEntity();
        pedidoComboId.setPedido(pedido);
        assertEquals(pedido, pedidoComboId.getPedido());
    }

    @Test
    void testGetCombo() {
        ComboEntity combo = new ComboEntity();
        pedidoComboId.setCombo(combo);
        assertEquals(combo, pedidoComboId.getCombo());
    }

    @Test
    void testEquals() {
        PedidoEntity pedido = new PedidoEntity();
        ComboEntity combo = new ComboEntity();
        PedidoComboId pedidoComboId1 = new PedidoComboId(pedido, combo);
        PedidoComboId pedidoComboId2 = new PedidoComboId(pedido, combo);
        assertEquals(pedidoComboId1, pedidoComboId2);
    }

    @Test
    void testHashCode() {
        PedidoEntity pedido = new PedidoEntity();
        ComboEntity combo = new ComboEntity();
        PedidoComboId pedidoComboId = new PedidoComboId(pedido, combo);
        int expectedHashCode = 1;
        expectedHashCode = expectedHashCode * 59 + (pedido == null ? 43 : pedido.hashCode());
        expectedHashCode = expectedHashCode * 59 + (combo == null ? 43 : combo.hashCode());
        assertEquals(expectedHashCode, pedidoComboId.hashCode());
    }

    @Test
    void testToString() {
        PedidoEntity pedido = new PedidoEntity();
        ComboEntity combo = new ComboEntity();
        PedidoComboId pedidoComboId = new PedidoComboId(pedido, combo);
        String expectedString = "PedidoComboId(pedido=" + pedido + ", combo=" + combo + ")";
        assertEquals(expectedString, pedidoComboId.toString());
    }
}