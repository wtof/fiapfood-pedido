package br.com.fiapfood.pedido.domain.entities;

import br.com.fiapfood.pedido.domain.enuns.StatusItem;
import br.com.fiapfood.pedido.domain.exceptions.DominioException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Combo {

    private Long id;

    private String nome;

    private Float preco;

    private StatusItem status;

    private List<Item> itens;

    private Integer quantidade;

    public void validarDados() {
        validarDadosObrigatorios();
    }

    private void validarDadosObrigatorios() {

        if (this.itens == null || this.itens.isEmpty()) {
            throw new DominioException("Não existem itens vinculados no combo");
        }

        if (this.status == null) {
            throw new DominioException("O status do combo está nulo");
        }

        if (this.preco == null || this.preco == 0) {
            throw new DominioException("O preço está nulo ou zerado");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Combo combo = (Combo) o;
        return Objects.equals(id, combo.id) && Objects.equals(nome, combo.nome)
                && Objects.equals(preco, combo.preco) && status == combo.status
                && Objects.equals(itens, combo.itens) && Objects.equals(quantidade, combo.quantidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, preco, status, itens, quantidade);
    }
}