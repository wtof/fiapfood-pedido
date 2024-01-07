package br.com.fiapfood.pedido.domain.entities;

import br.com.fiapfood.pedido.domain.enuns.StatusPedido;
import java.util.List;
import java.util.Objects;

public class Pedido {
    private Long id;
    private Cliente cliente;
    private StatusPedido status;
    private List<Item> itens;
    private List<Combo> combos;
    private Long numero;

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Pedido pedido = (Pedido)o;
            return Objects.equals(this.id, pedido.id) && Objects.equals(this.cliente, pedido.cliente) && this.status == pedido.status && Objects.equals(this.itens, pedido.itens) && Objects.equals(this.combos, pedido.combos) && Objects.equals(this.numero, pedido.numero);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id, this.cliente, this.status, this.itens, this.combos, this.numero});
    }

    public static PedidoBuilder builder() {
        return new PedidoBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public StatusPedido getStatus() {
        return this.status;
    }

    public List<Item> getItens() {
        return this.itens;
    }

    public List<Combo> getCombos() {
        return this.combos;
    }

    public Long getNumero() {
        return this.numero;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setCliente(final Cliente cliente) {
        this.cliente = cliente;
    }

    public void setStatus(final StatusPedido status) {
        this.status = status;
    }

    public void setItens(final List<Item> itens) {
        this.itens = itens;
    }

    public void setCombos(final List<Combo> combos) {
        this.combos = combos;
    }

    public void setNumero(final Long numero) {
        this.numero = numero;
    }

    public String toString() {
        Long var10000 = this.getId();
        return "Pedido(id=" + var10000 + ", cliente=" + this.getCliente() + ", status=" + this.getStatus() + ", itens=" + this.getItens() + ", combos=" + this.getCombos() + ", numero=" + this.getNumero() + ")";
    }

    public Pedido(final Long id, final Cliente cliente, final StatusPedido status, final List<Item> itens, final List<Combo> combos, final Long numero) {
        this.id = id;
        this.cliente = cliente;
        this.status = status;
        this.itens = itens;
        this.combos = combos;
        this.numero = numero;
    }

    public Pedido() {
    }

    public static class PedidoBuilder {
        private Long id;
        private Cliente cliente;
        private StatusPedido status;
        private List<Item> itens;
        private List<Combo> combos;
        private Long numero;

        PedidoBuilder() {
        }

        public PedidoBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public PedidoBuilder cliente(final Cliente cliente) {
            this.cliente = cliente;
            return this;
        }

        public PedidoBuilder status(final StatusPedido status) {
            this.status = status;
            return this;
        }

        public PedidoBuilder itens(final List<Item> itens) {
            this.itens = itens;
            return this;
        }

        public PedidoBuilder combos(final List<Combo> combos) {
            this.combos = combos;
            return this;
        }

        public PedidoBuilder numero(final Long numero) {
            this.numero = numero;
            return this;
        }

        public Pedido build() {
            return new Pedido(this.id, this.cliente, this.status, this.itens, this.combos, this.numero);
        }

        public String toString() {
            return "Pedido.PedidoBuilder(id=" + this.id + ", cliente=" + this.cliente + ", status=" + this.status + ", itens=" + this.itens + ", combos=" + this.combos + ", numero=" + this.numero + ")";
        }
    }
}
