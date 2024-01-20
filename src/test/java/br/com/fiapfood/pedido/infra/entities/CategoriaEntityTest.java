package br.com.fiapfood.pedido.infra.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoriaEntityTest {

    private CategoriaEntity categoriaEntity;

    @BeforeEach
    void setUp() {
        categoriaEntity = new CategoriaEntity();
    }

    @Test
    void testId() {
        Integer id = 1;
        categoriaEntity.setId(id);
        assertEquals(id, categoriaEntity.getId());
    }

    @Test
    void testNome() {
        String nome = "Test";
        categoriaEntity.setNome(nome);
        assertEquals(nome, categoriaEntity.getNome());
    }

    @Test
    void testDescricao() {
        String descricao = "Test Descricao";
        categoriaEntity.setDescricao(descricao);
        assertEquals(descricao, categoriaEntity.getDescricao());
    }

    @Test
    void testEquals() {
        CategoriaEntity categoriaEntity1 = new CategoriaEntity(1, "Test", "Test Descricao");
        CategoriaEntity categoriaEntity2 = new CategoriaEntity(1, "Test", "Test Descricao");
        assertEquals(categoriaEntity1, categoriaEntity2);
    }

    @Test
    void testHashCode() {
        CategoriaEntity categoriaEntity1 = new CategoriaEntity(1, "Test", "Test Descricao");
        CategoriaEntity categoriaEntity2 = new CategoriaEntity(1, "Test", "Test Descricao");
        assertEquals(categoriaEntity1.hashCode(), categoriaEntity2.hashCode());
    }

    @Test
    void testToString() {
        CategoriaEntity categoriaEntity = new CategoriaEntity(1, "Test", "Test Descricao");
        String expected = "CategoriaEntity(id=1, nome=Test, descricao=Test Descricao)";
        assertEquals(expected, categoriaEntity.toString());
    }

    @Test
    void testBuilder() {
        CategoriaEntity categoriaEntity = CategoriaEntity.builder()
                .id(1)
                .nome("Test")
                .descricao("Test Descricao")
                .build();

        assertNotNull(categoriaEntity);
        assertEquals(1, categoriaEntity.getId());
        assertEquals("Test", categoriaEntity.getNome());
        assertEquals("Test Descricao", categoriaEntity.getDescricao());
    }
}