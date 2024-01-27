package br.com.fiapfood.pedido.infra.repository;

import br.com.fiapfood.pedido.domain.entities.Item;
import br.com.fiapfood.pedido.domain.enuns.StatusItem;
import br.com.fiapfood.pedido.infra.entities.ItemEntity;
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

class ItemRepositoryJPATest {

    @Mock
    private EntityManager entityManager;

    @Mock
    private TypedQuery<ItemEntity> query;

    private ItemRepositoryJPA itemRepositoryJPA;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        itemRepositoryJPA = new ItemRepositoryJPA(entityManager);
    }

    @Test
    void testSalvarItem() {
        Item item = new Item();
        item.setStatus(StatusItem.DISPONIVEL);
        item.setPreco(10.0f);
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setStatus(StatusItem.DISPONIVEL);
        when(entityManager.merge(any())).thenReturn(itemEntity);

        Item result = itemRepositoryJPA.salvarItem(item);

        assertNotNull(result);
        verify(entityManager, times(1)).merge(any());
    }

    @Test
    void testAtualizarItem() {
        Item item = new Item();
        item.setStatus(StatusItem.DISPONIVEL);
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setStatus(StatusItem.DISPONIVEL);
        when(entityManager.merge(any())).thenReturn(itemEntity);

        Item result = itemRepositoryJPA.atualizarItem(item);

        assertNotNull(result);
        verify(entityManager, times(1)).merge(any());
    }

    @Test
    void testRemoverItem() {
        Item item = new Item();
        ItemEntity itemEntity = new ItemEntity();
        when(entityManager.find(ItemEntity.class, item.getId())).thenReturn(itemEntity);

        itemRepositoryJPA.removerItem(item);

        verify(entityManager, times(1)).remove(any());
    }

    @Test
    void testBuscarItemPorId() {
        Long id = 1L;
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setStatus(StatusItem.DISPONIVEL);
        when(entityManager.find(ItemEntity.class, id)).thenReturn(itemEntity);

        Item result = itemRepositoryJPA.buscarItemPorId(id);

        assertNotNull(result);
        verify(entityManager, times(1)).find(ItemEntity.class, id);
    }

    @Test
    void testBuscarItemPorId_NoResult() {
        Long id = 1L;
        when(entityManager.find(ItemEntity.class, id)).thenThrow(NoResultException.class);

        Item result = itemRepositoryJPA.buscarItemPorId(id);

        assertNull(result);
        verify(entityManager, times(1)).find(ItemEntity.class, id);
    }

    @Test
    void testBuscarItensPorIdCategoria() {
        Integer idCategoria = 1;
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setStatus(StatusItem.DISPONIVEL);

        when(entityManager.createQuery(anyString(), eq(ItemEntity.class))).thenReturn(query);
        when(query.getResultList()).thenReturn(Collections.singletonList(itemEntity));

        List<Item> result = itemRepositoryJPA.buscarItensPorIdCategoria(idCategoria);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        verify(query, times(1)).setParameter("idCategoria", idCategoria);
    }

    @Test
    void testBuscarItensPorNomeCategoria() {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setStatus(StatusItem.DISPONIVEL);
        String nomeCategoria = "test";

        when(entityManager.createQuery(anyString(), eq(ItemEntity.class))).thenReturn(query);
        when(query.getResultList()).thenReturn(Collections.singletonList(itemEntity));

        List<Item> result = itemRepositoryJPA.buscarItensPorNomeCategoria(nomeCategoria);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        verify(query, times(1)).setParameter("nomeCategoria", "%" + nomeCategoria + "%");
    }
}