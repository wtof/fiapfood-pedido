package br.com.fiapfood.pedido.domain.entities;

import br.com.fiapfood.pedido.domain.exceptions.DominioException;
import br.com.fiapfood.pedido.domain.enuns.StatusItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    private Item item;

    @BeforeEach
    void setUp() {
        item = new Item();
    }

    @Test
    void validarDadosWithValidDataShouldNotThrowException() {
        item.setCategoria(new Categoria());
        item.setNome("Test Item");
        item.setPreco(10.0f);
        item.setStatus(StatusItem.DISPONIVEL);

        assertDoesNotThrow(() -> item.validarDados());
    }

    @Test
    void validarDadosWithInvalidCategoriaShouldThrowException() {
        item.setCategoria(null);
        item.setNome("Test Item");
        item.setPreco(10.0f);
        item.setStatus(StatusItem.DISPONIVEL);

        assertThrows(DominioException.class, () -> item.validarDados());
    }

    @Test
    void validarDadosWithInvalidNomeShouldThrowException() {
        item.setCategoria(new Categoria());
        item.setNome("");
        item.setPreco(10.0f);
        item.setStatus(StatusItem.DISPONIVEL);

        assertThrows(DominioException.class, () -> item.validarDados());
    }

    @Test
    void validarDadosWithInvalidPrecoShouldThrowException() {
        item.setCategoria(new Categoria());
        item.setNome("Test Item");
        item.setPreco(0.0f);
        item.setStatus(StatusItem.DISPONIVEL);

        assertThrows(DominioException.class, () -> item.validarDados());
    }

    @Test
    void validarDadosWithInvalidStatusShouldThrowException() {
        item.setCategoria(new Categoria());
        item.setNome("Test Item");
        item.setPreco(10.0f);
        item.setStatus(null);

        assertThrows(DominioException.class, () -> item.validarDados());
    }

    @Test
    void equalsWithSameObjectShouldReturnTrue() {
        assertTrue(item.equals(item));
    }

    @Test
    void equalsWithDifferentClassShouldReturnFalse() {
        assertFalse(item.equals(new Object()));
    }

    @Test
    void equalsWithSameDataShouldReturnTrue() {
        Item anotherItem = new Item();
        anotherItem.setId(item.getId());
        anotherItem.setCategoria(item.getCategoria());
        anotherItem.setNome(item.getNome());
        anotherItem.setPreco(item.getPreco());
        anotherItem.setQuantidadeEstoque(item.getQuantidadeEstoque());
        anotherItem.setQuantidade(item.getQuantidade());
        anotherItem.setStatus(item.getStatus());

        assertTrue(item.equals(anotherItem));
    }

    @Test
    void hashCodeWithSameDataShouldReturnSameHashCode() {
        Item anotherItem = new Item();
        anotherItem.setId(item.getId());
        anotherItem.setCategoria(item.getCategoria());
        anotherItem.setNome(item.getNome());
        anotherItem.setPreco(item.getPreco());
        anotherItem.setQuantidadeEstoque(item.getQuantidadeEstoque());
        anotherItem.setQuantidade(item.getQuantidade());
        anotherItem.setStatus(item.getStatus());

        assertEquals(item.hashCode(), anotherItem.hashCode());
    }
}