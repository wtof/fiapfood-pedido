package br.com.fiapfood.pedido.domain.entities;

import br.com.fiapfood.pedido.domain.exceptions.DominioException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    private Long id;

    private String nome;

    private Cpf cpf;

    private List<Pedido> pedidos;

    public void setNome(String nome) {
        this.nome = nome != null ? nome.toUpperCase() : null;
    }

    public void validarDadosDeNegocioCliente() {
        validarDadosObrigatorios();
        validarCpf();
    }

    private void validarCpf() {
        if (!this.cpf.isValido()) {
            throw new DominioException("CPF Invalido");
        }
    }

    private void validarDadosObrigatorios() {
        if (this.nome == null || this.nome.isEmpty()) {
            throw new DominioException("Nome do cliente está nulo ou vazio");
        }

        if (this.cpf == null) {
            throw new DominioException("CPF está nulo");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id) && Objects.equals(nome, cliente.nome) && Objects.equals(cpf, cliente.cpf) && Objects.equals(pedidos, cliente.pedidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpf, pedidos);
    }
}
