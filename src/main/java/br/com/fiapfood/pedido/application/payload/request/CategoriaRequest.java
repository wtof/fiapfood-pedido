package br.com.fiapfood.pedido.application.payload.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CategoriaRequest {
    private String nome;
    private String descricao;

    public static CategoriaRequestBuilder builder() {
        return new CategoriaRequestBuilder();
    }

    public String getNome() {
        return this.nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CategoriaRequest)) {
            return false;
        } else {
            CategoriaRequest other = (CategoriaRequest)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$nome = this.getNome();
                Object other$nome = other.getNome();
                if (this$nome == null) {
                    if (other$nome != null) {
                        return false;
                    }
                } else if (!this$nome.equals(other$nome)) {
                    return false;
                }

                Object this$descricao = this.getDescricao();
                Object other$descricao = other.getDescricao();
                if (this$descricao == null) {
                    if (other$descricao != null) {
                        return false;
                    }
                } else if (!this$descricao.equals(other$descricao)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CategoriaRequest;
    }

    public int hashCode() {
        int result = 1;
        Object $nome = this.getNome();
        result = result * 59 + ($nome == null ? 43 : $nome.hashCode());
        Object $descricao = this.getDescricao();
        result = result * 59 + ($descricao == null ? 43 : $descricao.hashCode());
        return result;
    }

    public String toString() {
        String var10000 = this.getNome();
        return "CategoriaRequest(nome=" + var10000 + ", descricao=" + this.getDescricao() + ")";
    }

    public CategoriaRequest(final String nome, final String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public static class CategoriaRequestBuilder {
        private String nome;
        private String descricao;

        CategoriaRequestBuilder() {
        }

        public CategoriaRequestBuilder nome(final String nome) {
            this.nome = nome;
            return this;
        }

        public CategoriaRequestBuilder descricao(final String descricao) {
            this.descricao = descricao;
            return this;
        }

        public CategoriaRequest build() {
            return new CategoriaRequest(this.nome, this.descricao);
        }

        public String toString() {
            return "CategoriaRequest.CategoriaRequestBuilder(nome=" + this.nome + ", descricao=" + this.descricao + ")";
        }
    }
}
