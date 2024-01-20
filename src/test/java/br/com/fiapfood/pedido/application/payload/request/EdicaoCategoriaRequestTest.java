package br.com.fiapfood.pedido.application.payload.request;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EdicaoCategoriaRequestTest {

    @Test
    void testNome() {
        EdicaoCategoriaRequest edicaoCategoriaRequest = new EdicaoCategoriaRequest("Teste", "Teste Descricao");
        String expected = "Teste";
        assertEquals(expected, edicaoCategoriaRequest.getNome());
    }

    @Test
    void testDescricao() {
        EdicaoCategoriaRequest edicaoCategoriaRequest = new EdicaoCategoriaRequest("Teste", "Teste Descricao");
        String expected = "Teste Descricao";
        assertEquals(expected, edicaoCategoriaRequest.getDescricao());
    }

    @Test
    void testId() {
        EdicaoCategoriaRequest edicaoCategoriaRequest = new EdicaoCategoriaRequest("Teste", "Teste Descricao");
        Integer expected = 1;
        edicaoCategoriaRequest.setId(expected);
        assertEquals(expected, edicaoCategoriaRequest.getId());
    }
}