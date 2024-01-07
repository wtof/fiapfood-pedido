package br.com.fiapfood.pedido.infra.adapter;

import br.com.fiapfood.pedido.domain.entities.Categoria;
import br.com.fiapfood.pedido.infra.entities.CategoriaEntity;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDomainAdapter {
    private CategoriaDomainAdapter() {
    }

    public static CategoriaDomainAdapter build() {
        return new CategoriaDomainAdapter();
    }

    public Categoria adapt(CategoriaEntity categoriaEntity) {
        return categoriaEntity == null ? null : Categoria.builder().id(categoriaEntity.getId()).nome(categoriaEntity.getNome()).descricao(categoriaEntity.getDescricao()).build();
    }

    public List<Categoria> adapt(List<CategoriaEntity> categoriaEntity) {
        List<Categoria> categorias = new ArrayList();
        categoriaEntity.forEach((dto) -> {
            categorias.add(this.adapt(dto));
        });
        return categorias;
    }
}
