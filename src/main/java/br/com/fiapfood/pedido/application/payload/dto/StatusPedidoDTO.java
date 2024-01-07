package br.com.fiapfood.pedido.application.payload.dto;

public enum StatusPedidoDTO {
    INICIADO,
    PENDENTE_PAGAMENTO,
    PAGO,
    RECEBIDO,
    EM_PREPARACAO,
    PRONTO,
    FINALIZADO;

    private StatusPedidoDTO() {
    }
}
