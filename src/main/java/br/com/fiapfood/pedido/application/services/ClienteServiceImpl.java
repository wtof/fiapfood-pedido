package br.com.fiapfood.pedido.application.services;

import br.com.fiapfood.pedido.application.interfaces.ClienteService;
import br.com.fiapfood.pedido.application.payload.adapter.ClienteAdapter;
import br.com.fiapfood.pedido.application.payload.adapter.ClienteResponseAdapter;
import br.com.fiapfood.pedido.application.payload.request.ClienteRequest;
import br.com.fiapfood.pedido.application.payload.response.ClienteResponse;
import br.com.fiapfood.pedido.domain.interfaces.ClienteUseCase;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {
    private final ClienteUseCase clienteUseCase;

    public ClienteServiceImpl(ClienteUseCase clienteUseCase) {
        this.clienteUseCase = clienteUseCase;
    }

    public ClienteResponse salvarCliente(ClienteRequest clienteRequest) {
        return ClienteResponseAdapter.build().adapt(this.clienteUseCase.salvarCliente(ClienteAdapter.build().convert(clienteRequest)));
    }

    public ClienteResponse buscarClientePorCpf(Long cpf) {
        return ClienteResponseAdapter.build().adapt(this.clienteUseCase.buscarClientePorCpf(cpf));
    }

    @Override
    @Transactional
    public void deletarClientePorCpf(Long cpf) {
        this.clienteUseCase.deletarClientePorCpf(cpf);
    }
}
