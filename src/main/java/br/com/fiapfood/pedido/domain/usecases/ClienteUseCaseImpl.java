package br.com.fiapfood.pedido.domain.usecases;

import br.com.fiapfood.pedido.domain.entities.Cliente;
import br.com.fiapfood.pedido.domain.exceptions.DominioException;
import br.com.fiapfood.pedido.domain.interfaces.ClienteUseCase;
import br.com.fiapfood.pedido.domain.repository.ClienteRepository;
import org.springframework.stereotype.Component;

@Component
public class ClienteUseCaseImpl implements ClienteUseCase {
    private final ClienteRepository clienteRepository;

    public ClienteUseCaseImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente salvarCliente(Cliente cliente) {
        this.validarDadosCliente(cliente);
        return this.clienteRepository.salvarCliente(cliente);
    }

    public Cliente buscarClientePorCpf(Long cpf) {
        Cliente cliente = this.clienteRepository.buscarClientePorCpf(cpf);
        if (cliente == null) {
            throw new DominioException("Cliente nao encontrado");
        } else {
            return cliente;
        }
    }

    @Override
    public void deletarClientePorCpf(Long cpf) {
        try {
            clienteRepository.deletarClientePorCpf(cpf);
        } catch (Exception exception) {
            throw new DominioException("Erro ao tentar deletar cliente", exception);
        }
    }

    private void validarDadosCliente(Cliente cliente) {
        cliente.validarDadosDeNegocioCliente();
        this.validaSeExisteClienteComCpfInformado(cliente);
    }

    private void validaSeExisteClienteComCpfInformado(Cliente cliente) {
        Cliente resultado = this.clienteRepository.buscarClientePorCpf(cliente.getCpf().getNumero());
        if (resultado != null) {
            throw new DominioException("Já existe um cliente na base de dados com o cpf informado");
        }
    }
}
