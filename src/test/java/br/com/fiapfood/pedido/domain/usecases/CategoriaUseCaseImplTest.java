package br.com.fiapfood.pedido.domain.usecases;

import br.com.fiapfood.pedido.domain.entities.Categoria;
import br.com.fiapfood.pedido.domain.exceptions.DominioException;
import br.com.fiapfood.pedido.domain.repository.CategoriaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoriaUseCaseImplTest {

    @Mock
    private CategoriaRepository categoriaRepository;

    private CategoriaUseCaseImpl categoriaUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        categoriaUseCase = new CategoriaUseCaseImpl(categoriaRepository);
    }

    @Test
    void testSalvarCategoria() {
        Categoria categoria = new Categoria();
        categoria.setNome("Test");
        categoria.setDescricao("Test");
        when(categoriaRepository.salvarCategoria(any())).thenReturn(categoria);
        Categoria result = categoriaUseCase.salvarCategoria(categoria);
        assertEquals(categoria, result);
        verify(categoriaRepository).salvarCategoria(categoria);
    }

    @Test
    void testBuscarTodasCategorias() {
        Categoria categoria = new Categoria();
        List<Categoria> expected = Arrays.asList(categoria);
        when(categoriaRepository.buscarTodasCategorias()).thenReturn(expected);
        List<Categoria> result = categoriaUseCase.buscarTodasCategorias();
        assertEquals(expected, result);
        verify(categoriaRepository).buscarTodasCategorias();
    }

    @Test
    void testBuscarCategoriaPorId() {
        Categoria categoria = new Categoria();
        when(categoriaRepository.buscarCategoriaPorId(anyInt())).thenReturn(categoria);
        Categoria result = categoriaUseCase.buscarCategoriaPorId(1);
        assertEquals(categoria, result);
        verify(categoriaRepository).buscarCategoriaPorId(1);
    }

    @Test
    void testRemoverCategoriasPorId() {
        Categoria categoria = new Categoria();
        when(categoriaRepository.buscarCategoriaPorId(anyInt())).thenReturn(categoria);
        categoriaUseCase.removerCategoriasPorId(1);
        verify(categoriaRepository).removerCategoria(1);
    }

    @Test
    void testRemoverCategoriasPorIdThrowsException() {
        when(categoriaRepository.buscarCategoriaPorId(anyInt())).thenReturn(null);
        assertThrows(DominioException.class, () -> categoriaUseCase.removerCategoriasPorId(1));
        verify(categoriaRepository).buscarCategoriaPorId(1);
    }
}