package br.com.fiapfood.pedido.domain.entities;

import br.com.fiapfood.pedido.domain.enuns.StatusItem;
import br.com.fiapfood.pedido.domain.exceptions.DominioException;
import java.util.Objects;

public class Item {
    private Long id;
    private Categoria categoria;
    private String nome;
    private Float preco;
    private Integer quantidadeEstoque;
    private Integer quantidade;
    private StatusItem status;

    public void setNome(String nome) {
        this.nome = nome != null ? nome.toUpperCase() : null;
    }

    public void validarDados() {
        this.validarDadosObrigatorios();
    }

    private void validarDadosObrigatorios() {
        if (this.categoria == null) {
            throw new DominioException("A categoria do Item esta nula");
        } else if (this.nome != null && this.nome != "") {
            if (this.preco != null && this.preco != 0.0F) {
                if (this.status == null) {
                    throw new DominioException("O status do Item está nulo");
                }
            } else {
                throw new DominioException("O preco do Item está nulo ou zerado");
            }
        } else {
            throw new DominioException("O nome do Item está nulo ou vazio");
        }
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Item item = (Item)o;
            return Objects.equals(this.id, item.id) && Objects.equals(this.categoria, item.categoria) && Objects.equals(this.nome, item.nome) && Objects.equals(this.preco, item.preco) && Objects.equals(this.quantidadeEstoque, item.quantidadeEstoque) && Objects.equals(this.quantidade, item.quantidade) && this.status == item.status;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id, this.categoria, this.nome, this.preco, this.quantidadeEstoque, this.quantidade, this.status});
    }

    public static ItemBuilder builder() {
        return new ItemBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public String getNome() {
        return this.nome;
    }

    public Float getPreco() {
        return this.preco;
    }

    public Integer getQuantidadeEstoque() {
        return this.quantidadeEstoque;
    }

    public Integer getQuantidade() {
        return this.quantidade;
    }

    public StatusItem getStatus() {
        return this.status;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setCategoria(final Categoria categoria) {
        this.categoria = categoria;
    }

    public void setPreco(final Float preco) {
        this.preco = preco;
    }

    public void setQuantidadeEstoque(final Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void setQuantidade(final Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setStatus(final StatusItem status) {
        this.status = status;
    }

    public String toString() {
        Long var10000 = this.getId();
        return "Item(id=" + var10000 + ", categoria=" + this.getCategoria() + ", nome=" + this.getNome() + ", preco=" + this.getPreco() + ", quantidadeEstoque=" + this.getQuantidadeEstoque() + ", quantidade=" + this.getQuantidade() + ", status=" + this.getStatus() + ")";
    }

    public Item() {
    }

    public Item(final Long id, final Categoria categoria, final String nome, final Float preco, final Integer quantidadeEstoque, final Integer quantidade, final StatusItem status) {
        this.id = id;
        this.categoria = categoria;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.quantidade = quantidade;
        this.status = status;
    }

    public static class ItemBuilder {
        private Long id;
        private Categoria categoria;
        private String nome;
        private Float preco;
        private Integer quantidadeEstoque;
        private Integer quantidade;
        private StatusItem status;

        ItemBuilder() {
        }

        public ItemBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public ItemBuilder categoria(final Categoria categoria) {
            this.categoria = categoria;
            return this;
        }

        public ItemBuilder nome(final String nome) {
            this.nome = nome;
            return this;
        }

        public ItemBuilder preco(final Float preco) {
            this.preco = preco;
            return this;
        }

        public ItemBuilder quantidadeEstoque(final Integer quantidadeEstoque) {
            this.quantidadeEstoque = quantidadeEstoque;
            return this;
        }

        public ItemBuilder quantidade(final Integer quantidade) {
            this.quantidade = quantidade;
            return this;
        }

        public ItemBuilder status(final StatusItem status) {
            this.status = status;
            return this;
        }

        public Item build() {
            return new Item(this.id, this.categoria, this.nome, this.preco, this.quantidadeEstoque, this.quantidade, this.status);
        }

        public String toString() {
            return "Item.ItemBuilder(id=" + this.id + ", categoria=" + this.categoria + ", nome=" + this.nome + ", preco=" + this.preco + ", quantidadeEstoque=" + this.quantidadeEstoque + ", quantidade=" + this.quantidade + ", status=" + this.status + ")";
        }
    }
}
