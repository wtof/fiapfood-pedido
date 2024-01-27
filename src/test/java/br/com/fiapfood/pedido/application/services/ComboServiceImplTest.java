package br.com.fiapfood.pedido.application.services;

import br.com.fiapfood.pedido.application.payload.dto.StatusDTO;
import br.com.fiapfood.pedido.application.payload.request.ComboRequest;
import br.com.fiapfood.pedido.domain.entities.Combo;
import br.com.fiapfood.pedido.domain.interfaces.ComboUseCase;
import br.com.fiapfood.pedido.domain.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ComboServiceImplTest {

    @Mock
    private ComboUseCase comboUseCase;

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ComboServiceImpl comboService;

    @Test
    void testSalvarCombo() {
        ComboRequest comboRequest = new ComboRequest();
        comboRequest.setItens(Collections.emptyList());
        comboRequest.setStatus(StatusDTO.DISPONIVEL);
        Combo combo = new Combo();
        combo.setItens(Collections.emptyList());
        when(comboUseCase.salvarCombo(any())).thenReturn(combo);
        comboService.salvarCombo(comboRequest);
        verify(comboUseCase, times(1)).salvarCombo(any());
    }

    @Test
    void testBuscarComboPorId() {
        Long id = 1L;
        Combo combo = new Combo();
        combo.setItens(Collections.emptyList());
        when(comboUseCase.buscarComboPorId(anyLong())).thenReturn(combo);
        comboService.buscarComboPorId(id);
        verify(comboUseCase, times(1)).buscarComboPorId(anyLong());
    }

    @Test
    void testAtualizarCombo() {
        ComboRequest comboRequest = new ComboRequest();
        comboRequest.setItens(Collections.emptyList());
        comboRequest.setStatus(StatusDTO.DISPONIVEL);
        Combo combo = new Combo();
        combo.setItens(Collections.emptyList());
        when(comboUseCase.atualizarCombo(any())).thenReturn(combo);
        comboService.atualizarCombo(comboRequest);
        verify(comboUseCase, times(1)).atualizarCombo(any());
    }

    @Test
    void testRemoverCombo() {
        Long id = 1L;
        doNothing().when(comboUseCase).removerCombo(anyLong());
        comboService.removerCombo(id);
        verify(comboUseCase, times(1)).removerCombo(anyLong());
    }
}