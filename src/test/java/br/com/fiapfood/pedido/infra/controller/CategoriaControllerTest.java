
package br.com.fiapfood.pedido.infra.controller;

import br.com.fiapfood.pedido.application.interfaces.CategoriaService;
import br.com.fiapfood.pedido.application.payload.request.CategoriaRequest;
import br.com.fiapfood.pedido.application.payload.response.CategoriaResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CategoriaControllerTest {

    @InjectMocks
    private CategoriaController categoriaController;

    @Mock
    private CategoriaService categoriaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSalvarCategoria() {
        CategoriaResponse categoria = new CategoriaResponse();

        when(categoriaService.salvarCategoria(any())).thenReturn(categoria);

        ResponseEntity<CategoriaResponse> response = categoriaController.salvarCategoria(new CategoriaRequest());
        assertEquals(categoria, response.getBody());
    }

    @Test
    void testBuscarClientePorCpf() {
        CategoriaResponse categoria = new CategoriaResponse();
        when(categoriaService.buscarCategoriaPorId(anyInt())).thenReturn(categoria);

        ResponseEntity<CategoriaResponse> response = categoriaController.buscarClientePorCpf(1);
        assertEquals(categoria, response.getBody());
    }

    @Test
    void testBuscarTodasCategorias() {
        CategoriaResponse categoria1 = new CategoriaResponse();
        CategoriaResponse categoria2 = new CategoriaResponse();

        when(categoriaService.buscarTodasCategorias()).thenReturn(Arrays.asList(categoria1, categoria2));

        ResponseEntity<List<CategoriaResponse>> response = categoriaController.buscarTodasCategorias();
        assertEquals(2, response.getBody().size());
    }

    @Test
    void testRemoverCategoriaPorId() {
        doNothing().when(categoriaService).removerCategoriasPorId(anyInt());

        ResponseEntity<String> response = categoriaController.removerCategoriaPorId(1);
        assertEquals("Categoria removida com sucesso", response.getBody());
    }
}