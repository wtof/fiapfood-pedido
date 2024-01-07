package br.com.fiapfood.pedido.application.payload.dto;

public class ItemComboDTO {
    private Long id;

    public static ItemComboDTOBuilder builder() {
        return new ItemComboDTOBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ItemComboDTO)) {
            return false;
        } else {
            ItemComboDTO other = (ItemComboDTO)o;
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

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ItemComboDTO;
    }

    public int hashCode() {
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        return result;
    }

    public String toString() {
        return "ItemComboDTO(id=" + this.getId() + ")";
    }

    public ItemComboDTO(final Long id) {
        this.id = id;
    }

    public ItemComboDTO() {
    }

    public static class ItemComboDTOBuilder {
        private Long id;

        ItemComboDTOBuilder() {
        }

        public ItemComboDTOBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public ItemComboDTO build() {
            return new ItemComboDTO(this.id);
        }

        public String toString() {
            return "ItemComboDTO.ItemComboDTOBuilder(id=" + this.id + ")";
        }
    }
}
