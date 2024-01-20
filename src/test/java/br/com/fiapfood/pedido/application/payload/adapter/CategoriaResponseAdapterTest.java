package br.com.fiapfood.pedido.application.payload.adapter;

import br.com.fiapfood.pedido.application.exceptions.ApplicationException;
import br.com.fiapfood.pedido.application.payload.response.CategoriaResponse;
import br.com.fiapfood.pedido.domain.entities.Categoria;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoriaResponseAdapterTest {

    @Test
    void adaptWithNullCategoriaShouldThrowException() {
        CategoriaResponseAdapter adapter = CategoriaResponseAdapter.build();

        assertThrows(ApplicationException.class, () -> adapter.adapt((Categoria) null));
    }

    @Test
    void adaptWithValidCategoriaShouldReturnCategoriaResponse() {
        CategoriaResponseAdapter adapter = CategoriaResponseAdapter.build();
        Categoria categoria = new Categoria();
        categoria.setId(1);
        categoria.setNome("Test");
        categoria.setDescricao("Test description");

        CategoriaResponse response = adapter.adapt(categoria);

        assertEquals(1, response.getId());
        assertEquals("Test", response.getNome());
        assertEquals("Test description", response.getDescricao());
    }

    @Test
    void adaptWithNullListShouldThrowException() {
        CategoriaResponseAdapter adapter = CategoriaResponseAdapter.build();

        assertThrows(ApplicationException.class, () -> adapter.adapt((List<Categoria>) null));
    }

    @Test
    void adaptWithEmptyListShouldThrowException() {
        CategoriaResponseAdapter adapter = CategoriaResponseAdapter.build();

        assertThrows(ApplicationException.class, () -> adapter.adapt(Arrays.asList()));
    }

    @Test
    void adaptWithValidListShouldReturnList() {
        CategoriaResponseAdapter adapter = CategoriaResponseAdapter.build();
        Categoria categoria = new Categoria();
        categoria.setId(1);
        categoria.setNome("Test");
        categoria.setDescricao("Test description");

        List<CategoriaResponse> responses = adapter.adapt(Arrays.asList(categoria, categoria));

        assertEquals(2, responses.size());
        assertEquals(1, responses.get(0).getId());
        assertEquals("Test", responses.get(0).getNome());
        assertEquals("Test description", responses.get(0).getDescricao());
        assertEquals(1, responses.get(1).getId());
        assertEquals("Test", responses.get(1).getNome());
        assertEquals("Test description", responses.get(1).getDescricao());
    }
}