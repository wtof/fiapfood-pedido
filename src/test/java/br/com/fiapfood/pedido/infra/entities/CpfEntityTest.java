package br.com.fiapfood.pedido.infra.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CpfEntityTest {

    private CpfEntity cpfEntity;

    @BeforeEach
    void setUp() {
        cpfEntity = new CpfEntity();
    }

    @Test
    void testNumero() {
        Long numero = 12345678900L;
        cpfEntity.setNumero(numero);
        assertEquals(numero, cpfEntity.getNumero());
    }

    @Test
    void testEquals() {
        CpfEntity cpfEntity1 = new CpfEntity(12345678900L);
        CpfEntity cpfEntity2 = new CpfEntity(12345678900L);
        assertEquals(cpfEntity1, cpfEntity2);
    }

    @Test
    void testHashCode() {
        CpfEntity cpfEntity1 = new CpfEntity(12345678900L);
        CpfEntity cpfEntity2 = new CpfEntity(12345678900L);
        assertEquals(cpfEntity1.hashCode(), cpfEntity2.hashCode());
    }

    @Test
    void testToString() {
        CpfEntity cpfEntity = new CpfEntity(12345678900L);
        String expected = "CpfEntity(numero=12345678900)";
        assertEquals(expected, cpfEntity.toString());
    }

    @Test
    void testBuilder() {
        CpfEntity cpfEntity = CpfEntity.builder()
                .numero(12345678900L)
                .build();

        assertNotNull(cpfEntity);
        assertEquals(12345678900L, cpfEntity.getNumero());
    }
}