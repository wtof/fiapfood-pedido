package br.com.fiapfood.pedido.application.payload.response;

public class ClienteResponse {
    private Long id;
    private String nome;
    private Long cpf;

    ClienteResponse(final Long id, final String nome, final Long cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public static ClienteResponseBuilder builder() {
        return new ClienteResponseBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public Long getCpf() {
        return this.cpf;
    }

    public void setId(final Long id) {
        this.id = id;
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
        } else if (!(o instanceof ClienteResponse)) {
            return false;
        } else {
            ClienteResponse other = (ClienteResponse)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$id = this.getId();
                    Object other$id = other.getId();
                    if (this$id == null) {
                        if (other$id == null) {
                            break label47;
                        }
                    } else if (this$id.equals(other$id)) {
                        break label47;
                    }

                    return false;
                }

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
        return other instanceof ClienteResponse;
    }

    public int hashCode() {
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $cpf = this.getCpf();
        result = result * 59 + ($cpf == null ? 43 : $cpf.hashCode());
        Object $nome = this.getNome();
        result = result * 59 + ($nome == null ? 43 : $nome.hashCode());
        return result;
    }

    public String toString() {
        Long var10000 = this.getId();
        return "ClienteResponse(id=" + var10000 + ", nome=" + this.getNome() + ", cpf=" + this.getCpf() + ")";
    }

    public static class ClienteResponseBuilder {
        private Long id;
        private String nome;
        private Long cpf;

        ClienteResponseBuilder() {
        }

        public ClienteResponseBuilder id(final Long id) {
            this.id = id;
            return this;
        }

        public ClienteResponseBuilder nome(final String nome) {
            this.nome = nome;
            return this;
        }

        public ClienteResponseBuilder cpf(final Long cpf) {
            this.cpf = cpf;
            return this;
        }

        public ClienteResponse build() {
            return new ClienteResponse(this.id, this.nome, this.cpf);
        }

        public String toString() {
            return "ClienteResponse.ClienteResponseBuilder(id=" + this.id + ", nome=" + this.nome + ", cpf=" + this.cpf + ")";
        }
    }
}
