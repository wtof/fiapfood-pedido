package br.com.fiapfood.pedido.application.payload.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComboDTOTest {

    @Test
    void getId() {
        ComboDTO comboDTO = new ComboDTO();
        comboDTO.setId(1L);
        assertEquals(1L, comboDTO.getId());
    }

    @Test
    void setId() {
        ComboDTO comboDTO = new ComboDTO();
        comboDTO.setId(1L);
        assertEquals(1L, comboDTO.getId());
    }

    @Test
    void getQuantidade() {
        ComboDTO comboDTO = new ComboDTO();
        comboDTO.setQuantidade(5);
        assertEquals(5, comboDTO.getQuantidade());
    }

    @Test
    void setQuantidade() {
        ComboDTO comboDTO = new ComboDTO();
        comboDTO.setQuantidade(5);
        assertEquals(5, comboDTO.getQuantidade());
    }

    @Test
    void testEquals() {
        ComboDTO comboDTO1 = new ComboDTO();
        comboDTO1.setId(1L);
        comboDTO1.setQuantidade(5);

        ComboDTO comboDTO2 = new ComboDTO();
        comboDTO2.setId(1L);
        comboDTO2.setQuantidade(5);

        assertEquals(comboDTO1, comboDTO2);
    }
}