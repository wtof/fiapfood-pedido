package br.com.fiapfood.pedido.application.payload.dto;

public class DataMercadoPagoDTO {
    private String id;
    private Long pedido;

    public static DataMercadoPagoDTOBuilder builder() {
        return new DataMercadoPagoDTOBuilder();
    }

    public String getId() {
        return this.id;
    }

    public Long getPedido() {
        return this.pedido;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setPedido(final Long pedido) {
        this.pedido = pedido;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof DataMercadoPagoDTO)) {
            return false;
        } else {
            DataMercadoPagoDTO other = (DataMercadoPagoDTO)o;
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

                Object this$id = this.getId();
                Object other$id = other.getId();
                if (this$id == null) {
                    if (other$id != null) {
                        return false;
                    }
                } else if (!this$id.equals(other$id)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof DataMercadoPagoDTO;
    }

    public int hashCode() {
        int result = 1;
        Object $pedido = this.getPedido();
        result = result * 59 + ($pedido == null ? 43 : $pedido.hashCode());
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        return result;
    }

    public String toString() {
        String var10000 = this.getId();
        return "DataMercadoPagoDTO(id=" + var10000 + ", pedido=" + this.getPedido() + ")";
    }

    public DataMercadoPagoDTO(final String id, final Long pedido) {
        this.id = id;
        this.pedido = pedido;
    }

    public DataMercadoPagoDTO() {
    }

    public static class DataMercadoPagoDTOBuilder {
        private String id;
        private Long pedido;

        DataMercadoPagoDTOBuilder() {
        }

        public DataMercadoPagoDTOBuilder id(final String id) {
            this.id = id;
            return this;
        }

        public DataMercadoPagoDTOBuilder pedido(final Long pedido) {
            this.pedido = pedido;
            return this;
        }

        public DataMercadoPagoDTO build() {
            return new DataMercadoPagoDTO(this.id, this.pedido);
        }

        public String toString() {
            return "DataMercadoPagoDTO.DataMercadoPagoDTOBuilder(id=" + this.id + ", pedido=" + this.pedido + ")";
        }
    }
}
