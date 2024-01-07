package br.com.fiapfood.pedido.infra.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class CpfEntity {
    @Column(
            name = "cpf"
    )
    Long numero;

    public static CpfEntityBuilder builder() {
        return new CpfEntityBuilder();
    }

    public Long getNumero() {
        return this.numero;
    }

    public void setNumero(final Long numero) {
        this.numero = numero;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CpfEntity)) {
            return false;
        } else {
            CpfEntity other = (CpfEntity)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$numero = this.getNumero();
                Object other$numero = other.getNumero();
                if (this$numero == null) {
                    if (other$numero != null) {
                        return false;
                    }
                } else if (!this$numero.equals(other$numero)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CpfEntity;
    }

    public int hashCode() {
        int result = 1;
        Object $numero = this.getNumero();
        result = result * 59 + ($numero == null ? 43 : $numero.hashCode());
        return result;
    }

    public String toString() {
        return "CpfEntity(numero=" + this.getNumero() + ")";
    }

    public CpfEntity(final Long numero) {
        this.numero = numero;
    }

    public CpfEntity() {
    }

    public static class CpfEntityBuilder {
        private Long numero;

        CpfEntityBuilder() {
        }

        public CpfEntityBuilder numero(final Long numero) {
            this.numero = numero;
            return this;
        }

        public CpfEntity build() {
            return new CpfEntity(this.numero);
        }

        public String toString() {
            return "CpfEntity.CpfEntityBuilder(numero=" + this.numero + ")";
        }
    }
}
