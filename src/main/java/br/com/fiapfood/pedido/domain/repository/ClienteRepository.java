package br.com.fiapfood.pedido.domain.repository;

import br.com.fiapfood.pedido.domain.entities.Cliente;

public interface ClienteRepository {
    Cliente salvarCliente(Cliente cliente);

    Cliente buscarClientePorCpf(Long cpf);

    Cliente buscarClientePorId(Long id);

    void deletarClientePorCpf(Long cpf);
}
