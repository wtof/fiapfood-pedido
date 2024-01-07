package br.com.fiapfood.pedido.infra.repository;

import br.com.fiapfood.pedido.domain.entities.Pedido;
import br.com.fiapfood.pedido.domain.enuns.StatusPedido;
import br.com.fiapfood.pedido.domain.repository.PedidoRepository;
import br.com.fiapfood.pedido.infra.adapter.PedidoDomainAdapter;
import br.com.fiapfood.pedido.infra.adapter.PedidoEntityAdapter;
import br.com.fiapfood.pedido.infra.entities.PedidoEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PedidoRepositoryJPA implements PedidoRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public PedidoRepositoryJPA() {
    }

    @Transactional
    public Pedido salvarPedido(Pedido pedido) {
        PedidoEntity pedidoEntity = PedidoEntityAdapter.build().adapt(pedido);
        this.entityManager.persist(pedidoEntity);
        return PedidoDomainAdapter.build().adapt(pedidoEntity);
    }

    @Transactional
    public Pedido atualizarPedido(Pedido pedido) {
        PedidoEntity pedidoEntity = (PedidoEntity)this.entityManager.merge(PedidoEntityAdapter.build().adapt(pedido));
        return PedidoDomainAdapter.build().adapt(pedidoEntity);
    }

    public Pedido buscarPedidoPorId(Long id) {
        try {
            return PedidoDomainAdapter.build().adapt((PedidoEntity)this.entityManager.find(PedidoEntity.class, id));
        } catch (NoResultException var3) {
            return null;
        }
    }

    public List<Pedido> buscarPedidoPorStatus(StatusPedido status) {
        try {
            String jpql = "SELECT p FROM PedidoEntity p WHERE p.status = :status";
            TypedQuery<PedidoEntity> query = this.entityManager.createQuery(jpql, PedidoEntity.class);
            query.setParameter("status", status);
            return PedidoDomainAdapter.build().adapt(query.getResultList());
        } catch (NoResultException var4) {
            return null;
        }
    }

    public List<Pedido> buscarPedidosAtivos() {
        TypedQuery<PedidoEntity> query = this.entityManager.createQuery("SELECT p FROM PedidoEntity p WHERE p.status <> :finalizado ORDER BY CASE     WHEN p.status = :pronto THEN 1     WHEN p.status = :preparacao THEN 2     WHEN p.status = :recebido THEN 3     ELSE 4 END", PedidoEntity.class);
        query.setParameter("finalizado", StatusPedido.FINALIZADO);
        query.setParameter("pronto", StatusPedido.PRONTO);
        query.setParameter("preparacao", StatusPedido.EM_PREPARACAO);
        query.setParameter("recebido", StatusPedido.RECEBIDO);
        return PedidoDomainAdapter.build().adapt(query.getResultList());
    }
}
