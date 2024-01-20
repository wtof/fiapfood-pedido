package br.com.fiapfood.pedido.infra.repository;

import br.com.fiapfood.pedido.domain.entities.Categoria;
import br.com.fiapfood.pedido.domain.repository.CategoriaRepository;
import br.com.fiapfood.pedido.infra.adapter.CategoriaDomainAdapter;
import br.com.fiapfood.pedido.infra.adapter.CategoriaEntityAdapter;
import br.com.fiapfood.pedido.infra.entities.CategoriaEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoriaRepositoryJPA implements CategoriaRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    public CategoriaRepositoryJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Categoria buscarCategoriaPorId(Integer idCategoria) {
        try {
            return CategoriaDomainAdapter.build().adapt((CategoriaEntity)this.entityManager.find(CategoriaEntity.class, idCategoria));
        } catch (NoResultException var3) {
            return null;
        }
    }

    @Transactional
    public Categoria salvarCategoria(Categoria categoria) {
        CategoriaEntity entity = (CategoriaEntity)this.entityManager.merge(CategoriaEntityAdapter.build().adapt(categoria));
        return CategoriaDomainAdapter.build().adapt(entity);
    }

    public List<Categoria> buscarTodasCategorias() {
        try {
            TypedQuery<CategoriaEntity> query = this.entityManager.createQuery("SELECT c FROM CategoriaEntity c", CategoriaEntity.class);
            return CategoriaDomainAdapter.build().adapt(query.getResultList());
        } catch (NoResultException var2) {
            return null;
        }
    }

    @Transactional
    public void removerCategoria(Integer idCategoria) {
        CategoriaEntity categoriaEntity = (CategoriaEntity)this.entityManager.find(CategoriaEntity.class, idCategoria);
        this.entityManager.remove(categoriaEntity);
    }

    public Categoria buscarCategoriaPorNome(String nomeCategoria) {
        String jpql = "SELECT c FROM CategoriaEntity c WHERE c.nome = :nomeCategoria";
        TypedQuery<CategoriaEntity> query = this.entityManager.createQuery(jpql, CategoriaEntity.class);
        query.setParameter("nomeCategoria", nomeCategoria);

        try {
            return CategoriaDomainAdapter.build().adapt((CategoriaEntity)query.getSingleResult());
        } catch (NoResultException var5) {
            return null;
        }
    }
}
