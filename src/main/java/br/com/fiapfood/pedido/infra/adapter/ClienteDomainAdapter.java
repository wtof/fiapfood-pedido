package br.com.fiapfood.pedido.infra.adapter;

import br.com.fiapfood.pedido.domain.entities.Cliente;
import br.com.fiapfood.pedido.domain.entities.Cpf;
import br.com.fiapfood.pedido.infra.entities.ClienteEntity;
import java.util.ArrayList;
import java.util.List;

public class ClienteDomainAdapter {
    private ClienteDomainAdapter() {
    }

    public static ClienteDomainAdapter build() {
        return new ClienteDomainAdapter();
    }

    public Cliente adapt(ClienteEntity clienteEntity) {
        return clienteEntity == null ? null : Cliente.builder().id(clienteEntity.getId()).nome(clienteEntity.getNome()).cpf(Cpf.builder().numero(clienteEntity.getCpf().getNumero()).build()).build();
    }

    public List<Cliente> adapt(List<ClienteEntity> clienteEntity) {
        if (clienteEntity != null && !clienteEntity.isEmpty()) {
            List<Cliente> clientes = new ArrayList();
            clienteEntity.forEach((dto) -> {
                clientes.add(this.adapt(dto));
            });
            return clientes;
        } else {
            return null;
        }
    }
}
