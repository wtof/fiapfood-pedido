package br.com.fiapfood.pedido.domain.entities;

import br.com.fiapfood.pedido.domain.exceptions.DominioException;
import br.com.fiapfood.pedido.domain.enuns.StatusItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ComboTest {

    private Combo combo;

    @BeforeEach
    void setUp() {
        combo = new Combo();
    }

    @Test
    void validarDadosWithValidDataShouldNotThrowException() {
        combo.setItens(Arrays.asList(new Item()));
        combo.setStatus(StatusItem.DISPONIVEL);
        combo.setPreco(10.0f);

        assertDoesNotThrow(() -> combo.validarDados());
    }

    @Test
    void validarDadosWithInvalidItensShouldThrowException() {
        combo.setItens(null);
        combo.setStatus(StatusItem.INDISPONIVEL);
        combo.setPreco(10.0f);

        assertThrows(DominioException.class, () -> combo.validarDados());
    }

    @Test
    void validarDadosWithInvalidStatusShouldThrowException() {
        combo.setItens(Arrays.asList(new Item()));
        combo.setStatus(null);
        combo.setPreco(10.0f);

        assertThrows(DominioException.class, () -> combo.validarDados());
    }

    @Test
    void validarDadosWithInvalidPrecoShouldThrowException() {
        combo.setItens(Arrays.asList(new Item()));
        combo.setStatus(StatusItem.DISPONIVEL);
        combo.setPreco(0.0f);

        assertThrows(DominioException.class, () -> combo.validarDados());
    }

    @Test
    void equalsWithSameObjectShouldReturnTrue() {
        assertTrue(combo.equals(combo));
    }

    @Test
    void equalsWithDifferentClassShouldReturnFalse() {
        assertFalse(combo.equals(new Object()));
    }

    @Test
    void equalsWithSameDataShouldReturnTrue() {
        Combo anotherCombo = new Combo();
        anotherCombo.setId(combo.getId());
        anotherCombo.setNome(combo.getNome());
        anotherCombo.setPreco(combo.getPreco());
        anotherCombo.setStatus(combo.getStatus());
        anotherCombo.setItens(combo.getItens());
        anotherCombo.setQuantidade(combo.getQuantidade());

        assertTrue(combo.equals(anotherCombo));
    }

    @Test
    void hashCodeWithSameDataShouldReturnSameHashCode() {
        Combo anotherCombo = new Combo();
        anotherCombo.setId(combo.getId());
        anotherCombo.setNome(combo.getNome());
        anotherCombo.setPreco(combo.getPreco());
        anotherCombo.setStatus(combo.getStatus());
        anotherCombo.setItens(combo.getItens());
        anotherCombo.setQuantidade(combo.getQuantidade());

        assertEquals(combo.hashCode(), anotherCombo.hashCode());
    }
}