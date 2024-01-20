package br.com.fiapfood.pedido.infra.adapter;

import br.com.fiapfood.pedido.domain.entities.Categoria;
import br.com.fiapfood.pedido.infra.entities.CategoriaEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CategoriaEntityAdapterTest {

    private CategoriaEntityAdapter categoriaEntityAdapter;

    @BeforeEach
    void setUp() {
        categoriaEntityAdapter =  CategoriaEntityAdapter.build();
    }

    @Test
    void testAdaptList() {
        Categoria categoria1 = new Categoria();
        categoria1.setId(1);
        categoria1.setNome("Test1");
        categoria1.setDescricao("Test Description1");

        Categoria categoria2 = new Categoria();
        categoria2.setId(2);
        categoria2.setNome("Test2");
        categoria2.setDescricao("Test Description2");

        List<CategoriaEntity> categoriaEntities = categoriaEntityAdapter.adapt(Arrays.asList(categoria1, categoria2));

        assertEquals(2, categoriaEntities.size());
        assertEquals(categoria1.getId(), categoriaEntities.get(0).getId());
        assertEquals(categoria1.getNome(), categoriaEntities.get(0).getNome());
        assertEquals(categoria1.getDescricao(), categoriaEntities.get(0).getDescricao());
        assertEquals(categoria2.getId(), categoriaEntities.get(1).getId());
        assertEquals(categoria2.getNome(), categoriaEntities.get(1).getNome());
        assertEquals(categoria2.getDescricao(), categoriaEntities.get(1).getDescricao());
    }

    @Test
    void testAdaptListNull() {
        List<CategoriaEntity> categoriaEntities = categoriaEntityAdapter.adapt((List<Categoria>) null);
        assertNull(categoriaEntities);
    }

    @Test
    void testAdaptListEmpty() {
        List<CategoriaEntity> categoriaEntities = categoriaEntityAdapter.adapt(Arrays.asList());
        assertNull(categoriaEntities);
    }
}