package br.com.fiapfood.pedido.application.payload.adapter;

import br.com.fiapfood.pedido.application.exceptions.ApplicationException;
import br.com.fiapfood.pedido.application.payload.request.CategoriaRequest;
import br.com.fiapfood.pedido.application.payload.request.EdicaoCategoriaRequest;
import br.com.fiapfood.pedido.domain.entities.Categoria;

import java.util.ArrayList;
import java.util.List;

public class CategoriaAdapter {
    private CategoriaAdapter() {
    }

    public static CategoriaAdapter build() {
        return new CategoriaAdapter();
    }

    public Categoria adapt(CategoriaRequest categoriaRequest) {
        if (categoriaRequest == null) {
            throw new ApplicationException("Não é possível adaptar uma categoria request nula");
        } else {
            EdicaoCategoriaRequest edicao = null;
            if (categoriaRequest instanceof EdicaoCategoriaRequest) {
                edicao = (EdicaoCategoriaRequest)categoriaRequest;
            }

            return Categoria.builder().id(edicao != null ? edicao.getId() : null).nome(categoriaRequest.getNome()).descricao(categoriaRequest.getDescricao()).build();
        }
    }

    public List<Categoria> adapt(List<CategoriaRequest> categoriasRequest) {
        if (categoriasRequest != null && !categoriasRequest.isEmpty()) {
            List<Categoria> categorias = new ArrayList();
            categoriasRequest.forEach((dto) -> {
                categorias.add(this.adapt(dto));
            });
            return categorias;
        } else {
            throw new ApplicationException("Não é possível adaptar uma lista vazia ou nula de categorias request");
        }
    }
}
