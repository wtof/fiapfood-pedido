package br.com.fiapfood.pedido.application.payload.dto;

public class ComboDTO {
    private Long id;
    private Integer quantidade;

    public static ComboDTOBuilder builder() {
        return new ComboDTOBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public Integer getQuantidade() {
        return this.quantidade;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setQuantidade(final Integer quantidade) {
        this.quantidade = quantidade;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ComboDTO)) {
            return false;
        } else {
            ComboDTO other = (ComboDTO)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$id = this.getId();
                Object other$id = other.getId();
                if (this$id == null) {
                    if (other$id != null) {
                        return false;
                    }
                } else if (!this$id.equals(other$id)) {
                    return false;
                }

                Object this$quantidade = this.getQuantidade();
                Object other$quantidade = other.getQuantidade();
                if (this$quantidade == null) {
                    if (other$quantidade != null) {
                        return false;
                    }
                } else if (!this$quantidade.equals(other$quantidade)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ComboDTO;
    }

    public int hashCode() {
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $quantidade = this.getQuantidade();
        result = result * 59 + ($quantidade == null ? 43 : $quantidade.hashCode());
        return result;
    }

    public String toString() {
        Long var10000 = this.getId();
        return "ComboDTO(id=" + var10000 + ", quantidade=" + this.getQuantidade() + ")";
    }

    public ComboDTO(final Long id, final Integer quantidade) {
        this.id = id;
        this.quantidade = quantidade;
    }

    public ComboDTO() {
    }

    public static class ComboDTOBuilder {
        private Long id;
        private Integer quantidade;

        ComboDTOBuilder() {
        }

        public ComboDTOBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public ComboDTOBuilder quantidade(final Integer quantidade) {
            this.quantidade = quantidade;
            return this;
        }

        public ComboDTO build() {
            return new ComboDTO(this.id, this.quantidade);
        }

        public String toString() {
            return "ComboDTO.ComboDTOBuilder(id=" + this.id + ", quantidade=" + this.quantidade + ")";
        }
    }
}
