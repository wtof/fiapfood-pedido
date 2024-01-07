package br.com.fiapfood.pedido.application.interfaces;

import br.com.fiapfood.pedido.application.payload.request.ClienteRequest;
import br.com.fiapfood.pedido.application.payload.response.ClienteResponse;

public interface ClienteService {
    ClienteResponse salvarCliente(ClienteRequest clienteRequest);

    ClienteResponse buscarClientePorCpf(Long cpf);
}
