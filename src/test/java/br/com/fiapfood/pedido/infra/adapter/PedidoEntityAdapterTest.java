package br.com.fiapfood.pedido.infra.adapter;

import br.com.fiapfood.pedido.domain.entities.Pedido;
import br.com.fiapfood.pedido.domain.enuns.StatusPedido;
import br.com.fiapfood.pedido.infra.entities.PedidoEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class PedidoEntityAdapterTest {

    private PedidoEntityAdapter pedidoEntityAdapter;

    @BeforeEach
    void setUp() {
        pedidoEntityAdapter = PedidoEntityAdapter.build();
    }

    @Test
    void testAdaptSingleEntity() {
        Pedido pedido = new Pedido();
        pedido.setId(1L);
        pedido.setStatus(StatusPedido.INICIADO);

        PedidoEntity pedidoEntity = pedidoEntityAdapter.adapt(pedido);

        assertEquals(pedido.getId(), pedidoEntity.getId());
        assertEquals(StatusPedido.valueOf(pedidoEntity.getStatus().name()), pedido.getStatus());
    }

    @Test
    void testAdaptSingleEntityNull() {
        PedidoEntity pedidoEntity = pedidoEntityAdapter.adapt((Pedido) null);
        assertNull(pedidoEntity);
    }

    @Test
    void testAdaptEntityList() {

        Pedido pedido1 = new Pedido();
        pedido1.setId(1L);
        pedido1.setStatus(StatusPedido.INICIADO);

        Pedido pedido2 = new Pedido();
        pedido2.setId(2L);
        pedido2.setStatus(StatusPedido.INICIADO);

        List<PedidoEntity> pedidoEntities = pedidoEntityAdapter.adapt(Arrays.asList(pedido1, pedido2));

        assertEquals(2, pedidoEntities.size());

        PedidoEntity pedidoEntity1 = pedidoEntities.get(0);
        assertEquals(pedido1.getId(), pedidoEntity1.getId());
        assertEquals(StatusPedido.valueOf(pedidoEntity1.getStatus().name()), pedido1.getStatus());

        PedidoEntity pedidoEntity2 = pedidoEntities.get(1);
        assertEquals(pedido2.getId(), pedidoEntity2.getId());
        assertEquals(StatusPedido.valueOf(pedidoEntity2.getStatus().name()), pedido2.getStatus());
    }

    @Test
    void testAdaptListNull() {
        List<PedidoEntity> pedidoEntities = pedidoEntityAdapter.adapt((List<Pedido>) null);
        assertNull(pedidoEntities);
    }

    @Test
    void testAdaptListEmpty() {
        List<PedidoEntity> pedidoEntities = pedidoEntityAdapter.adapt(Arrays.asList());
        assertNull(pedidoEntities);
    }
}