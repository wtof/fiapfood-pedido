package br.com.fiapfood.pedido.domain.entities;

import br.com.fiapfood.pedido.domain.exceptions.DominioException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    void setUp() {
        cliente = new Cliente();
    }

    @Test
    void setNomeWithNonNullValueShouldSetNomeInUpperCase() {
        String nome = "Teste";
        cliente.setNome(nome);

        assertEquals(nome.toUpperCase(), cliente.getNome());
    }

    @Test
    void setNomeWithNullValueShouldSetNomeToNull() {
        cliente.setNome(null);

        assertNull(cliente.getNome());
    }

    @Test
    void validarDadosDeNegocioClienteWithValidDataShouldNotThrowException() {
        cliente.setNome("Teste");
        cliente.setCpf(new Cpf(20779861078L));
        assertDoesNotThrow(() -> cliente.validarDadosDeNegocioCliente());
    }

    @Test
    void validarDadosDeNegocioClienteWithInvalidNomeShouldThrowException() {
        cliente.setNome(null);
        cliente.setCpf(new Cpf(20779861078L));

        assertThrows(DominioException.class, () -> cliente.validarDadosDeNegocioCliente());
    }

    @Test
    void validarDadosDeNegocioClienteWithInvalidCpfShouldThrowException() {
        cliente.setNome("Teste");
        cliente.setCpf(null);

        assertThrows(DominioException.class, () -> cliente.validarDadosDeNegocioCliente());
    }
}