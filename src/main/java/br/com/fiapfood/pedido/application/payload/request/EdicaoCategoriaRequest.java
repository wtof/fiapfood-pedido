package br.com.fiapfood.pedido.application.payload.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class EdicaoCategoriaRequest extends CategoriaRequest {
    private Integer id;

    EdicaoCategoriaRequest(String nome, String descricao) {
        super(nome, descricao);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }
}
