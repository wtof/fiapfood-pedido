package br.com.fiapfood.pedido.application.interfaces;

public interface MensagemConsumerService {
    void consumirMensagemPagamentoConfirmado(String mensagem);
}
