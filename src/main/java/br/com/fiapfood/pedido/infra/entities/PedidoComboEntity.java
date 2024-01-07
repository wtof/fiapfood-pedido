package br.com.fiapfood.pedido.infra.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(
        name = "PedidoCombo"
)
public class PedidoComboEntity {
    @EmbeddedId
    private PedidoComboId id;
    private Integer quantidade;

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            PedidoComboEntity that = (PedidoComboEntity)o;
            return Objects.equals(this.id, that.id) && Objects.equals(this.quantidade, that.quantidade);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id, this.quantidade});
    }

    public static PedidoComboEntityBuilder builder() {
        return new PedidoComboEntityBuilder();
    }

    public PedidoComboId getId() {
        return this.id;
    }

    public Integer getQuantidade() {
        return this.quantidade;
    }

    public void setId(final PedidoComboId id) {
        this.id = id;
    }

    public void setQuantidade(final Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String toString() {
        PedidoComboId var10000 = this.getId();
        return "PedidoComboEntity(id=" + var10000 + ", quantidade=" + this.getQuantidade() + ")";
    }

    public PedidoComboEntity(final PedidoComboId id, final Integer quantidade) {
        this.id = id;
        this.quantidade = quantidade;
    }

    public PedidoComboEntity() {
    }

    public static class PedidoComboEntityBuilder {
        private PedidoComboId id;
        private Integer quantidade;

        PedidoComboEntityBuilder() {
        }

        public PedidoComboEntityBuilder id(final PedidoComboId id) {
            this.id = id;
            return this;
        }

        public PedidoComboEntityBuilder quantidade(final Integer quantidade) {
            this.quantidade = quantidade;
            return this;
        }

        public PedidoComboEntity build() {
            return new PedidoComboEntity(this.id, this.quantidade);
        }

        public String toString() {
            return "PedidoComboEntity.PedidoComboEntityBuilder(id=" + this.id + ", quantidade=" + this.quantidade + ")";
        }
    }
}
