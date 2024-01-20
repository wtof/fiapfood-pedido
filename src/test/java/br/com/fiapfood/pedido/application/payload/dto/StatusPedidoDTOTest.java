package br.com.fiapfood.pedido.application.payload.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatusPedidoDTOTest {

    @Test
    void valueOfIniciado() {
        StatusPedidoDTO status = StatusPedidoDTO.valueOf("INICIADO");
        assertEquals(StatusPedidoDTO.INICIADO, status);
    }

    @Test
    void valueOfPendentePagamento() {
        StatusPedidoDTO status = StatusPedidoDTO.valueOf("PENDENTE_PAGAMENTO");
        assertEquals(StatusPedidoDTO.PENDENTE_PAGAMENTO, status);
    }

    @Test
    void valueOfPago() {
        StatusPedidoDTO status = StatusPedidoDTO.valueOf("PAGO");
        assertEquals(StatusPedidoDTO.PAGO, status);
    }

    @Test
    void valueOfRecebido() {
        StatusPedidoDTO status = StatusPedidoDTO.valueOf("RECEBIDO");
        assertEquals(StatusPedidoDTO.RECEBIDO, status);
    }

    @Test
    void valueOfEmPreparacao() {
        StatusPedidoDTO status = StatusPedidoDTO.valueOf("EM_PREPARACAO");
        assertEquals(StatusPedidoDTO.EM_PREPARACAO, status);
    }

    @Test
    void valueOfPronto() {
        StatusPedidoDTO status = StatusPedidoDTO.valueOf("PRONTO");
        assertEquals(StatusPedidoDTO.PRONTO, status);
    }

    @Test
    void valueOfFinalizado() {
        StatusPedidoDTO status = StatusPedidoDTO.valueOf("FINALIZADO");
        assertEquals(StatusPedidoDTO.FINALIZADO, status);
    }

    @Test
    void valueOfInvalid() {
        assertThrows(IllegalArgumentException.class, () -> StatusPedidoDTO.valueOf("INVALID"));
    }
}