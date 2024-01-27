package br.com.fiapfood.pedido.domain.usecases;

import br.com.fiapfood.pedido.domain.entities.Combo;
import br.com.fiapfood.pedido.domain.entities.Item;
import br.com.fiapfood.pedido.domain.enuns.StatusItem;
import br.com.fiapfood.pedido.domain.exceptions.DominioException;
import br.com.fiapfood.pedido.domain.repository.ComboRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class ComboUseCaseImplTest {

    @Mock
    private ComboRepository comboRepository;

    private ComboUseCaseImpl comboUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        comboUseCase = new ComboUseCaseImpl(comboRepository);
    }

    @Test
    void testSalvarCombo() {
        Combo combo = new Combo();
        Item item = new Item();
        ArrayList<Item> itens = new ArrayList<>();
        itens.add(item);
        combo.setItens(itens);
        combo.setStatus(StatusItem.DISPONIVEL);
        combo.setPreco(10.0F);
        when(comboRepository.salvarCombo(any())).thenReturn(combo);
        Combo result = comboUseCase.salvarCombo(combo);
        assertEquals(combo, result);
        verify(comboRepository).salvarCombo(combo);
    }

    @Test
    void testBuscarComboPorId() {
        Combo combo = new Combo();
        when(comboRepository.buscarComboPorId(anyLong())).thenReturn(combo);
        Combo result = comboUseCase.buscarComboPorId(1L);
        assertEquals(combo, result);
        verify(comboRepository).buscarComboPorId(1L);
    }

    @Test
    void testAtualizarCombo() {
        Combo combo = new Combo();
        when(comboRepository.atualizarCombo(any())).thenReturn(combo);
        Combo result = comboUseCase.atualizarCombo(combo);
        assertEquals(combo, result);
        verify(comboRepository).atualizarCombo(combo);
    }

    @Test
    void testRemoverCombo() {
        Combo combo = new Combo();
        when(comboRepository.buscarComboPorId(anyLong())).thenReturn(combo);
        comboUseCase.removerCombo(1L);
        verify(comboRepository).removerCombo(combo);
    }

    @Test
    void testRemoverComboThrowsException() {
        when(comboRepository.buscarComboPorId(anyLong())).thenReturn(null);
        assertThrows(DominioException.class, () -> comboUseCase.removerCombo(1L));
        verify(comboRepository).buscarComboPorId(1L);
    }
}