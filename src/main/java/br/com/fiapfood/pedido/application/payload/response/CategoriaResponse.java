package br.com.fiapfood.pedido.application.payload.response;

public class CategoriaResponse {
    private Integer id;
    private String nome;
    private String descricao;

    CategoriaResponse(final Integer id, final String nome, final String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public static CategoriaResponseBuilder builder() {
        return new CategoriaResponseBuilder();
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

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CategoriaResponse)) {
            return false;
        } else {
            CategoriaResponse other = (CategoriaResponse)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$id = this.getId();
                    Object other$id = other.getId();
                    if (this$id == null) {
                        if (other$id == null) {
                            break label47;
                        }
                    } else if (this$id.equals(other$id)) {
                        break label47;
                    }

                    return false;
                }

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
        return other instanceof CategoriaResponse;
    }

    public int hashCode() {
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $nome = this.getNome();
        result = result * 59 + ($nome == null ? 43 : $nome.hashCode());
        Object $descricao = this.getDescricao();
        result = result * 59 + ($descricao == null ? 43 : $descricao.hashCode());
        return result;
    }

    public String toString() {
        Integer var10000 = this.getId();
        return "CategoriaResponse(id=" + var10000 + ", nome=" + this.getNome() + ", descricao=" + this.getDescricao() + ")";
    }

    public static class CategoriaResponseBuilder {
        private Integer id;
        private String nome;
        private String descricao;

        CategoriaResponseBuilder() {
        }

        public CategoriaResponseBuilder id(final Integer id) {
            this.id = id;
            return this;
        }

        public CategoriaResponseBuilder nome(final String nome) {
            this.nome = nome;
            return this;
        }

        public CategoriaResponseBuilder descricao(final String descricao) {
            this.descricao = descricao;
            return this;
        }

        public CategoriaResponse build() {
            return new CategoriaResponse(this.id, this.nome, this.descricao);
        }

        public String toString() {
            return "CategoriaResponse.CategoriaResponseBuilder(id=" + this.id + ", nome=" + this.nome + ", descricao=" + this.descricao + ")";
        }
    }
}
