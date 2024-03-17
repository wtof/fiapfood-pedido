package br.com.fiapfood.pedido.domain.interfaces;

import br.com.fiapfood.pedido.domain.entities.Cliente;

public interface ClienteUseCase {
    Cliente salvarCliente(Cliente cliente);

    Cliente buscarClientePorCpf(Long cpf);

    void deletarClientePorCpf(Long cpf);
}
