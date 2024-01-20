package br.com.fiapfood.pedido.infra.repository;

import br.com.fiapfood.pedido.domain.entities.Cliente;
import br.com.fiapfood.pedido.domain.entities.Cpf;
import br.com.fiapfood.pedido.infra.entities.ClienteEntity;
import br.com.fiapfood.pedido.infra.entities.CpfEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClienteRepositoryJPATest {

    @Mock
    private EntityManager entityManager;

    @Mock
    private TypedQuery<ClienteEntity> query;

    private ClienteRepositoryJPA clienteRepositoryJPA;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        clienteRepositoryJPA = new ClienteRepositoryJPA(entityManager);
    }

    @Test
    void testSalvarCliente() {
        Cliente cliente = new Cliente();
        cliente.setCpf(new Cpf(45071025027L));

        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setCpf(new CpfEntity(45071025027L));
        when(entityManager.merge(any())).thenReturn(clienteEntity);

        Cliente result = clienteRepositoryJPA.salvarCliente(cliente);

        assertNotNull(result);
        verify(entityManager, times(1)).merge(any());
    }

    @Test
    void testBuscarClientePorCpf() {
        Long cpf = 45071025027L;
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setCpf(new CpfEntity(45071025027L));
        when(entityManager.createQuery(anyString(), eq(ClienteEntity.class))).thenReturn(query);
        when(query.getSingleResult()).thenReturn(clienteEntity);

        Cliente result = clienteRepositoryJPA.buscarClientePorCpf(cpf);

        assertNotNull(result);
        verify(entityManager, times(1)).createQuery(anyString(), eq(ClienteEntity.class));
        verify(query, times(1)).setParameter("cpf", cpf);
        verify(query, times(1)).getSingleResult();
    }

    @Test
    void testBuscarClientePorCpf_NoResult() {
        Long cpf = 12345678901L;
        when(entityManager.createQuery(anyString(), eq(ClienteEntity.class))).thenReturn(query);
        when(query.getSingleResult()).thenThrow(NoResultException.class);

        Cliente result = clienteRepositoryJPA.buscarClientePorCpf(cpf);

        assertNull(result);
        verify(entityManager, times(1)).createQuery(anyString(), eq(ClienteEntity.class));
        verify(query, times(1)).setParameter("cpf", cpf);
        verify(query, times(1)).getSingleResult();
    }

    @Test
    void testBuscarClientePorId() {
        Long id = 1L;

        Long cpf = 45071025027L;
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setCpf(new CpfEntity(45071025027L));

        when(entityManager.find(ClienteEntity.class, id)).thenReturn(clienteEntity);

        Cliente result = clienteRepositoryJPA.buscarClientePorId(id);

        assertNotNull(result);
        verify(entityManager, times(1)).find(ClienteEntity.class, id);
    }

    @Test
    void testBuscarClientePorId_NoResult() {
        Long id = 1L;
        when(entityManager.find(ClienteEntity.class, id)).thenThrow(NoResultException.class);

        Cliente result = clienteRepositoryJPA.buscarClientePorId(id);

        assertNull(result);
        verify(entityManager, times(1)).find(ClienteEntity.class, id);
    }
}