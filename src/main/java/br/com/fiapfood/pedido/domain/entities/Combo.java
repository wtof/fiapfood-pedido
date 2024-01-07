package br.com.fiapfood.pedido.domain.entities;

import br.com.fiapfood.pedido.domain.enuns.StatusItem;
import br.com.fiapfood.pedido.domain.exceptions.DominioException;
import java.util.List;
import java.util.Objects;

public class Combo {
    private Long id;
    private String nome;
    private Float preco;
    private StatusItem status;
    private List<Item> itens;
    private Integer quantidade;

    public void validarDados() {
        this.validarDadosObrigatorios();
    }

    private void validarDadosObrigatorios() {
        if (this.itens != null && !this.itens.isEmpty()) {
            if (this.status == null) {
                throw new DominioException("O status do combo está nulo");
            } else if (this.preco == null || this.preco == 0.0F) {
                throw new DominioException("O preço está nulo ou zerado");
            }
        } else {
            throw new DominioException("Não existem itens vinculados no combo");
        }
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Combo combo = (Combo)o;
            return Objects.equals(this.id, combo.id) && Objects.equals(this.nome, combo.nome) && Objects.equals(this.preco, combo.preco) && this.status == combo.status && Objects.equals(this.itens, combo.itens) && Objects.equals(this.quantidade, combo.quantidade);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id, this.nome, this.preco, this.status, this.itens, this.quantidade});
    }

    public static ComboBuilder builder() {
        return new ComboBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public Float getPreco() {
        return this.preco;
    }

    public StatusItem getStatus() {
        return this.status;
    }

    public List<Item> getItens() {
        return this.itens;
    }

    public Integer getQuantidade() {
        return this.quantidade;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public void setPreco(final Float preco) {
        this.preco = preco;
    }

    public void setStatus(final StatusItem status) {
        this.status = status;
    }

    public void setItens(final List<Item> itens) {
        this.itens = itens;
    }

    public void setQuantidade(final Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String toString() {
        Long var10000 = this.getId();
        return "Combo(id=" + var10000 + ", nome=" + this.getNome() + ", preco=" + this.getPreco() + ", status=" + this.getStatus() + ", itens=" + this.getItens() + ", quantidade=" + this.getQuantidade() + ")";
    }

    public Combo(final Long id, final String nome, final Float preco, final StatusItem status, final List<Item> itens, final Integer quantidade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.status = status;
        this.itens = itens;
        this.quantidade = quantidade;
    }

    public Combo() {
    }

    public static class ComboBuilder {
        private Long id;
        private String nome;
        private Float preco;
        private StatusItem status;
        private List<Item> itens;
        private Integer quantidade;

        ComboBuilder() {
        }

        public ComboBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public ComboBuilder nome(final String nome) {
            this.nome = nome;
            return this;
        }

        public ComboBuilder preco(final Float preco) {
            this.preco = preco;
            return this;
        }

        public ComboBuilder status(final StatusItem status) {
            this.status = status;
            return this;
        }

        public ComboBuilder itens(final List<Item> itens) {
            this.itens = itens;
            return this;
        }

        public ComboBuilder quantidade(final Integer quantidade) {
            this.quantidade = quantidade;
            return this;
        }

        public Combo build() {
            return new Combo(this.id, this.nome, this.preco, this.status, this.itens, this.quantidade);
        }

        public String toString() {
            return "Combo.ComboBuilder(id=" + this.id + ", nome=" + this.nome + ", preco=" + this.preco + ", status=" + this.status + ", itens=" + this.itens + ", quantidade=" + this.quantidade + ")";
        }
    }
}
