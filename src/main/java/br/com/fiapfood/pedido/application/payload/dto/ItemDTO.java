package br.com.fiapfood.pedido.application.payload.dto;

public class ItemDTO {
    private Long id;
    private Integer quantidade;

    public static ItemDTOBuilder builder() {
        return new ItemDTOBuilder();
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
        } else if (!(o instanceof ItemDTO)) {
            return false;
        } else {
            ItemDTO other = (ItemDTO)o;
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
        return other instanceof ItemDTO;
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
        return "ItemDTO(id=" + var10000 + ", quantidade=" + this.getQuantidade() + ")";
    }

    public ItemDTO(final Long id, final Integer quantidade) {
        this.id = id;
        this.quantidade = quantidade;
    }

    public ItemDTO() {
    }

    public static class ItemDTOBuilder {
        private Long id;
        private Integer quantidade;

        ItemDTOBuilder() {
        }

        public ItemDTOBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public ItemDTOBuilder quantidade(final Integer quantidade) {
            this.quantidade = quantidade;
            return this;
        }

        public ItemDTO build() {
            return new ItemDTO(this.id, this.quantidade);
        }

        public String toString() {
            return "ItemDTO.ItemDTOBuilder(id=" + this.id + ", quantidade=" + this.quantidade + ")";
        }
    }
}
