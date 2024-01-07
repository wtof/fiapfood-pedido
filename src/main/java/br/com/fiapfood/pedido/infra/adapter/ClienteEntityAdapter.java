package br.com.fiapfood.pedido.infra.adapter;

import br.com.fiapfood.pedido.domain.entities.Cliente;
import br.com.fiapfood.pedido.infra.entities.ClienteEntity;
import br.com.fiapfood.pedido.infra.entities.CpfEntity;
import java.util.ArrayList;
import java.util.List;

public class ClienteEntityAdapter {
    private ClienteEntityAdapter() {
    }

    public static ClienteEntityAdapter build() {
        return new ClienteEntityAdapter();
    }

    public ClienteEntity adapt(Cliente cliente) {
        return cliente == null ? null : ClienteEntity.builder().id(cliente.getId()).nome(cliente.getNome()).cpf(CpfEntity.builder().numero(cliente.getCpf().getNumero()).build()).build();
    }

    public List<ClienteEntity> adapt(List<Cliente> clientes) {
        if (clientes != null && !clientes.isEmpty()) {
            List<ClienteEntity> entities = new ArrayList();
            clientes.forEach((cliente) -> {
                entities.add(this.adapt(cliente));
            });
            return entities;
        } else {
            return null;
        }
    }
}
