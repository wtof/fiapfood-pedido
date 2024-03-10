package br.com.fiapfood.pedido.infra.mensageria;

import br.com.fiapfood.pedido.application.interfaces.MensagemConsumerService;
import br.com.fiapfood.pedido.application.interfaces.PedidoService;
import br.com.fiapfood.pedido.domain.enuns.StatusPedido;
import br.com.fiapfood.pedido.infra.exceptions.InfraException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MensagemConsumerServiceImpl  implements MensagemConsumerService {
    private static final String  PAGAMENTO_CONFIRMADO = "PAGAMENTO_CONFIRMADO";
    private final PedidoService pedidoService;

    public MensagemConsumerServiceImpl(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @KafkaListener(topics = PAGAMENTO_CONFIRMADO, groupId = "pedido_group_id")
    public void consumirMensagemPagamentoConfirmado(String mensagem) {

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readTree(mensagem);
        } catch (JsonProcessingException e) {
            throw new InfraException("Erro ao converter mensagem consumida para json: " + e.getMessage());
        }
        Long idPedido = jsonNode.get("idPedido").asLong();

        pedidoService.receberConfirmacaoPagamento(idPedido, StatusPedido.PAGO);
    }
}
