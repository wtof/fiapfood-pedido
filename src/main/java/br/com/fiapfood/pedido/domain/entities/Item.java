package br.com.fiapfood.pedido.domain.entities;

import br.com.fiapfood.pedido.domain.enuns.StatusItem;
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
public class Item {

    private Long id;

    private Categoria categoria;

    private String nome;

    private Float preco;

    private Integer quantidadeEstoque;

    private Integer quantidade;

    private StatusItem status;

    public void setNome(String nome) {
        this.nome = nome != null ?  nome.toUpperCase() : null;
    }

    public void validarDados() {
        validarDadosObrigatorios();
    }

    private void validarDadosObrigatorios() {
        if (this.categoria == null) {
            throw new DominioException("A categoria do Item esta nula");
        }

        if (this.nome == null || this.nome == "") {
            throw new DominioException("O nome do Item está nulo ou vazio");
        }

        if (this.preco == null || this.preco == 0) {
            throw new DominioException("O preco do Item está nulo ou zerado");
        }

        if (this.status == null) {
            throw new DominioException("O status do Item está nulo");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id) && Objects.equals(categoria, item.categoria) && Objects.equals(nome, item.nome) && Objects.equals(preco, item.preco) && Objects.equals(quantidadeEstoque, item.quantidadeEstoque) && Objects.equals(quantidade, item.quantidade) && status == item.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoria, nome, preco, quantidadeEstoque, quantidade, status);
    }
}