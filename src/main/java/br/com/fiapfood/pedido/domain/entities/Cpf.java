package br.com.fiapfood.pedido.domain.entities;

import java.util.Objects;

public class Cpf {
    Long numero;

    public boolean isValido() {
        return this.validarCPF(String.valueOf(this.numero));
    }

    private boolean validarCPF(String cpf) {
        if (cpf.length() != 11) {
            return false;
        } else if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        } else {
            int digito1 = calcularDigitoVerificador(cpf.substring(0, 9));
            String var10000 = cpf.substring(0, 9);
            int digito2 = calcularDigitoVerificador(var10000 + digito1);
            return digito1 == Character.getNumericValue(cpf.charAt(9)) && digito2 == Character.getNumericValue(cpf.charAt(10));
        }
    }

    private static int calcularDigitoVerificador(String cpfParcial) {
        int soma = 0;
        int peso = cpfParcial.length() + 1;

        int resto;
        for(resto = 0; resto < cpfParcial.length(); ++resto) {
            soma += Character.getNumericValue(cpfParcial.charAt(resto)) * peso;
            --peso;
        }

        resto = soma % 11;
        return resto < 2 ? 0 : 11 - resto;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else {
            Cpf other = (Cpf)obj;
            return Objects.equals(this.numero, other.numero);
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.numero});
    }

    public static CpfBuilder builder() {
        return new CpfBuilder();
    }

    public Long getNumero() {
        return this.numero;
    }

    public void setNumero(final Long numero) {
        this.numero = numero;
    }

    public String toString() {
        return "Cpf(numero=" + this.getNumero() + ")";
    }

    public Cpf(final Long numero) {
        this.numero = numero;
    }

    public Cpf() {
    }

    public static class CpfBuilder {
        private Long numero;

        CpfBuilder() {
        }

        public CpfBuilder numero(final Long numero) {
            this.numero = numero;
            return this;
        }

        public Cpf build() {
            return new Cpf(this.numero);
        }

        public String toString() {
            return "Cpf.CpfBuilder(numero=" + this.numero + ")";
        }
    }
}
