package br.com.fiapfood.pedido.application.payload.adapter;

import br.com.fiapfood.pedido.application.exceptions.ApplicationException;
import br.com.fiapfood.pedido.application.payload.request.CategoriaRequest;
import br.com.fiapfood.pedido.domain.entities.Categoria;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CategoriaAdapterTest {

    @Test
    void adaptWithNullCategoriaRequestShouldThrowException() {
        CategoriaAdapter adapter = CategoriaAdapter.build();

        assertThrows(ApplicationException.class, () -> adapter.adapt((CategoriaRequest) null));
    }

    @Test
    void adaptWithValidCategoriaRequestShouldReturnCategoria() {
        CategoriaAdapter adapter = CategoriaAdapter.build();
        CategoriaRequest request = new CategoriaRequest();
        request.setNome("Test");
        request.setDescricao("Test description");

        Categoria categoria = adapter.adapt(request);

        assertEquals("Test", categoria.getNome());
        assertEquals("Test description", categoria.getDescricao());
    }

    @Test
    void adaptWithNullListShouldThrowException() {
        CategoriaAdapter adapter = CategoriaAdapter.build();

        assertThrows(ApplicationException.class, () -> adapter.adapt((List<CategoriaRequest>) null));
    }

    @Test
    void adaptWithEmptyListShouldThrowException() {
        CategoriaAdapter adapter = CategoriaAdapter.build();

        assertThrows(ApplicationException.class, () -> adapter.adapt(Arrays.asList()));
    }

    @Test
    void adaptWithValidListShouldReturnList() {
        CategoriaAdapter adapter = CategoriaAdapter.build();
        CategoriaRequest request = new CategoriaRequest();
        request.setNome("Test");
        request.setDescricao("Test description");

        List<Categoria> categorias = adapter.adapt(Arrays.asList(request, request));

        assertEquals(2, categorias.size());
        assertEquals("Test", categorias.get(0).getNome());
        assertEquals("Test description", categorias.get(0).getDescricao());
        assertEquals("Test", categorias.get(1).getNome());
        assertEquals("Test description", categorias.get(1).getDescricao());
    }
}