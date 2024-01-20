package br.com.fiapfood.pedido.infra.repository;

import br.com.fiapfood.pedido.domain.entities.Pedido;
import br.com.fiapfood.pedido.domain.enuns.StatusPedido;
import br.com.fiapfood.pedido.infra.entities.PedidoEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PedidoRepositoryJPATest {

    @Mock
    private EntityManager entityManager;

    @Mock
    private TypedQuery<PedidoEntity> query;

    private PedidoRepositoryJPA pedidoRepositoryJPA;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        pedidoRepositoryJPA = new PedidoRepositoryJPA(entityManager);
    }

    @Test
    void testSalvarPedido() {
        Pedido pedido = new Pedido();
        pedido.setStatus(StatusPedido.RECEBIDO);
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setStatus(StatusPedido.RECEBIDO);
        when(entityManager.merge(any())).thenReturn(pedidoEntity);

        Pedido result = pedidoRepositoryJPA.salvarPedido(pedido);

        assertNotNull(result);
        verify(entityManager, times(1)).persist(any());
    }

    @Test
    void testAtualizarPedido() {
        Pedido pedido = new Pedido();
        pedido.setStatus(StatusPedido.RECEBIDO);
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setStatus(StatusPedido.RECEBIDO);
        when(entityManager.merge(any())).thenReturn(pedidoEntity);

        Pedido result = pedidoRepositoryJPA.atualizarPedido(pedido);

        assertNotNull(result);
        verify(entityManager, times(1)).merge(any());
    }

    @Test
    void testBuscarPedidoPorId() {
        Long id = 1L;
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setStatus(StatusPedido.RECEBIDO);
        when(entityManager.find(PedidoEntity.class, id)).thenReturn(pedidoEntity);

        Pedido result = pedidoRepositoryJPA.buscarPedidoPorId(id);

        assertNotNull(result);
        verify(entityManager, times(1)).find(PedidoEntity.class, id);
    }

    @Test
    void testBuscarPedidoPorId_NoResult() {
        Long id = 1L;
        when(entityManager.find(PedidoEntity.class, id)).thenThrow(NoResultException.class);

        Pedido result = pedidoRepositoryJPA.buscarPedidoPorId(id);

        assertNull(result);
        verify(entityManager, times(1)).find(PedidoEntity.class, id);
    }

    @Test
    void testBuscarPedidoPorStatus() {
        StatusPedido status = StatusPedido.RECEBIDO;
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setStatus(status);
        when(entityManager.createQuery(anyString(), eq(PedidoEntity.class))).thenReturn(query);
        when(query.getResultList()).thenReturn(Collections.singletonList(pedidoEntity));

        List<Pedido> result = pedidoRepositoryJPA.buscarPedidoPorStatus(status);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        verify(query, times(1)).setParameter("status", status);
    }

    @Test
    void testBuscarPedidosAtivos() {
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setStatus(StatusPedido.RECEBIDO);
        when(entityManager.createQuery(anyString(), eq(PedidoEntity.class))).thenReturn(query);
        when(query.getResultList()).thenReturn(Collections.singletonList(pedidoEntity));

        List<Pedido> result = pedidoRepositoryJPA.buscarPedidosAtivos();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        verify(query, times(1)).setParameter("finalizado", StatusPedido.FINALIZADO);
        verify(query, times(1)).setParameter("pronto", StatusPedido.PRONTO);
        verify(query, times(1)).setParameter("preparacao", StatusPedido.EM_PREPARACAO);
        verify(query, times(1)).setParameter("recebido", StatusPedido.RECEBIDO);
    }
}