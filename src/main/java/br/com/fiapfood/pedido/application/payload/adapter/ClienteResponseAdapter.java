package br.com.fiapfood.pedido.application.payload.adapter;

import br.com.fiapfood.pedido.application.exceptions.ApplicationException;
import br.com.fiapfood.pedido.application.payload.response.ClienteResponse;
import br.com.fiapfood.pedido.domain.entities.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteResponseAdapter {
    private ClienteResponseAdapter() {
    }

    public static ClienteResponseAdapter build() {
        return new ClienteResponseAdapter();
    }

    public ClienteResponse adapt(Cliente cliente) {
        if (cliente == null) {
            throw new ApplicationException("Não é possível adaptar um cliente nulo");
        } else {
            return ClienteResponse.builder().id(cliente.getId()).nome(cliente.getNome()).cpf(cliente.getCpf().getNumero()).build();
        }
    }

    public List<ClienteResponse> adapt(List<Cliente> clientes) {
        if (clientes != null && !clientes.isEmpty()) {
            List<ClienteResponse> clienteResponses = new ArrayList();
            clientes.forEach((cliente) -> {
                clienteResponses.add(this.adapt(cliente));
            });
            return clienteResponses;
        } else {
            throw new ApplicationException("Não é possivel conveter uma lista vazia ou nula de clientes");
        }
    }
}
