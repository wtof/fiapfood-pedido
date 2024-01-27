package br.com.fiapfood.pedido.application.payload.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedataDTOTest {

    @Test
    void getIdPedido() {
        MedataDTO medataDTO = new MedataDTO();
        medataDTO.setIdPedido(1L);
        assertEquals(1L, medataDTO.getIdPedido());
    }

    @Test
    void setIdPedido() {
        MedataDTO medataDTO = new MedataDTO();
        medataDTO.setIdPedido(1L);
        assertEquals(1L, medataDTO.getIdPedido());
    }

    @Test
    void testEquals() {
        MedataDTO medataDTO1 = new MedataDTO();
        medataDTO1.setIdPedido(1L);

        MedataDTO medataDTO2 = new MedataDTO();
        medataDTO2.setIdPedido(1L);

        assertEquals(medataDTO1, medataDTO2);
    }
}