package br.com.fiapfood.pedido.application.payload.request;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CategoriaRequestTest {

    @Test
    void testNome() {
        CategoriaRequest categoriaRequest = new CategoriaRequest();
        String expected = "Teste";
        categoriaRequest.setNome(expected);
        assertEquals(expected, categoriaRequest.getNome());
    }

    @Test
    void testDescricao() {
        CategoriaRequest categoriaRequest = new CategoriaRequest();
        String expected = "Teste Descricao";
        categoriaRequest.setDescricao(expected);
        assertEquals(expected, categoriaRequest.getDescricao());
    }
}