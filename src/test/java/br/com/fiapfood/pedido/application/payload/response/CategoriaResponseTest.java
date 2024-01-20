package br.com.fiapfood.pedido.application.payload.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoriaResponseTest {

    @Test
    void testId() {
        CategoriaResponse categoriaResponse = CategoriaResponse.builder().id(1).build();
        Integer expected = 1;
        assertEquals(expected, categoriaResponse.getId());
    }

    @Test
    void testNome() {
        CategoriaResponse categoriaResponse = CategoriaResponse.builder().nome("Teste").build();
        String expected = "Teste";
        assertEquals(expected, categoriaResponse.getNome());
    }

    @Test
    void testDescricao() {
        CategoriaResponse categoriaResponse = CategoriaResponse.builder().descricao("Teste descricao").build();
        String expected = "Teste descricao";
        assertEquals(expected, categoriaResponse.getDescricao());
    }
}