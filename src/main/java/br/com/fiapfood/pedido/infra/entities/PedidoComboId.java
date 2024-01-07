package br.com.fiapfood.pedido.infra.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

@Embeddable
public class PedidoComboId {
    @ManyToOne
    private PedidoEntity pedido;
    @ManyToOne
    private ComboEntity combo;

    public PedidoEntity getPedido() {
        return this.pedido;
    }

    public ComboEntity getCombo() {
        return this.combo;
    }

    public void setPedido(final PedidoEntity pedido) {
        this.pedido = pedido;
    }

    public void setCombo(final ComboEntity combo) {
        this.combo = combo;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PedidoComboId)) {
            return false;
        } else {
            PedidoComboId other = (PedidoComboId)o;
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

                Object this$combo = this.getCombo();
                Object other$combo = other.getCombo();
                if (this$combo == null) {
                    if (other$combo != null) {
                        return false;
                    }
                } else if (!this$combo.equals(other$combo)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PedidoComboId;
    }

    public int hashCode() {
        int result = 1;
        Object $pedido = this.getPedido();
        result = result * 59 + ($pedido == null ? 43 : $pedido.hashCode());
        Object $combo = this.getCombo();
        result = result * 59 + ($combo == null ? 43 : $combo.hashCode());
        return result;
    }

    public String toString() {
        PedidoEntity var10000 = this.getPedido();
        return "PedidoComboId(pedido=" + var10000 + ", combo=" + this.getCombo() + ")";
    }

    public PedidoComboId(final PedidoEntity pedido, final ComboEntity combo) {
        this.pedido = pedido;
        this.combo = combo;
    }

    public PedidoComboId() {
    }
}
