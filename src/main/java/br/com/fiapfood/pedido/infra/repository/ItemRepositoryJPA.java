package br.com.fiapfood.pedido.infra.repository;

import br.com.fiapfood.pedido.domain.entities.Item;
import br.com.fiapfood.pedido.domain.repository.ItemRepository;
import br.com.fiapfood.pedido.infra.adapter.ItemDomainAdapter;
import br.com.fiapfood.pedido.infra.adapter.ItemEntityAdapter;
import br.com.fiapfood.pedido.infra.entities.ItemEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepositoryJPA implements ItemRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    public ItemRepositoryJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public Item salvarItem(Item item) {
        ItemEntity entity = (ItemEntity)this.entityManager.merge(ItemEntityAdapter.build().adapt(item));
        return ItemDomainAdapter.build().adapt(entity);
    }

    @Transactional
    public Item atualizarItem(Item item) {
        ItemEntity entity = (ItemEntity)this.entityManager.merge(ItemEntityAdapter.build().adapt(item));
        return ItemDomainAdapter.build().adapt(entity);
    }

    @Transactional
    public void removerItem(Item item) {
        ItemEntity entity = (ItemEntity)this.entityManager.find(ItemEntity.class, item.getId());
        this.entityManager.remove(entity);
    }

    public Item buscarItemPorId(Long id) {
        try {
            ItemEntity entity = (ItemEntity)this.entityManager.find(ItemEntity.class, id);
            return ItemDomainAdapter.build().adapt(entity);
        } catch (NoResultException var3) {
            return null;
        }
    }

    public List<Item> buscarItensPorIdCategoria(Integer idCategoria) {
        String jpql = "SELECT i FROM ItemEntity i WHERE i.categoria.id = :idCategoria";
        TypedQuery<ItemEntity> query = this.entityManager.createQuery(jpql, ItemEntity.class);
        query.setParameter("idCategoria", idCategoria);

        try {
            return ItemDomainAdapter.build().adapt(query.getResultList());
        } catch (NoResultException var5) {
            return null;
        }
    }

    public List<Item> buscarItensPorNomeCategoria(String nomeCategoria) {
        String jpql = "SELECT i FROM ItemEntity i WHERE i.categoria.nome LIKE :nomeCategoria";
        TypedQuery<ItemEntity> query = this.entityManager.createQuery(jpql, ItemEntity.class);
        query.setParameter("nomeCategoria", "%" + nomeCategoria + "%");

        try {
            List<ItemEntity> entities = query.getResultList();
            return ItemDomainAdapter.build().adapt(entities);
        } catch (NoResultException var5) {
            return null;
        }
    }
}
