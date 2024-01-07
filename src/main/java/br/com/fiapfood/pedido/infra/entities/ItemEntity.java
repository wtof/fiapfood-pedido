package br.com.fiapfood.pedido.infra.entities;

import br.com.fiapfood.pedido.domain.enuns.StatusItem;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(
        name = "Item"
)
public class ItemEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @ManyToOne
    private CategoriaEntity categoria;
    private String nome;
    @Column(
            precision = 2
    )
    private Float preco;
    private Integer quantidadeEstoque;
    @Enumerated(EnumType.ORDINAL)
    private StatusItem status;

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            ItemEntity that = (ItemEntity)o;
            return Objects.equals(this.id, that.id) && Objects.equals(this.categoria, that.categoria) && Objects.equals(this.nome, that.nome) && Objects.equals(this.preco, that.preco) && Objects.equals(this.quantidadeEstoque, that.quantidadeEstoque) && this.status == that.status;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id, this.categoria, this.nome, this.preco, this.quantidadeEstoque, this.status});
    }

    public static ItemEntityBuilder builder() {
        return new ItemEntityBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public CategoriaEntity getCategoria() {
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

    public StatusItem getStatus() {
        return this.status;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setCategoria(final CategoriaEntity categoria) {
        this.categoria = categoria;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public void setPreco(final Float preco) {
        this.preco = preco;
    }

    public void setQuantidadeEstoque(final Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void setStatus(final StatusItem status) {
        this.status = status;
    }

    public String toString() {
        Long var10000 = this.getId();
        return "ItemEntity(id=" + var10000 + ", categoria=" + this.getCategoria() + ", nome=" + this.getNome() + ", preco=" + this.getPreco() + ", quantidadeEstoque=" + this.getQuantidadeEstoque() + ", status=" + this.getStatus() + ")";
    }

    public ItemEntity() {
    }

    public ItemEntity(final Long id, final CategoriaEntity categoria, final String nome, final Float preco, final Integer quantidadeEstoque, final StatusItem status) {
        this.id = id;
        this.categoria = categoria;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.status = status;
    }

    public static class ItemEntityBuilder {
        private Long id;
        private CategoriaEntity categoria;
        private String nome;
        private Float preco;
        private Integer quantidadeEstoque;
        private StatusItem status;

        ItemEntityBuilder() {
        }

        public ItemEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public ItemEntityBuilder categoria(final CategoriaEntity categoria) {
            this.categoria = categoria;
            return this;
        }

        public ItemEntityBuilder nome(final String nome) {
            this.nome = nome;
            return this;
        }

        public ItemEntityBuilder preco(final Float preco) {
            this.preco = preco;
            return this;
        }

        public ItemEntityBuilder quantidadeEstoque(final Integer quantidadeEstoque) {
            this.quantidadeEstoque = quantidadeEstoque;
            return this;
        }

        public ItemEntityBuilder status(final StatusItem status) {
            this.status = status;
            return this;
        }

        public ItemEntity build() {
            return new ItemEntity(this.id, this.categoria, this.nome, this.preco, this.quantidadeEstoque, this.status);
        }

        public String toString() {
            return "ItemEntity.ItemEntityBuilder(id=" + this.id + ", categoria=" + this.categoria + ", nome=" + this.nome + ", preco=" + this.preco + ", quantidadeEstoque=" + this.quantidadeEstoque + ", status=" + this.status + ")";
        }
    }
}
