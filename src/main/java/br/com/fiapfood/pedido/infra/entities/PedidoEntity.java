package br.com.fiapfood.pedido.infra.entities;

import br.com.fiapfood.pedido.domain.enuns.StatusPedido;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(
        name = "Pedido"
)
public class PedidoEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @ManyToOne
    private ClienteEntity cliente;
    private StatusPedido status;
    @OneToMany(
            mappedBy = "id.pedido",
            cascade = {CascadeType.ALL},
            orphanRemoval = false,
            fetch = FetchType.EAGER
    )
    private List<PedidoItemEntity> pedidoItens;
    @OneToMany(
            mappedBy = "id.pedido",
            cascade = {CascadeType.ALL},
            orphanRemoval = false,
            fetch = FetchType.EAGER
    )
    private List<PedidoComboEntity> pedidoCombos;

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            PedidoEntity that = (PedidoEntity)o;
            return Objects.equals(this.id, that.id) && Objects.equals(this.cliente, that.cliente) && this.status == that.status && Objects.equals(this.pedidoItens, that.pedidoItens) && Objects.equals(this.pedidoCombos, that.pedidoCombos);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id, this.cliente, this.status, this.pedidoItens, this.pedidoCombos});
    }

    public static PedidoEntityBuilder builder() {
        return new PedidoEntityBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public ClienteEntity getCliente() {
        return this.cliente;
    }

    public StatusPedido getStatus() {
        return this.status;
    }

    public List<PedidoItemEntity> getPedidoItens() {
        return this.pedidoItens;
    }

    public List<PedidoComboEntity> getPedidoCombos() {
        return this.pedidoCombos;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setCliente(final ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public void setStatus(final StatusPedido status) {
        this.status = status;
    }

    public void setPedidoItens(final List<PedidoItemEntity> pedidoItens) {
        this.pedidoItens = pedidoItens;
    }

    public void setPedidoCombos(final List<PedidoComboEntity> pedidoCombos) {
        this.pedidoCombos = pedidoCombos;
    }

    public String toString() {
        Long var10000 = this.getId();
        return "PedidoEntity(id=" + var10000 + ", cliente=" + this.getCliente() + ", status=" + this.getStatus() + ", pedidoItens=" + this.getPedidoItens() + ", pedidoCombos=" + this.getPedidoCombos() + ")";
    }

    public PedidoEntity(final Long id, final ClienteEntity cliente, final StatusPedido status, final List<PedidoItemEntity> pedidoItens, final List<PedidoComboEntity> pedidoCombos) {
        this.id = id;
        this.cliente = cliente;
        this.status = status;
        this.pedidoItens = pedidoItens;
        this.pedidoCombos = pedidoCombos;
    }

    public PedidoEntity() {
    }

    public static class PedidoEntityBuilder {
        private Long id;
        private ClienteEntity cliente;
        private StatusPedido status;
        private List<PedidoItemEntity> pedidoItens;
        private List<PedidoComboEntity> pedidoCombos;

        PedidoEntityBuilder() {
        }

        public PedidoEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public PedidoEntityBuilder cliente(final ClienteEntity cliente) {
            this.cliente = cliente;
            return this;
        }

        public PedidoEntityBuilder status(final StatusPedido status) {
            this.status = status;
            return this;
        }

        public PedidoEntityBuilder pedidoItens(final List<PedidoItemEntity> pedidoItens) {
            this.pedidoItens = pedidoItens;
            return this;
        }

        public PedidoEntityBuilder pedidoCombos(final List<PedidoComboEntity> pedidoCombos) {
            this.pedidoCombos = pedidoCombos;
            return this;
        }

        public PedidoEntity build() {
            return new PedidoEntity(this.id, this.cliente, this.status, this.pedidoItens, this.pedidoCombos);
        }

        public String toString() {
            return "PedidoEntity.PedidoEntityBuilder(id=" + this.id + ", cliente=" + this.cliente + ", status=" + this.status + ", pedidoItens=" + this.pedidoItens + ", pedidoCombos=" + this.pedidoCombos + ")";
        }
    }
}
