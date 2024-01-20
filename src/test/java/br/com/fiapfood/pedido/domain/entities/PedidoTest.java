package br.com.fiapfood.pedido.domain.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    private Pedido pedido;

    @BeforeEach
    void setUp() {
        pedido = new Pedido();
    }

    @Test
    void equalsWithSameObjectShouldReturnTrue() {
        assertTrue(pedido.equals(pedido));
    }

    @Test
    void equalsWithDifferentClassShouldReturnFalse() {
        assertFalse(pedido.equals(new Object()));
    }

    @Test
    void equalsWithSameDataShouldReturnTrue() {
        Pedido anotherPedido = new Pedido();
        anotherPedido.setId(pedido.getId());
        anotherPedido.setCliente(pedido.getCliente());
        anotherPedido.setStatus(pedido.getStatus());
        anotherPedido.setItens(pedido.getItens());
        anotherPedido.setCombos(pedido.getCombos());
        anotherPedido.setNumero(pedido.getNumero());

        assertTrue(pedido.equals(anotherPedido));
    }

    @Test
    void hashCodeWithSameDataShouldReturnSameHashCode() {
        Pedido anotherPedido = new Pedido();
        anotherPedido.setId(pedido.getId());
        anotherPedido.setCliente(pedido.getCliente());
        anotherPedido.setStatus(pedido.getStatus());
        anotherPedido.setItens(pedido.getItens());
        anotherPedido.setCombos(pedido.getCombos());
        anotherPedido.setNumero(pedido.getNumero());

        assertEquals(pedido.hashCode(), anotherPedido.hashCode());
    }
}