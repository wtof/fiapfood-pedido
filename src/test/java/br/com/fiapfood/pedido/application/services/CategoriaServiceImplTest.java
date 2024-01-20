package br.com.fiapfood.pedido.application.services;

import br.com.fiapfood.pedido.application.payload.request.CategoriaRequest;
import br.com.fiapfood.pedido.domain.entities.Categoria;
import br.com.fiapfood.pedido.domain.interfaces.CategoriaUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoriaServiceImplTest {

    @Mock
    private CategoriaUseCase useCaseCategoria;

    @InjectMocks
    private CategoriaServiceImpl categoriaService;

    @Test
    void testSalvarCategoria() {
        CategoriaRequest categoriaRequest = new CategoriaRequest(); // You may need to set some properties here
        Categoria categoria = new Categoria(); // You may need to set some properties here
        when(useCaseCategoria.salvarCategoria(any())).thenReturn(categoria);
        categoriaService.salvarCategoria(categoriaRequest);
        verify(useCaseCategoria, times(1)).salvarCategoria(any());
    }

    @Test
    void testBuscarCategoriaPorId() {
        Categoria categoria = new Categoria(); // You may need to set some properties here
        when(useCaseCategoria.buscarCategoriaPorId(anyInt())).thenReturn(categoria);
        categoriaService.buscarCategoriaPorId(1);
        verify(useCaseCategoria, times(1)).buscarCategoriaPorId(anyInt());
    }

    @Test
    void testBuscarTodasCategorias() {
        Categoria categoria = new Categoria(); // You may need to set some properties here
        List<Categoria> expected = Arrays.asList(categoria);
        when(useCaseCategoria.buscarTodasCategorias()).thenReturn(expected);
        categoriaService.buscarTodasCategorias();
        verify(useCaseCategoria, times(1)).buscarTodasCategorias();
    }

    @Test
    void testRemoverCategoriasPorId() {
        doNothing().when(useCaseCategoria).removerCategoriasPorId(anyInt());
        categoriaService.removerCategoriasPorId(1);
        verify(useCaseCategoria, times(1)).removerCategoriasPorId(anyInt());
    }
}