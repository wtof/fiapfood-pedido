package br.com.fiapfood.pedido.infra.adapter;

import br.com.fiapfood.pedido.domain.entities.Categoria;
import br.com.fiapfood.pedido.infra.entities.CategoriaEntity;
import java.util.ArrayList;
import java.util.List;

public class CategoriaEntityAdapter {
    private CategoriaEntityAdapter() {
    }

    public static CategoriaEntityAdapter build() {
        return new CategoriaEntityAdapter();
    }

    public CategoriaEntity adapt(Categoria categoria) {
        return categoria == null ? null : CategoriaEntity.builder().id(categoria.getId()).nome(categoria.getNome()).descricao(categoria.getDescricao()).build();
    }

    public List<CategoriaEntity> adapt(List<Categoria> categoria) {
        if (categoria != null && !categoria.isEmpty()) {
            List<CategoriaEntity> entities = new ArrayList();
            categoria.forEach((dto) -> {
                entities.add(this.adapt(dto));
            });
            return entities;
        } else {
            return null;
        }
    }
}
