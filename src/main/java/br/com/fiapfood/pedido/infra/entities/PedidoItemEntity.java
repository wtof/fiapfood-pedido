package br.com.fiapfood.pedido.infra.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(
        name = "PedidoItem"
)
public class PedidoItemEntity {
    @EmbeddedId
    private PedidoItemId id;
    private Integer quantidade;

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            PedidoItemEntity that = (PedidoItemEntity)o;
            return Objects.equals(this.id, that.id) && Objects.equals(this.quantidade, that.quantidade);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id, this.quantidade});
    }

    public static PedidoItemEntityBuilder builder() {
        return new PedidoItemEntityBuilder();
    }

    public PedidoItemId getId() {
        return this.id;
    }

    public Integer getQuantidade() {
        return this.quantidade;
    }

    public void setId(final PedidoItemId id) {
        this.id = id;
    }

    public void setQuantidade(final Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String toString() {
        PedidoItemId var10000 = this.getId();
        return "PedidoItemEntity(id=" + var10000 + ", quantidade=" + this.getQuantidade() + ")";
    }

    public PedidoItemEntity(final PedidoItemId id, final Integer quantidade) {
        this.id = id;
        this.quantidade = quantidade;
    }

    public PedidoItemEntity() {
    }

    public static class PedidoItemEntityBuilder {
        private PedidoItemId id;
        private Integer quantidade;

        PedidoItemEntityBuilder() {
        }

        public PedidoItemEntityBuilder id(final PedidoItemId id) {
            this.id = id;
            return this;
        }

        public PedidoItemEntityBuilder quantidade(final Integer quantidade) {
            this.quantidade = quantidade;
            return this;
        }

        public PedidoItemEntity build() {
            return new PedidoItemEntity(this.id, this.quantidade);
        }

        public String toString() {
            return "PedidoItemEntity.PedidoItemEntityBuilder(id=" + this.id + ", quantidade=" + this.quantidade + ")";
        }
    }
}
