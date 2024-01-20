package br.com.fiapfood.pedido.infra.repository;

import br.com.fiapfood.pedido.domain.entities.Categoria;
import br.com.fiapfood.pedido.infra.entities.CategoriaEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoriaRepositoryJPATest {

    @Mock
    private EntityManager entityManager;

    @Mock
    private TypedQuery<CategoriaEntity> query;

    private CategoriaRepositoryJPA categoriaRepositoryJPA;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        categoriaRepositoryJPA = new CategoriaRepositoryJPA(entityManager);
    }

    @Test
    void testBuscarCategoriaPorId() {
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        when(entityManager.find(CategoriaEntity.class, 1)).thenReturn(categoriaEntity);

        Categoria result = categoriaRepositoryJPA.buscarCategoriaPorId(1);

        assertNotNull(result);
        verify(entityManager, times(1)).find(CategoriaEntity.class, 1);
    }

    @Test
    void testBuscarCategoriaPorId_NoResult() {
        when(entityManager.find(CategoriaEntity.class, 1)).thenThrow(NoResultException.class);

        Categoria result = categoriaRepositoryJPA.buscarCategoriaPorId(1);

        assertNull(result);
        verify(entityManager, times(1)).find(CategoriaEntity.class, 1);
    }

    @Test
    void testSalvarCategoria() {
        Categoria categoria = new Categoria();
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        when(entityManager.merge(any())).thenReturn(categoriaEntity);

        Categoria result = categoriaRepositoryJPA.salvarCategoria(categoria);

        assertNotNull(result);
        verify(entityManager, times(1)).merge(any());
    }

    @Test
    void testBuscarTodasCategorias() {
        List<CategoriaEntity> categoriaEntities = Collections.singletonList(new CategoriaEntity());
        when(entityManager.createQuery(anyString(), eq(CategoriaEntity.class))).thenReturn(query);
        when(query.getResultList()).thenReturn(categoriaEntities);

        List<Categoria> result = categoriaRepositoryJPA.buscarTodasCategorias();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        verify(entityManager, times(1)).createQuery(anyString(), eq(CategoriaEntity.class));
        verify(query, times(1)).getResultList();
    }

    @Test
    void testRemoverCategoria() {
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        when(entityManager.find(CategoriaEntity.class, 1)).thenReturn(categoriaEntity);

        categoriaRepositoryJPA.removerCategoria(1);

        verify(entityManager, times(1)).find(CategoriaEntity.class, 1);
        verify(entityManager, times(1)).remove(categoriaEntity);
    }

    @Test
    void testBuscarCategoriaPorNome() {
        String nomeCategoria = "Test";
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        when(entityManager.createQuery(anyString(), eq(CategoriaEntity.class))).thenReturn(query);
        when(query.getSingleResult()).thenReturn(categoriaEntity);

        Categoria result = categoriaRepositoryJPA.buscarCategoriaPorNome(nomeCategoria);

        assertNotNull(result);
        verify(entityManager, times(1)).createQuery(anyString(), eq(CategoriaEntity.class));
        verify(query, times(1)).setParameter("nomeCategoria", nomeCategoria);
        verify(query, times(1)).getSingleResult();
    }
}