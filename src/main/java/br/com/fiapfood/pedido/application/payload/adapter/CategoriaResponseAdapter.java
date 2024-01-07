package br.com.fiapfood.pedido.application.payload.adapter;

import br.com.fiapfood.pedido.application.exceptions.ApplicationException;
import br.com.fiapfood.pedido.application.payload.response.CategoriaResponse;
import br.com.fiapfood.pedido.domain.entities.Categoria;
import java.util.ArrayList;
import java.util.List;

public class CategoriaResponseAdapter {
    private CategoriaResponseAdapter() {
    }

    public static CategoriaResponseAdapter build() {
        return new CategoriaResponseAdapter();
    }

    public CategoriaResponse adapt(Categoria categoria) {
        if (categoria == null) {
            throw new ApplicationException("Não é possível adaptar um categoria nula");
        } else {
            return CategoriaResponse.builder().id(categoria.getId()).nome(categoria.getNome()).descricao(categoria.getDescricao()).build();
        }
    }

    public List<CategoriaResponse> adapt(List<Categoria> categorias) {
        if (categorias != null && !categorias.isEmpty()) {
            List<CategoriaResponse> clienteResponses = new ArrayList();
            categorias.forEach((categoria) -> {
                clienteResponses.add(this.adapt(categoria));
            });
            return clienteResponses;
        } else {
            throw new ApplicationException("Não é possível adaptar uma lista vazia ou nula de categorias");
        }
    }
}
