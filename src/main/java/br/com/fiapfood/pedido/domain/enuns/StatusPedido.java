package br.com.fiapfood.pedido.domain.enuns;

public enum StatusPedido {
    INICIADO,
    PENDENTE_PAGAMENTO,
    PAGO,
    RECEBIDO,
    EM_PREPARACAO,
    PRONTO,
    FINALIZADO;

    private StatusPedido() {
    }
}
