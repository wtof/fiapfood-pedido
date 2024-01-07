package br.com.fiapfood.pedido.infra.entities;

import br.com.fiapfood.pedido.domain.enuns.StatusItem;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(
        name = "Combo"
)
public class ComboEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String nome;
    private Float preco;
    @Enumerated(EnumType.ORDINAL)
    private StatusItem status;
    @ManyToMany
    private List<ItemEntity> itens;

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            ComboEntity that = (ComboEntity)o;
            return Objects.equals(this.id, that.id) && Objects.equals(this.nome, that.nome) && Objects.equals(this.preco, that.preco) && this.status == that.status && Objects.equals(this.itens, that.itens);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id, this.nome, this.preco, this.status, this.itens});
    }

    public static ComboEntityBuilder builder() {
        return new ComboEntityBuilder();
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

    public List<ItemEntity> getItens() {
        return this.itens;
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

    public void setItens(final List<ItemEntity> itens) {
        this.itens = itens;
    }

    public String toString() {
        Long var10000 = this.getId();
        return "ComboEntity(id=" + var10000 + ", nome=" + this.getNome() + ", preco=" + this.getPreco() + ", status=" + this.getStatus() + ", itens=" + this.getItens() + ")";
    }

    public ComboEntity(final Long id, final String nome, final Float preco, final StatusItem status, final List<ItemEntity> itens) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.status = status;
        this.itens = itens;
    }

    public ComboEntity() {
    }

    public static class ComboEntityBuilder {
        private Long id;
        private String nome;
        private Float preco;
        private StatusItem status;
        private List<ItemEntity> itens;

        ComboEntityBuilder() {
        }

        public ComboEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public ComboEntityBuilder nome(final String nome) {
            this.nome = nome;
            return this;
        }

        public ComboEntityBuilder preco(final Float preco) {
            this.preco = preco;
            return this;
        }

        public ComboEntityBuilder status(final StatusItem status) {
            this.status = status;
            return this;
        }

        public ComboEntityBuilder itens(final List<ItemEntity> itens) {
            this.itens = itens;
            return this;
        }

        public ComboEntity build() {
            return new ComboEntity(this.id, this.nome, this.preco, this.status, this.itens);
        }

        public String toString() {
            return "ComboEntity.ComboEntityBuilder(id=" + this.id + ", nome=" + this.nome + ", preco=" + this.preco + ", status=" + this.status + ", itens=" + this.itens + ")";
        }
    }
}
