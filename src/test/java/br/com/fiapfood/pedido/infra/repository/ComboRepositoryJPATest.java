package br.com.fiapfood.pedido.infra.repository;

import br.com.fiapfood.pedido.domain.entities.Combo;
import br.com.fiapfood.pedido.domain.entities.Item;
import br.com.fiapfood.pedido.domain.enuns.StatusItem;
import br.com.fiapfood.pedido.infra.entities.ComboEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ComboRepositoryJPATest {

    @Mock
    private EntityManager entityManager;

    private ComboRepositoryJPA comboRepositoryJPA;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        comboRepositoryJPA = new ComboRepositoryJPA(entityManager);
    }

    @Test
    void testSalvarCombo() {
        Combo combo = new Combo();
        Item item = new Item();
        item.setStatus(StatusItem.DISPONIVEL);
        combo.setItens(List.of(item));
        combo.setStatus(StatusItem.DISPONIVEL);

        ComboEntity comboEntity = new ComboEntity();
        when(entityManager.merge(any())).thenReturn(comboEntity);

        Combo result = comboRepositoryJPA.salvarCombo(combo);

        assertNotNull(result);
        verify(entityManager, times(1)).persist(any());
    }

    @Test
    void testAtualizarCombo() {
        Combo combo = new Combo();
        Item item = new Item();
        item.setStatus(StatusItem.DISPONIVEL);
        combo.setItens(List.of(item));
        combo.setStatus(StatusItem.DISPONIVEL);
        ComboEntity comboEntity = new ComboEntity();
        comboEntity.setStatus(StatusItem.DISPONIVEL);
        when(entityManager.merge(any())).thenReturn(comboEntity);

        Combo result = comboRepositoryJPA.atualizarCombo(combo);

        assertNotNull(result);
        verify(entityManager, times(1)).merge(any());
    }

    @Test
    void testRemoverCombo() {
        Combo combo = new Combo();
        Item item = new Item();
        item.setStatus(StatusItem.DISPONIVEL);
        combo.setItens(List.of(item));
        combo.setStatus(StatusItem.DISPONIVEL);
        comboRepositoryJPA.removerCombo(combo);

        verify(entityManager, times(1)).remove(any());
    }

    @Test
    void testBuscarComboPorId() {
        Long id = 1L;
        ComboEntity comboEntity = new ComboEntity();
        comboEntity.setStatus(StatusItem.DISPONIVEL);
        when(entityManager.find(ComboEntity.class, id)).thenReturn(comboEntity);

        Combo result = comboRepositoryJPA.buscarComboPorId(id);

        assertNotNull(result);
        verify(entityManager, times(1)).find(ComboEntity.class, id);
    }

    @Test
    void testBuscarComboPorId_NoResult() {
        Long id = 1L;
        when(entityManager.find(ComboEntity.class, id)).thenThrow(NoResultException.class);

        Combo result = comboRepositoryJPA.buscarComboPorId(id);

        assertNull(result);
        verify(entityManager, times(1)).find(ComboEntity.class, id);
    }
}