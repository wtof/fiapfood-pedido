package br.com.fiapfood.pedido.domain.entities;

import br.com.fiapfood.pedido.domain.exceptions.DominioException;
import java.util.Objects;

public class Categoria {
    private Integer id;
    private String nome;
    private String descricao;

    public void validarDados() {
        this.validarDadosObrigatorios();
    }

    private void validarDadosObrigatorios() {
        if (this.nome != null && this.nome != "") {
            if (this.descricao == null || this.descricao.isEmpty()) {
                throw new DominioException("Descrição está nula ou vazia");
            }
        } else {
            throw new DominioException("Nome da da categoria esta nulo ou vazio");
        }
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Categoria categoria = (Categoria)o;
            return Objects.equals(this.id, categoria.id) && Objects.equals(this.nome, categoria.nome) && Objects.equals(this.descricao, categoria.descricao);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id, this.nome, this.descricao});
    }

    public static CategoriaBuilder builder() {
        return new CategoriaBuilder();
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
        return "Categoria(id=" + var10000 + ", nome=" + this.getNome() + ", descricao=" + this.getDescricao() + ")";
    }

    public Categoria() {
    }

    public Categoria(final Integer id, final String nome, final String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public static class CategoriaBuilder {
        private Integer id;
        private String nome;
        private String descricao;

        CategoriaBuilder() {
        }

        public CategoriaBuilder id(final Integer id) {
            this.id = id;
            return this;
        }

        public CategoriaBuilder nome(final String nome) {
            this.nome = nome;
            return this;
        }

        public CategoriaBuilder descricao(final String descricao) {
            this.descricao = descricao;
            return this;
        }

        public Categoria build() {
            return new Categoria(this.id, this.nome, this.descricao);
        }

        public String toString() {
            return "Categoria.CategoriaBuilder(id=" + this.id + ", nome=" + this.nome + ", descricao=" + this.descricao + ")";
        }
    }
}
