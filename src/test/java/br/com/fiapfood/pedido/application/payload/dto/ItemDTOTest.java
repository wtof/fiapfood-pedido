package br.com.fiapfood.pedido.application.payload.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemDTOTest {

    @Test
    void getId() {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(1L);
        assertEquals(1L, itemDTO.getId());
    }

    @Test
    void setId() {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(1L);
        assertEquals(1L, itemDTO.getId());
    }

    @Test
    void getQuantidade() {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setQuantidade(5);
        assertEquals(5, itemDTO.getQuantidade());
    }

    @Test
    void setQuantidade() {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setQuantidade(5);
        assertEquals(5, itemDTO.getQuantidade());
    }

    @Test
    void testEquals() {
        ItemDTO itemDTO1 = new ItemDTO();
        itemDTO1.setId(1L);
        itemDTO1.setQuantidade(5);

        ItemDTO itemDTO2 = new ItemDTO();
        itemDTO2.setId(1L);
        itemDTO2.setQuantidade(5);

        assertEquals(itemDTO1, itemDTO2);
    }
}