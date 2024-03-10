package br.com.fiapfood.pedido.application.interfaces;

public interface MensagemProducerService {
    void enviarMensagemPagamentoPendente(String mensagem);
    void enviarMensagemProducaoPendente(String mensagem);
}
