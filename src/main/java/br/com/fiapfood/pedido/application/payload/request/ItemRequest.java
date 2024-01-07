package br.com.fiapfood.pedido.application.payload.request;

import br.com.fiapfood.pedido.application.payload.dto.StatusDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ItemRequest {
    private Integer categoriaId;
    private String nome;
    private Float preco;
    private Integer quantidadeEstoque;
    private StatusDTO status;

    ItemRequest(final Integer categoriaId, final String nome, final Float preco, final Integer quantidadeEstoque, final StatusDTO status) {
        this.categoriaId = categoriaId;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.status = status;
    }

    public static ItemRequestBuilder builder() {
        return new ItemRequestBuilder();
    }

    public Integer getCategoriaId() {
        return this.categoriaId;
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

    public void setCategoriaId(final Integer categoriaId) {
        this.categoriaId = categoriaId;
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

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ItemRequest)) {
            return false;
        } else {
            ItemRequest other = (ItemRequest)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label71: {
                    Object this$categoriaId = this.getCategoriaId();
                    Object other$categoriaId = other.getCategoriaId();
                    if (this$categoriaId == null) {
                        if (other$categoriaId == null) {
                            break label71;
                        }
                    } else if (this$categoriaId.equals(other$categoriaId)) {
                        break label71;
                    }

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

                label57: {
                    Object this$quantidadeEstoque = this.getQuantidadeEstoque();
                    Object other$quantidadeEstoque = other.getQuantidadeEstoque();
                    if (this$quantidadeEstoque == null) {
                        if (other$quantidadeEstoque == null) {
                            break label57;
                        }
                    } else if (this$quantidadeEstoque.equals(other$quantidadeEstoque)) {
                        break label57;
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

                Object this$status = this.getStatus();
                Object other$status = other.getStatus();
                if (this$status == null) {
                    if (other$status == null) {
                        return true;
                    }
                } else if (this$status.equals(other$status)) {
                    return true;
                }

                return false;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ItemRequest;
    }

    public int hashCode() {
        int result = 1;
        Object $categoriaId = this.getCategoriaId();
        result = result * 59 + ($categoriaId == null ? 43 : $categoriaId.hashCode());
        Object $preco = this.getPreco();
        result = result * 59 + ($preco == null ? 43 : $preco.hashCode());
        Object $quantidadeEstoque = this.getQuantidadeEstoque();
        result = result * 59 + ($quantidadeEstoque == null ? 43 : $quantidadeEstoque.hashCode());
        Object $nome = this.getNome();
        result = result * 59 + ($nome == null ? 43 : $nome.hashCode());
        Object $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        return result;
    }

    public String toString() {
        Integer var10000 = this.getCategoriaId();
        return "ItemRequest(categoriaId=" + var10000 + ", nome=" + this.getNome() + ", preco=" + this.getPreco() + ", quantidadeEstoque=" + this.getQuantidadeEstoque() + ", status=" + this.getStatus() + ")";
    }

    public static class ItemRequestBuilder {
        private Integer categoriaId;
        private String nome;
        private Float preco;
        private Integer quantidadeEstoque;
        private StatusDTO status;

        ItemRequestBuilder() {
        }

        public ItemRequestBuilder categoriaId(final Integer categoriaId) {
            this.categoriaId = categoriaId;
            return this;
        }

        public ItemRequestBuilder nome(final String nome) {
            this.nome = nome;
            return this;
        }

        public ItemRequestBuilder preco(final Float preco) {
            this.preco = preco;
            return this;
        }

        public ItemRequestBuilder quantidadeEstoque(final Integer quantidadeEstoque) {
            this.quantidadeEstoque = quantidadeEstoque;
            return this;
        }

        public ItemRequestBuilder status(final StatusDTO status) {
            this.status = status;
            return this;
        }

        public ItemRequest build() {
            return new ItemRequest(this.categoriaId, this.nome, this.preco, this.quantidadeEstoque, this.status);
        }

        public String toString() {
            return "ItemRequest.ItemRequestBuilder(categoriaId=" + this.categoriaId + ", nome=" + this.nome + ", preco=" + this.preco + ", quantidadeEstoque=" + this.quantidadeEstoque + ", status=" + this.status + ")";
        }
    }
}
