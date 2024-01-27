package br.com.fiapfood.pedido.domain.entities;

import br.com.fiapfood.pedido.domain.exceptions.DominioException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoriaTest {

    private Categoria categoria;

    @BeforeEach
    void setUp() {
        categoria = new Categoria();
    }

    @Test
    void validarDadosWithValidDataShouldNotThrowException() {
        categoria.setNome("Teste");
        categoria.setDescricao("Teste descricao");

        assertDoesNotThrow(() -> categoria.validarDados());
    }

    @Test
    void validarDadosWithInvalidNomeShouldThrowException() {
        categoria.setNome("");
        categoria.setDescricao("Teste descricao");

        assertThrows(DominioException.class, () -> categoria.validarDados());
    }

    @Test
    void validarDadosWithInvalidDescricaoShouldThrowException() {
        categoria.setNome("Teste");
        categoria.setDescricao("");

        assertThrows(DominioException.class, () -> categoria.validarDados());
    }

    @Test
    void equalsWithSameObjectShouldReturnTrue() {
        assertTrue(categoria.equals(categoria));
    }

    @Test
    void equalsWithDifferentClassShouldReturnFalse() {
        assertFalse(categoria.equals(new Object()));
    }

    @Test
    void equalsWithSameDataShouldReturnTrue() {
        Categoria anotherCategoria = new Categoria();
        anotherCategoria.setId(categoria.getId());
        anotherCategoria.setNome(categoria.getNome());
        anotherCategoria.setDescricao(categoria.getDescricao());

        assertTrue(categoria.equals(anotherCategoria));
    }

    @Test
    void hashCodeWithSameDataShouldReturnSameHashCode() {
        Categoria anotherCategoria = new Categoria();
        anotherCategoria.setId(categoria.getId());
        anotherCategoria.setNome(categoria.getNome());
        anotherCategoria.setDescricao(categoria.getDescricao());

        assertEquals(categoria.hashCode(), anotherCategoria.hashCode());
    }
}