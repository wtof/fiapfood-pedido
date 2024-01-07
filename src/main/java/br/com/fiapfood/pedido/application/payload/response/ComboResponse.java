package br.com.fiapfood.pedido.application.payload.response;

import br.com.fiapfood.pedido.application.payload.dto.StatusDTO;
import java.util.List;

public class ComboResponse {
    private Long id;
    private String nome;
    private Float preco;
    private StatusDTO status;
    private List<ItemResponse> itens;

    ComboResponse(final Long id, final String nome, final Float preco, final StatusDTO status, final List<ItemResponse> itens) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.status = status;
        this.itens = itens;
    }

    public static ComboResponseBuilder builder() {
        return new ComboResponseBuilder();
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

    public StatusDTO getStatus() {
        return this.status;
    }

    public List<ItemResponse> getItens() {
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

    public void setStatus(final StatusDTO status) {
        this.status = status;
    }

    public void setItens(final List<ItemResponse> itens) {
        this.itens = itens;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ComboResponse)) {
            return false;
        } else {
            ComboResponse other = (ComboResponse)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label71: {
                    Object this$id = this.getId();
                    Object other$id = other.getId();
                    if (this$id == null) {
                        if (other$id == null) {
                            break label71;
                        }
                    } else if (this$id.equals(other$id)) {
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
                    Object this$nome = this.getNome();
                    Object other$nome = other.getNome();
                    if (this$nome == null) {
                        if (other$nome == null) {
                            break label57;
                        }
                    } else if (this$nome.equals(other$nome)) {
                        break label57;
                    }

                    return false;
                }

                Object this$status = this.getStatus();
                Object other$status = other.getStatus();
                if (this$status == null) {
                    if (other$status != null) {
                        return false;
                    }
                } else if (!this$status.equals(other$status)) {
                    return false;
                }

                Object this$itens = this.getItens();
                Object other$itens = other.getItens();
                if (this$itens == null) {
                    if (other$itens == null) {
                        return true;
                    }
                } else if (this$itens.equals(other$itens)) {
                    return true;
                }

                return false;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ComboResponse;
    }

    public int hashCode() {
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $preco = this.getPreco();
        result = result * 59 + ($preco == null ? 43 : $preco.hashCode());
        Object $nome = this.getNome();
        result = result * 59 + ($nome == null ? 43 : $nome.hashCode());
        Object $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        Object $itens = this.getItens();
        result = result * 59 + ($itens == null ? 43 : $itens.hashCode());
        return result;
    }

    public String toString() {
        Long var10000 = this.getId();
        return "ComboResponse(id=" + var10000 + ", nome=" + this.getNome() + ", preco=" + this.getPreco() + ", status=" + this.getStatus() + ", itens=" + this.getItens() + ")";
    }

    public static class ComboResponseBuilder {
        private Long id;
        private String nome;
        private Float preco;
        private StatusDTO status;
        private List<ItemResponse> itens;

        ComboResponseBuilder() {
        }

        public ComboResponseBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public ComboResponseBuilder nome(final String nome) {
            this.nome = nome;
            return this;
        }

        public ComboResponseBuilder preco(final Float preco) {
            this.preco = preco;
            return this;
        }

        public ComboResponseBuilder status(final StatusDTO status) {
            this.status = status;
            return this;
        }

        public ComboResponseBuilder itens(final List<ItemResponse> itens) {
            this.itens = itens;
            return this;
        }

        public ComboResponse build() {
            return new ComboResponse(this.id, this.nome, this.preco, this.status, this.itens);
        }

        public String toString() {
            return "ComboResponse.ComboResponseBuilder(id=" + this.id + ", nome=" + this.nome + ", preco=" + this.preco + ", status=" + this.status + ", itens=" + this.itens + ")";
        }
    }
}
