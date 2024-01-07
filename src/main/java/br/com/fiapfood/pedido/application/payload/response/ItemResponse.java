package br.com.fiapfood.pedido.application.payload.response;

import br.com.fiapfood.pedido.application.payload.dto.StatusDTO;
import br.com.fiapfood.pedido.domain.entities.Categoria;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ItemResponse {
    private Long id;
    private String nome;
    private Float preco;
    private Integer quantidadeEstoque;
    private StatusDTO status;
    private Categoria categoria;

    ItemResponse(final Long id, final String nome, final Float preco, final Integer quantidadeEstoque, final StatusDTO status, final Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.status = status;
        this.categoria = categoria;
    }

    public static ItemResponseBuilder builder() {
        return new ItemResponseBuilder();
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

    public Integer getQuantidadeEstoque() {
        return this.quantidadeEstoque;
    }

    public StatusDTO getStatus() {
        return this.status;
    }

    public Categoria getCategoria() {
        return this.categoria;
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

    public void setQuantidadeEstoque(final Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void setStatus(final StatusDTO status) {
        this.status = status;
    }

    public void setCategoria(final Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ItemResponse)) {
            return false;
        } else {
            ItemResponse other = (ItemResponse)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$id = this.getId();
                Object other$id = other.getId();
                if (this$id == null) {
                    if (other$id != null) {
                        return false;
                    }
                } else if (!this$id.equals(other$id)) {
                    return false;
                }

                Object this$preco = this.getPreco();
                Object other$preco = other.getPreco();
                if (this$preco == null) {
                    if (other$preco != null) {
                        return false;
                    }
                } else if (!this$preco.equals(other$preco)) {
                    return false;
                }

                Object this$quantidadeEstoque = this.getQuantidadeEstoque();
                Object other$quantidadeEstoque = other.getQuantidadeEstoque();
                if (this$quantidadeEstoque == null) {
                    if (other$quantidadeEstoque != null) {
                        return false;
                    }
                } else if (!this$quantidadeEstoque.equals(other$quantidadeEstoque)) {
                    return false;
                }

                label62: {
                    Object this$nome = this.getNome();
                    Object other$nome = other.getNome();
                    if (this$nome == null) {
                        if (other$nome == null) {
                            break label62;
                        }
                    } else if (this$nome.equals(other$nome)) {
                        break label62;
                    }

                    return false;
                }

                label55: {
                    Object this$status = this.getStatus();
                    Object other$status = other.getStatus();
                    if (this$status == null) {
                        if (other$status == null) {
                            break label55;
                        }
                    } else if (this$status.equals(other$status)) {
                        break label55;
                    }

                    return false;
                }

                Object this$categoria = this.getCategoria();
                Object other$categoria = other.getCategoria();
                if (this$categoria == null) {
                    if (other$categoria != null) {
                        return false;
                    }
                } else if (!this$categoria.equals(other$categoria)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ItemResponse;
    }

    public int hashCode() {
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $preco = this.getPreco();
        result = result * 59 + ($preco == null ? 43 : $preco.hashCode());
        Object $quantidadeEstoque = this.getQuantidadeEstoque();
        result = result * 59 + ($quantidadeEstoque == null ? 43 : $quantidadeEstoque.hashCode());
        Object $nome = this.getNome();
        result = result * 59 + ($nome == null ? 43 : $nome.hashCode());
        Object $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        Object $categoria = this.getCategoria();
        result = result * 59 + ($categoria == null ? 43 : $categoria.hashCode());
        return result;
    }

    public String toString() {
        Long var10000 = this.getId();
        return "ItemResponse(id=" + var10000 + ", nome=" + this.getNome() + ", preco=" + this.getPreco() + ", quantidadeEstoque=" + this.getQuantidadeEstoque() + ", status=" + this.getStatus() + ", categoria=" + this.getCategoria() + ")";
    }

    public static class ItemResponseBuilder {
        private Long id;
        private String nome;
        private Float preco;
        private Integer quantidadeEstoque;
        private StatusDTO status;
        private Categoria categoria;

        ItemResponseBuilder() {
        }

        public ItemResponseBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public ItemResponseBuilder nome(final String nome) {
            this.nome = nome;
            return this;
        }

        public ItemResponseBuilder preco(final Float preco) {
            this.preco = preco;
            return this;
        }

        public ItemResponseBuilder quantidadeEstoque(final Integer quantidadeEstoque) {
            this.quantidadeEstoque = quantidadeEstoque;
            return this;
        }

        public ItemResponseBuilder status(final StatusDTO status) {
            this.status = status;
            return this;
        }

        public ItemResponseBuilder categoria(final Categoria categoria) {
            this.categoria = categoria;
            return this;
        }

        public ItemResponse build() {
            return new ItemResponse(this.id, this.nome, this.preco, this.quantidadeEstoque, this.status, this.categoria);
        }

        public String toString() {
            return "ItemResponse.ItemResponseBuilder(id=" + this.id + ", nome=" + this.nome + ", preco=" + this.preco + ", quantidadeEstoque=" + this.quantidadeEstoque + ", status=" + this.status + ", categoria=" + this.categoria + ")";
        }
    }
}
