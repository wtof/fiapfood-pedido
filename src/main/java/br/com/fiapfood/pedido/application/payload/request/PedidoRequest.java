package br.com.fiapfood.pedido.application.payload.request;

import br.com.fiapfood.pedido.application.payload.dto.ComboDTO;
import br.com.fiapfood.pedido.application.payload.dto.ItemDTO;
import java.util.List;

public class PedidoRequest {
    private Long clienteId;
    private List<ItemDTO> itens;
    private List<ComboDTO> combos;

    public static PedidoRequestBuilder builder() {
        return new PedidoRequestBuilder();
    }

    public Long getClienteId() {
        return this.clienteId;
    }

    public List<ItemDTO> getItens() {
        return this.itens;
    }

    public List<ComboDTO> getCombos() {
        return this.combos;
    }

    public void setClienteId(final Long clienteId) {
        this.clienteId = clienteId;
    }

    public void setItens(final List<ItemDTO> itens) {
        this.itens = itens;
    }

    public void setCombos(final List<ComboDTO> combos) {
        this.combos = combos;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PedidoRequest)) {
            return false;
        } else {
            PedidoRequest other = (PedidoRequest)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$clienteId = this.getClienteId();
                    Object other$clienteId = other.getClienteId();
                    if (this$clienteId == null) {
                        if (other$clienteId == null) {
                            break label47;
                        }
                    } else if (this$clienteId.equals(other$clienteId)) {
                        break label47;
                    }

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

                Object this$combos = this.getCombos();
                Object other$combos = other.getCombos();
                if (this$combos == null) {
                    if (other$combos != null) {
                        return false;
                    }
                } else if (!this$combos.equals(other$combos)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PedidoRequest;
    }

    public int hashCode() {
        int result = 1;
        Object $clienteId = this.getClienteId();
        result = result * 59 + ($clienteId == null ? 43 : $clienteId.hashCode());
        Object $itens = this.getItens();
        result = result * 59 + ($itens == null ? 43 : $itens.hashCode());
        Object $combos = this.getCombos();
        result = result * 59 + ($combos == null ? 43 : $combos.hashCode());
        return result;
    }

    public String toString() {
        Long var10000 = this.getClienteId();
        return "PedidoRequest(clienteId=" + var10000 + ", itens=" + this.getItens() + ", combos=" + this.getCombos() + ")";
    }

    public PedidoRequest(final Long clienteId, final List<ItemDTO> itens, final List<ComboDTO> combos) {
        this.clienteId = clienteId;
        this.itens = itens;
        this.combos = combos;
    }

    public PedidoRequest() {
    }

    public static class PedidoRequestBuilder {
        private Long clienteId;
        private List<ItemDTO> itens;
        private List<ComboDTO> combos;

        PedidoRequestBuilder() {
        }

        public PedidoRequestBuilder clienteId(final Long clienteId) {
            this.clienteId = clienteId;
            return this;
        }

        public PedidoRequestBuilder itens(final List<ItemDTO> itens) {
            this.itens = itens;
            return this;
        }

        public PedidoRequestBuilder combos(final List<ComboDTO> combos) {
            this.combos = combos;
            return this;
        }

        public PedidoRequest build() {
            return new PedidoRequest(this.clienteId, this.itens, this.combos);
        }

        public String toString() {
            return "PedidoRequest.PedidoRequestBuilder(clienteId=" + this.clienteId + ", itens=" + this.itens + ", combos=" + this.combos + ")";
        }
    }
}
