// FILEPATH: /d:/workspaces/java/postech/fiapfood-pedido/src/test/java/br/com/fiapfood/pedido/infra/adapter/PedidoDomainAdapterTest.java

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

class PedidoDomainAdapterTest {

    private PedidoDomainAdapter pedidoDomainAdapter;

    @BeforeEach
    void setUp() {
        pedidoDomainAdapter = PedidoDomainAdapter.build();
    }

    @Test
    void testAdaptSingleEntity() {
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setId(1L);
        pedidoEntity.setStatus(StatusPedido.INICIADO);

        Pedido pedido = pedidoDomainAdapter.adapt(pedidoEntity);

        assertEquals(pedidoEntity.getId(), pedido.getId());
        assertEquals(StatusPedido.INICIADO, pedido.getStatus());
    }

    @Test
    void testAdaptSingleEntityNull() {
        Pedido pedido = pedidoDomainAdapter.adapt((PedidoEntity) null);
        assertNull(pedido);
    }

    @Test
    void testAdaptEntityList() {

        PedidoEntity pedidoEntity1 = new PedidoEntity();
        pedidoEntity1.setId(1L);
        pedidoEntity1.setStatus(StatusPedido.INICIADO);


        PedidoEntity pedidoEntity2 = new PedidoEntity();
        pedidoEntity2.setId(2L);
        pedidoEntity2.setStatus(StatusPedido.INICIADO);

        List<Pedido> pedidos = pedidoDomainAdapter.adapt(Arrays.asList(pedidoEntity1, pedidoEntity2));

        assertEquals(2, pedidos.size());

        Pedido pedido1 = pedidos.get(0);
        assertEquals(pedidoEntity1.getId(), pedido1.getId());
        assertEquals(StatusPedido.INICIADO, pedido1.getStatus());

        Pedido pedido2 = pedidos.get(1);
        assertEquals(pedidoEntity2.getId(), pedido2.getId());
        assertEquals(StatusPedido.INICIADO, pedido2.getStatus());
    }

    @Test
    void testAdaptListNull() {
        List<Pedido> pedidos = pedidoDomainAdapter.adapt((List<PedidoEntity>) null);
        assertNull(pedidos);
    }

    @Test
    void testAdaptListEmpty() {
        List<Pedido> pedidos = pedidoDomainAdapter.adapt(Arrays.asList());
        assertNull(pedidos);
    }
}