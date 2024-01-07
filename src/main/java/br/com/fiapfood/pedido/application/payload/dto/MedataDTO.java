package br.com.fiapfood.pedido.application.payload.dto;

public class MedataDTO {
    private Long idPedido;

    public static MedataDTOBuilder builder() {
        return new MedataDTOBuilder();
    }

    public Long getIdPedido() {
        return this.idPedido;
    }

    public void setIdPedido(final Long idPedido) {
        this.idPedido = idPedido;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof MedataDTO)) {
            return false;
        } else {
            MedataDTO other = (MedataDTO)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$idPedido = this.getIdPedido();
                Object other$idPedido = other.getIdPedido();
                if (this$idPedido == null) {
                    if (other$idPedido != null) {
                        return false;
                    }
                } else if (!this$idPedido.equals(other$idPedido)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof MedataDTO;
    }

    public int hashCode() {
        int result = 1;
        Object $idPedido = this.getIdPedido();
        result = result * 59 + ($idPedido == null ? 43 : $idPedido.hashCode());
        return result;
    }

    public String toString() {
        return "MedataDTO(idPedido=" + this.getIdPedido() + ")";
    }

    public MedataDTO(final Long idPedido) {
        this.idPedido = idPedido;
    }

    public MedataDTO() {
    }

    public static class MedataDTOBuilder {
        private Long idPedido;

        MedataDTOBuilder() {
        }

        public MedataDTOBuilder idPedido(final Long idPedido) {
            this.idPedido = idPedido;
            return this;
        }

        public MedataDTO build() {
            return new MedataDTO(this.idPedido);
        }

        public String toString() {
            return "MedataDTO.MedataDTOBuilder(idPedido=" + this.idPedido + ")";
        }
    }
}
