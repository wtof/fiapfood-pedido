package br.com.fiapfood.pedido.domain.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CpfTest {

    private Cpf cpf;

    @BeforeEach
    void setUp() {
        cpf = new Cpf();
    }

    @Test
    void isValidoWithValidCpfShouldReturnTrue() {
        cpf.setNumero(12345678909L); // Assuming this is a valid CPF

        assertTrue(cpf.isValido());
    }

    @Test
    void isValidoWithInvalidCpfShouldReturnFalse() {
        cpf.setNumero(11111111111L); // Assuming this is an invalid CPF

        assertFalse(cpf.isValido());
    }

    @Test
    void equalsWithSameObjectShouldReturnTrue() {
        assertTrue(cpf.equals(cpf));
    }

    @Test
    void equalsWithDifferentClassShouldReturnFalse() {
        assertFalse(cpf.equals(new Object()));
    }

    @Test
    void equalsWithSameDataShouldReturnTrue() {
        Cpf anotherCpf = new Cpf();
        anotherCpf.setNumero(cpf.getNumero());

        assertTrue(cpf.equals(anotherCpf));
    }

    @Test
    void hashCodeWithSameDataShouldReturnSameHashCode() {
        Cpf anotherCpf = new Cpf();
        anotherCpf.setNumero(cpf.getNumero());

        assertEquals(cpf.hashCode(), anotherCpf.hashCode());
    }
}