package br.com.fiapfood.pedido.application.payload.request;

import br.com.fiapfood.pedido.application.payload.dto.ItemComboDTO;
import br.com.fiapfood.pedido.application.payload.dto.StatusDTO;
import java.util.List;

public class ComboRequest {
    private String nome;
    private Float preco;
    private StatusDTO status;
    private List<ItemComboDTO> itens;

    ComboRequest(final String nome, final Float preco, final StatusDTO status, final List<ItemComboDTO> itens) {
        this.nome = nome;
        this.preco = preco;
        this.status = status;
        this.itens = itens;
    }

    public static ComboRequestBuilder builder() {
        return new ComboRequestBuilder();
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

    public List<ItemComboDTO> getItens() {
        return this.itens;
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

    public void setItens(final List<ItemComboDTO> itens) {
        this.itens = itens;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ComboRequest)) {
            return false;
        } else {
            ComboRequest other = (ComboRequest)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59: {
                    Object this$preco = this.getPreco();
                    Object other$preco = other.getPreco();
                    if (this$preco == null) {
                        if (other$preco == null) {
                            break label59;
                        }
                    } else if (this$preco.equals(other$preco)) {
                        break label59;
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
                    if (other$status != null) {
                        return false;
                    }
                } else if (!this$status.equals(other$status)) {
                    return false;
                }

                Object this$itens = this.getItens();
                Object other$itens = other.getItens();
                if (this$itens == null) {
                    if (other$itens != null) {
                        return false;
                    }
                } else if (!this$itens.equals(other$itens)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ComboRequest;
    }

    public int hashCode() {
        int result = 1;
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
        String var10000 = this.getNome();
        return "ComboRequest(nome=" + var10000 + ", preco=" + this.getPreco() + ", status=" + this.getStatus() + ", itens=" + this.getItens() + ")";
    }

    public static class ComboRequestBuilder {
        private String nome;
        private Float preco;
        private StatusDTO status;
        private List<ItemComboDTO> itens;

        ComboRequestBuilder() {
        }

        public ComboRequestBuilder nome(final String nome) {
            this.nome = nome;
            return this;
        }

        public ComboRequestBuilder preco(final Float preco) {
            this.preco = preco;
            return this;
        }

        public ComboRequestBuilder status(final StatusDTO status) {
            this.status = status;
            return this;
        }

        public ComboRequestBuilder itens(final List<ItemComboDTO> itens) {
            this.itens = itens;
            return this;
        }

        public ComboRequest build() {
            return new ComboRequest(this.nome, this.preco, this.status, this.itens);
        }

        public String toString() {
            return "ComboRequest.ComboRequestBuilder(nome=" + this.nome + ", preco=" + this.preco + ", status=" + this.status + ", itens=" + this.itens + ")";
        }
    }
}
