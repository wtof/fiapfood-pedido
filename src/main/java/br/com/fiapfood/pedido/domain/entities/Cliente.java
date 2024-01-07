package br.com.fiapfood.pedido.domain.entities;

import br.com.fiapfood.pedido.domain.exceptions.DominioException;
import java.util.List;
import java.util.Objects;

public class Cliente {
    private Long id;
    private String nome;
    private Cpf cpf;
    private List<Pedido> pedidos;

    public void setNome(String nome) {
        this.nome = nome != null ? nome.toUpperCase() : null;
    }

    public void validarDadosDeNegocioCliente() {
        this.validarDadosObrigatorios();
        this.validarCpf();
    }

    private void validarCpf() {
        if (!this.cpf.isValido()) {
            throw new DominioException("CPF Invalido");
        }
    }

    private void validarDadosObrigatorios() {
        if (this.nome != null && !this.nome.isEmpty()) {
            if (this.cpf == null) {
                throw new DominioException("CPF está nulo");
            }
        } else {
            throw new DominioException("Nome do cliente está nulo ou vazio");
        }
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Cliente cliente = (Cliente)o;
            return Objects.equals(this.id, cliente.id) && Objects.equals(this.nome, cliente.nome) && Objects.equals(this.cpf, cliente.cpf) && Objects.equals(this.pedidos, cliente.pedidos);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id, this.nome, this.cpf, this.pedidos});
    }

    public static ClienteBuilder builder() {
        return new ClienteBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public Cpf getCpf() {
        return this.cpf;
    }

    public List<Pedido> getPedidos() {
        return this.pedidos;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setCpf(final Cpf cpf) {
        this.cpf = cpf;
    }

    public void setPedidos(final List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public String toString() {
        Long var10000 = this.getId();
        return "Cliente(id=" + var10000 + ", nome=" + this.getNome() + ", cpf=" + this.getCpf() + ", pedidos=" + this.getPedidos() + ")";
    }

    public Cliente() {
    }

    public Cliente(final Long id, final String nome, final Cpf cpf, final List<Pedido> pedidos) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.pedidos = pedidos;
    }

    public static class ClienteBuilder {
        private Long id;
        private String nome;
        private Cpf cpf;
        private List<Pedido> pedidos;

        ClienteBuilder() {
        }

        public ClienteBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public ClienteBuilder nome(final String nome) {
            this.nome = nome;
            return this;
        }

        public ClienteBuilder cpf(final Cpf cpf) {
            this.cpf = cpf;
            return this;
        }

        public ClienteBuilder pedidos(final List<Pedido> pedidos) {
            this.pedidos = pedidos;
            return this;
        }

        public Cliente build() {
            return new Cliente(this.id, this.nome, this.cpf, this.pedidos);
        }

        public String toString() {
            return "Cliente.ClienteBuilder(id=" + this.id + ", nome=" + this.nome + ", cpf=" + this.cpf + ", pedidos=" + this.pedidos + ")";
        }
    }
}
