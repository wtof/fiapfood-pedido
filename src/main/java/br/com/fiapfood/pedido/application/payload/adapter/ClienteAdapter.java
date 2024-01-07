package br.com.fiapfood.pedido.application.payload.adapter;

import br.com.fiapfood.pedido.application.exceptions.ApplicationException;
import br.com.fiapfood.pedido.application.payload.request.ClienteRequest;
import br.com.fiapfood.pedido.application.payload.request.EdicaoClienteRequest;
import br.com.fiapfood.pedido.domain.entities.Cliente;
import br.com.fiapfood.pedido.domain.entities.Cpf;
import java.util.ArrayList;
import java.util.List;

public class ClienteAdapter {
    private ClienteAdapter() {
    }

    public static ClienteAdapter build() {
        return new ClienteAdapter();
    }

    public Cliente convert(ClienteRequest clienteRequest) {
        if (clienteRequest == null) {
            throw new ApplicationException("Não é possivel coverter um ClienteDTO nulo");
        } else {
            EdicaoClienteRequest edicao = null;
            if (clienteRequest instanceof EdicaoClienteRequest) {
                edicao = (EdicaoClienteRequest)clienteRequest;
            }

            return Cliente.builder().id(edicao != null ? edicao.getIdCliente() : null).nome(clienteRequest.getNome()).cpf(Cpf.builder().numero(clienteRequest.getCpf()).build()).build();
        }
    }

    public List<Cliente> convert(List<ClienteRequest> clientesRequest) {
        if (clientesRequest != null && !clientesRequest.isEmpty()) {
            List<Cliente> clientes = new ArrayList();
            clientesRequest.forEach((dto) -> {
                clientes.add(this.convert(dto));
            });
            return clientes;
        } else {
            throw new ApplicationException("Não é possivel conveter uma lista vazia ou nula de ClienteDTOs");
        }
    }
}
