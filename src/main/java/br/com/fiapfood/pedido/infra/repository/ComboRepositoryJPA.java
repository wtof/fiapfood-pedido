package br.com.fiapfood.pedido.infra.repository;

import br.com.fiapfood.pedido.domain.entities.Combo;
import br.com.fiapfood.pedido.domain.repository.ComboRepository;
import br.com.fiapfood.pedido.infra.adapter.ComboDomainAdapter;
import br.com.fiapfood.pedido.infra.adapter.ComboEntityAdapter;
import br.com.fiapfood.pedido.infra.entities.ComboEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class ComboRepositoryJPA implements ComboRepository {
    @PersistenceContext
    private final EntityManager entityManager;


    public ComboRepositoryJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public Combo salvarCombo(Combo combo) {
        ComboEntity comboEntity = ComboEntityAdapter.build().adapt(combo);
        this.entityManager.persist(comboEntity);
        return ComboDomainAdapter.build().adapt(comboEntity);
    }

    public Combo atualizarCombo(Combo combo) {
        ComboEntity comboEntity = (ComboEntity)this.entityManager.merge(ComboEntityAdapter.build().adapt(combo));
        return ComboDomainAdapter.build().adapt(comboEntity);
    }

    public void removerCombo(Combo combo) {
        this.entityManager.remove(ComboEntityAdapter.build().adapt(combo));
    }

    public Combo buscarComboPorId(Long id) {
        try {
            ComboEntity comboEntity = (ComboEntity)this.entityManager.find(ComboEntity.class, id);
            return ComboDomainAdapter.build().adapt(comboEntity);
        } catch (NoResultException var3) {
            return null;
        }
    }
}
