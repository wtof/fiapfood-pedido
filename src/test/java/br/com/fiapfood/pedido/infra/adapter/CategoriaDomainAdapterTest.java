package br.com.fiapfood.pedido.infra.adapter;

import br.com.fiapfood.pedido.domain.entities.Categoria;
import br.com.fiapfood.pedido.infra.entities.CategoriaEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CategoriaDomainAdapterTest {

    private CategoriaDomainAdapter categoriaDomainAdapter;

    @BeforeEach
    void setUp() {
        categoriaDomainAdapter = CategoriaDomainAdapter.build();
    }

    @Test
    void testAdaptSingleEntity() {
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setId(1);
        categoriaEntity.setNome("Test");
        categoriaEntity.setDescricao("Test Description");

        Categoria categoria = categoriaDomainAdapter.adapt(categoriaEntity);

        assertEquals(categoriaEntity.getId(), categoria.getId());
        assertEquals(categoriaEntity.getNome(), categoria.getNome());
        assertEquals(categoriaEntity.getDescricao(), categoria.getDescricao());
    }

    @Test
    void testAdaptSingleEntityNull() {
        Categoria categoria = categoriaDomainAdapter.adapt((CategoriaEntity) null);
        assertNull(categoria);
    }

    @Test
    void testAdaptEntityList() {
        CategoriaEntity categoriaEntity1 = new CategoriaEntity();
        categoriaEntity1.setId(1);
        categoriaEntity1.setNome("Test1");
        categoriaEntity1.setDescricao("Test Description1");

        CategoriaEntity categoriaEntity2 = new CategoriaEntity();
        categoriaEntity2.setId(2);
        categoriaEntity2.setNome("Test2");
        categoriaEntity2.setDescricao("Test Description2");

        List<Categoria> categorias = categoriaDomainAdapter.adapt(Arrays.asList(categoriaEntity1, categoriaEntity2));

        assertEquals(2, categorias.size());
        assertEquals(categoriaEntity1.getId(), categorias.get(0).getId());
        assertEquals(categoriaEntity1.getNome(), categorias.get(0).getNome());
        assertEquals(categoriaEntity1.getDescricao(), categorias.get(0).getDescricao());
        assertEquals(categoriaEntity2.getId(), categorias.get(1).getId());
        assertEquals(categoriaEntity2.getNome(), categorias.get(1).getNome());
        assertEquals(categoriaEntity2.getDescricao(), categorias.get(1).getDescricao());
    }
}