package br.com.fiapfood.pedido.infra.controller;

import br.com.fiapfood.pedido.application.interfaces.ComboService;
import br.com.fiapfood.pedido.application.payload.request.ComboRequest;
import br.com.fiapfood.pedido.application.payload.response.ComboResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ComboControllerTest {

    @InjectMocks
    private ComboController comboController;

    @Mock
    private ComboService comboService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSalvarCombo() {
        ComboResponse combo = new ComboResponse();

        when(comboService.salvarCombo(any())).thenReturn(combo);

        ResponseEntity<ComboResponse> response = comboController.salvarCombo(new ComboRequest());
        assertEquals(combo, response.getBody());
    }

    @Test
    void testBuscarComboPorId() {
        ComboResponse combo = new ComboResponse();
        when(comboService.buscarComboPorId(anyLong())).thenReturn(combo);

        ResponseEntity<ComboResponse> response = comboController.buscarComboPorCpf(1L);
        assertEquals(combo, response.getBody());
    }
}