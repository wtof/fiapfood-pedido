package br.com.fiapfood.pedido.infra.entities;

import br.com.fiapfood.pedido.domain.enuns.StatusPedido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PedidoEntityTest {

    private PedidoEntity pedidoEntity;

    @BeforeEach
    void setUp() {
        pedidoEntity = new PedidoEntity();
    }

    @Test
    void testGetId() {
        Long id = 1L;
        pedidoEntity.setId(id);
        assertEquals(id, pedidoEntity.getId());
    }

    @Test
    void testGetCliente() {
        ClienteEntity cliente = new ClienteEntity();
        pedidoEntity.setCliente(cliente);
        assertEquals(cliente, pedidoEntity.getCliente());
    }

    @Test
    void testGetStatus() {
        StatusPedido status = StatusPedido.INICIADO;
        pedidoEntity.setStatus(status);
        assertEquals(status, pedidoEntity.getStatus());
    }

    @Test
    void testGetPedidoItens() {
        List<PedidoItemEntity> pedidoItens = new ArrayList<>();
        pedidoEntity.setPedidoItens(pedidoItens);
        assertEquals(pedidoItens, pedidoEntity.getPedidoItens());
    }

    @Test
    void testGetPedidoCombos() {
        List<PedidoComboEntity> pedidoCombos = new ArrayList<>();
        pedidoEntity.setPedidoCombos(pedidoCombos);
        assertEquals(pedidoCombos, pedidoEntity.getPedidoCombos());
    }

    @Test
    void testEquals() {
        PedidoEntity pedidoEntity1 = new PedidoEntity();
        PedidoEntity pedidoEntity2 = new PedidoEntity();
        assertEquals(pedidoEntity1, pedidoEntity2);
    }

    @Test
    void testHashCode() {
        PedidoEntity pedidoEntity = new PedidoEntity();
        assertNotNull(pedidoEntity.hashCode());
    }

    @Test
    void testToString() {
        PedidoEntity pedidoEntity = new PedidoEntity();
        assertNotNull(pedidoEntity.toString());
    }
}