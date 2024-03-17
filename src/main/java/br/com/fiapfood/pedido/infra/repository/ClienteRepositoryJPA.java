package br.com.fiapfood.pedido.infra.repository;

import br.com.fiapfood.pedido.domain.entities.Cliente;
import br.com.fiapfood.pedido.domain.repository.ClienteRepository;
import br.com.fiapfood.pedido.infra.adapter.ClienteDomainAdapter;
import br.com.fiapfood.pedido.infra.adapter.ClienteEntityAdapter;
import br.com.fiapfood.pedido.infra.entities.ClienteEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepositoryJPA implements ClienteRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    public ClienteRepositoryJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public Cliente salvarCliente(Cliente cliente) {
        ClienteEntity entity = this.entityManager.merge(ClienteEntityAdapter.build().adapt(cliente));
        return ClienteDomainAdapter.build().adapt(entity);
    }

    public Cliente buscarClientePorCpf(Long cpf) {
        TypedQuery<ClienteEntity> query = this.entityManager.createQuery("SELECT c FROM ClienteEntity c WHERE c.cpf.numero = :cpf", ClienteEntity.class);
        query.setParameter("cpf", cpf);

        try {
            return ClienteDomainAdapter.build().adapt(query.getSingleResult());
        } catch (NoResultException var4) {
            return null;
        }
    }

    public Cliente buscarClientePorId(Long id) {
        try {
            return ClienteDomainAdapter.build().adapt(this.entityManager.find(ClienteEntity.class, id));
        } catch (NoResultException var3) {
            return null;
        }
    }

    @Override
    public void deletarClientePorCpf(Long cpf) {
        TypedQuery<ClienteEntity> query = this.entityManager.createQuery("SELECT c FROM ClienteEntity c WHERE c.cpf.numero = :cpf", ClienteEntity.class);
        query.setParameter("cpf", cpf);
        ClienteEntity entity = query.getSingleResult();
        if (entity != null) {
            this.entityManager.remove(entity);
        }
    }
}
