package br.com.fiapfood.pedido.infra.mensageria;

import br.com.fiapfood.pedido.application.interfaces.MensagemProducerService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MensagemProducerServiceImpl implements MensagemProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String  PAGAMENTO_PENDENTE = "PAGAMENTO_PENDENTE";

    private static final String  PRODUCAO_PENDENTE = "PRODUCAO_PENDENTE";

    public MensagemProducerServiceImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviarMensagemPagamentoPendente(String mensagem) {
        kafkaTemplate.send(PAGAMENTO_PENDENTE, mensagem);
    }

    @Override
    public void enviarMensagemProducaoPendente(String mensagem) {
        kafkaTemplate.send(PRODUCAO_PENDENTE, mensagem);
    }
}
