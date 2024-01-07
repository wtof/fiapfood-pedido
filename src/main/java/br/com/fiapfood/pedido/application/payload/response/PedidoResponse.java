package br.com.fiapfood.pedido.application.payload.response;

import br.com.fiapfood.pedido.application.payload.dto.StatusPedidoDTO;
import java.util.List;

public class PedidoResponse {
    private Long id;
    private StatusPedidoDTO status;
    private ClienteResponse cliente;
    private List<ItemResponse> itens;
    private List<ComboResponse> combos;

    public static PedidoResponseBuilder builder() {
        return new PedidoResponseBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public StatusPedidoDTO getStatus() {
        return this.status;
    }

    public ClienteResponse getCliente() {
        return this.cliente;
    }

    public List<ItemResponse> getItens() {
        return this.itens;
    }

    public List<ComboResponse> getCombos() {
        return this.combos;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setStatus(final StatusPedidoDTO status) {
        this.status = status;
    }

    public void setCliente(final ClienteResponse cliente) {
        this.cliente = cliente;
    }

    public void setItens(final List<ItemResponse> itens) {
        this.itens = itens;
    }

    public void setCombos(final List<ComboResponse> combos) {
        this.combos = combos;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PedidoResponse)) {
            return false;
        } else {
            PedidoResponse other = (PedidoResponse)o;
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

                Object this$status = this.getStatus();
                Object other$status = other.getStatus();
                if (this$status == null) {
                    if (other$status != null) {
                        return false;
                    }
                } else if (!this$status.equals(other$status)) {
                    return false;
                }

                label57: {
                    Object this$cliente = this.getCliente();
                    Object other$cliente = other.getCliente();
                    if (this$cliente == null) {
                        if (other$cliente == null) {
                            break label57;
                        }
                    } else if (this$cliente.equals(other$cliente)) {
                        break label57;
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
                    if (other$combos == null) {
                        return true;
                    }
                } else if (this$combos.equals(other$combos)) {
                    return true;
                }

                return false;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PedidoResponse;
    }

    public int hashCode() {
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        Object $cliente = this.getCliente();
        result = result * 59 + ($cliente == null ? 43 : $cliente.hashCode());
        Object $itens = this.getItens();
        result = result * 59 + ($itens == null ? 43 : $itens.hashCode());
        Object $combos = this.getCombos();
        result = result * 59 + ($combos == null ? 43 : $combos.hashCode());
        return result;
    }

    public String toString() {
        Long var10000 = this.getId();
        return "PedidoResponse(id=" + var10000 + ", status=" + this.getStatus() + ", cliente=" + this.getCliente() + ", itens=" + this.getItens() + ", combos=" + this.getCombos() + ")";
    }

    public PedidoResponse(final Long id, final StatusPedidoDTO status, final ClienteResponse cliente, final List<ItemResponse> itens, final List<ComboResponse> combos) {
        this.id = id;
        this.status = status;
        this.cliente = cliente;
        this.itens = itens;
        this.combos = combos;
    }

    public PedidoResponse() {
    }

    public static class PedidoResponseBuilder {
        private Long id;
        private StatusPedidoDTO status;
        private ClienteResponse cliente;
        private List<ItemResponse> itens;
        private List<ComboResponse> combos;

        PedidoResponseBuilder() {
        }

        public PedidoResponseBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public PedidoResponseBuilder status(final StatusPedidoDTO status) {
            this.status = status;
            return this;
        }

        public PedidoResponseBuilder cliente(final ClienteResponse cliente) {
            this.cliente = cliente;
            return this;
        }

        public PedidoResponseBuilder itens(final List<ItemResponse> itens) {
            this.itens = itens;
            return this;
        }

        public PedidoResponseBuilder combos(final List<ComboResponse> combos) {
            this.combos = combos;
            return this;
        }

        public PedidoResponse build() {
            return new PedidoResponse(this.id, this.status, this.cliente, this.itens, this.combos);
        }

        public String toString() {
            return "PedidoResponse.PedidoResponseBuilder(id=" + this.id + ", status=" + this.status + ", cliente=" + this.cliente + ", itens=" + this.itens + ", combos=" + this.combos + ")";
        }
    }
}
