package br.com.fiapfood.pedido.infra.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(
        name = "Categoria"
)
public class CategoriaEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;
    private String nome;
    private String descricao;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else {
            CategoriaEntity other = (CategoriaEntity)obj;
            return Objects.equals(this.id, other.id);
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id});
    }

    public static CategoriaEntityBuilder builder() {
        return new CategoriaEntityBuilder();
    }

    public Integer getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }

    public String toString() {
        Integer var10000 = this.getId();
        return "CategoriaEntity(id=" + var10000 + ", nome=" + this.getNome() + ", descricao=" + this.getDescricao() + ")";
    }

    public CategoriaEntity(final Integer id, final String nome, final String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public CategoriaEntity() {
    }

    public static class CategoriaEntityBuilder {
        private Integer id;
        private String nome;
        private String descricao;

        CategoriaEntityBuilder() {
        }

        public CategoriaEntityBuilder id(final Integer id) {
            this.id = id;
            return this;
        }

        public CategoriaEntityBuilder nome(final String nome) {
            this.nome = nome;
            return this;
        }

        public CategoriaEntityBuilder descricao(final String descricao) {
            this.descricao = descricao;
            return this;
        }

        public CategoriaEntity build() {
            return new CategoriaEntity(this.id, this.nome, this.descricao);
        }

        public String toString() {
            return "CategoriaEntity.CategoriaEntityBuilder(id=" + this.id + ", nome=" + this.nome + ", descricao=" + this.descricao + ")";
        }
    }
}
