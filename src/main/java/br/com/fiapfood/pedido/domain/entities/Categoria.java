package br.com.fiapfood.pedido.domain.entities;

import br.com.fiapfood.pedido.domain.exceptions.DominioException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

    private Integer id;

    private String nome;

    private String descricao;

    public void validarDados() {
        validarDadosObrigatorios();
    }

    private void validarDadosObrigatorios() {
        if (this.nome == null || this.nome == "") {
            throw new DominioException("Nome da da categoria esta nulo ou vazio");
        }

        if (this.descricao == null || this.descricao.isEmpty()) {
            throw new DominioException("Descrição está nula ou vazia");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(id, categoria.id) && Objects.equals(nome, categoria.nome) && Objects.equals(descricao, categoria.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao);
    }
}
