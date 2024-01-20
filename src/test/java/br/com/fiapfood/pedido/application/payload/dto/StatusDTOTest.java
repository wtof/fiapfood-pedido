package br.com.fiapfood.pedido.application.payload.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatusDTOTest {

    @Test
    void valueOfDisponivel() {
        StatusDTO status = StatusDTO.valueOf("DISPONIVEL");
        assertEquals(StatusDTO.DISPONIVEL, status);
    }

    @Test
    void valueOfIndisponivel() {
        StatusDTO status = StatusDTO.valueOf("INDISPONIVEL");
        assertEquals(StatusDTO.INDISPONIVEL, status);
    }

    @Test
    void valueOfInvalid() {
        assertThrows(IllegalArgumentException.class, () -> StatusDTO.valueOf("INVALID"));
    }
}