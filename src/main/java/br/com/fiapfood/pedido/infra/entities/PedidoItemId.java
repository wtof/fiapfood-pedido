package br.com.fiapfood.pedido.infra.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

@Embeddable
public class PedidoItemId {
    @ManyToOne
    private PedidoEntity pedido;
    @ManyToOne
    private ItemEntity item;

    public PedidoEntity getPedido() {
        return this.pedido;
    }

    public ItemEntity getItem() {
        return this.item;
    }

    public void setPedido(final PedidoEntity pedido) {
        this.pedido = pedido;
    }

    public void setItem(final ItemEntity item) {
        this.item = item;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PedidoItemId)) {
            return false;
        } else {
            PedidoItemId other = (PedidoItemId)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$pedido = this.getPedido();
                Object other$pedido = other.getPedido();
                if (this$pedido == null) {
                    if (other$pedido != null) {
                        return false;
                    }
                } else if (!this$pedido.equals(other$pedido)) {
                    return false;
                }

                Object this$item = this.getItem();
                Object other$item = other.getItem();
                if (this$item == null) {
                    if (other$item != null) {
                        return false;
                    }
                } else if (!this$item.equals(other$item)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PedidoItemId;
    }

    public int hashCode() {
        int result = 1;
        Object $pedido = this.getPedido();
        result = result * 59 + ($pedido == null ? 43 : $pedido.hashCode());
        Object $item = this.getItem();
        result = result * 59 + ($item == null ? 43 : $item.hashCode());
        return result;
    }

    public String toString() {
        PedidoEntity var10000 = this.getPedido();
        return "PedidoItemId(pedido=" + var10000 + ", item=" + this.getItem() + ")";
    }

    public PedidoItemId(final PedidoEntity pedido, final ItemEntity item) {
        this.pedido = pedido;
        this.item = item;
    }

    public PedidoItemId() {
    }
}
