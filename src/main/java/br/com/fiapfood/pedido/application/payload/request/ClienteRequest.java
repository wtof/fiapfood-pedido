package br.com.fiapfood.pedido.application.payload.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ClienteRequest {
    private String nome;
    private Long cpf;

    ClienteRequest(final String nome, final Long cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public static ClienteRequestBuilder builder() {
        return new ClienteRequestBuilder();
    }

    public String getNome() {
        return this.nome;
    }

    public Long getCpf() {
        return this.cpf;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public void setCpf(final Long cpf) {
        this.cpf = cpf;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ClienteRequest)) {
            return false;
        } else {
            ClienteRequest other = (ClienteRequest)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$cpf = this.getCpf();
                Object other$cpf = other.getCpf();
                if (this$cpf == null) {
                    if (other$cpf != null) {
                        return false;
                    }
                } else if (!this$cpf.equals(other$cpf)) {
                    return false;
                }

                Object this$nome = this.getNome();
                Object other$nome = other.getNome();
                if (this$nome == null) {
                    if (other$nome != null) {
                        return false;
                    }
                } else if (!this$nome.equals(other$nome)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ClienteRequest;
    }

    public int hashCode() {
        int result = 1;
        Object $cpf = this.getCpf();
        result = result * 59 + ($cpf == null ? 43 : $cpf.hashCode());
        Object $nome = this.getNome();
        result = result * 59 + ($nome == null ? 43 : $nome.hashCode());
        return result;
    }

    public String toString() {
        String var10000 = this.getNome();
        return "ClienteRequest(nome=" + var10000 + ", cpf=" + this.getCpf() + ")";
    }

    public static class ClienteRequestBuilder {
        private String nome;
        private Long cpf;

        ClienteRequestBuilder() {
        }

        public ClienteRequestBuilder nome(final String nome) {
            this.nome = nome;
            return this;
        }

        public ClienteRequestBuilder cpf(final Long cpf) {
            this.cpf = cpf;
            return this;
        }

        public ClienteRequest build() {
            return new ClienteRequest(this.nome, this.cpf);
        }

        public String toString() {
            return "ClienteRequest.ClienteRequestBuilder(nome=" + this.nome + ", cpf=" + this.cpf + ")";
        }
    }
}
