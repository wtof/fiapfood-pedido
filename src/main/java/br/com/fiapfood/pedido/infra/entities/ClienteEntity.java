package br.com.fiapfood.pedido.infra.entities;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(
        name = "Cliente"
)
public class ClienteEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String nome;
    @Embedded
    private CpfEntity cpf;
    @OneToMany(
            mappedBy = "cliente",
            fetch = FetchType.LAZY
    )
    private List<PedidoEntity> pedidos;

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            ClienteEntity entity = (ClienteEntity)o;
            return Objects.equals(this.id, entity.id) && Objects.equals(this.nome, entity.nome) && Objects.equals(this.cpf, entity.cpf) && Objects.equals(this.pedidos, entity.pedidos);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id, this.nome, this.cpf, this.pedidos});
    }

    public static ClienteEntityBuilder builder() {
        return new ClienteEntityBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public CpfEntity getCpf() {
        return this.cpf;
    }

    public List<PedidoEntity> getPedidos() {
        return this.pedidos;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public void setCpf(final CpfEntity cpf) {
        this.cpf = cpf;
    }

    public void setPedidos(final List<PedidoEntity> pedidos) {
        this.pedidos = pedidos;
    }

    public String toString() {
        Long var10000 = this.getId();
        return "ClienteEntity(id=" + var10000 + ", nome=" + this.getNome() + ", cpf=" + this.getCpf() + ", pedidos=" + this.getPedidos() + ")";
    }

    public ClienteEntity() {
    }

    public ClienteEntity(final Long id, final String nome, final CpfEntity cpf, final List<PedidoEntity> pedidos) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.pedidos = pedidos;
    }

    public static class ClienteEntityBuilder {
        private Long id;
        private String nome;
        private CpfEntity cpf;
        private List<PedidoEntity> pedidos;

        ClienteEntityBuilder() {
        }

        public ClienteEntityBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public ClienteEntityBuilder nome(final String nome) {
            this.nome = nome;
            return this;
        }

        public ClienteEntityBuilder cpf(final CpfEntity cpf) {
            this.cpf = cpf;
            return this;
        }

        public ClienteEntityBuilder pedidos(final List<PedidoEntity> pedidos) {
            this.pedidos = pedidos;
            return this;
        }

        public ClienteEntity build() {
            return new ClienteEntity(this.id, this.nome, this.cpf, this.pedidos);
        }

        public String toString() {
            return "ClienteEntity.ClienteEntityBuilder(id=" + this.id + ", nome=" + this.nome + ", cpf=" + this.cpf + ", pedidos=" + this.pedidos + ")";
        }
    }
}
