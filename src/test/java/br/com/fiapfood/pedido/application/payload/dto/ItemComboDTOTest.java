package br.com.fiapfood.pedido.application.payload.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemComboDTOTest {

    @Test
    void getId() {
        ItemComboDTO itemComboDTO = new ItemComboDTO();
        itemComboDTO.setId(1L);
        assertEquals(1L, itemComboDTO.getId());
    }

    @Test
    void setId() {
        ItemComboDTO itemComboDTO = new ItemComboDTO();
        itemComboDTO.setId(1L);
        assertEquals(1L, itemComboDTO.getId());
    }

    @Test
    void testEquals() {
        ItemComboDTO itemComboDTO1 = new ItemComboDTO();
        itemComboDTO1.setId(1L);

        ItemComboDTO itemComboDTO2 = new ItemComboDTO();
        itemComboDTO2.setId(1L);

        assertEquals(itemComboDTO1, itemComboDTO2);
    }
}