package br.com.fiapfood.pedido.application.payload.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EdicaoCategoriaRequest extends CategoriaRequest {

    EdicaoCategoriaRequest(String nome, String descricao) {
        super(nome, descricao);
    }

    private Integer id;

    public void setId(Integer id) {
        this.id = id;
    }
}
