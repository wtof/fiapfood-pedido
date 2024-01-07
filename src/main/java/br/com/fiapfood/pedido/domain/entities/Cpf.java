package br.com.fiapfood.pedido.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cpf {

    Long numero;

    public boolean isValido() {
        return validarCPF(String.valueOf(this.numero));
    }

    private boolean validarCPF(String cpf) {

        // Verificar se o CPF possui 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verificar se todos os dígitos são iguais
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Calcular o primeiro dígito verificador
        int digito1 = calcularDigitoVerificador(cpf.substring(0, 9));

        // Calcular o segundo dígito verificador
        int digito2 = calcularDigitoVerificador(cpf.substring(0, 9) + digito1);

        // Verificar se os dígitos verificadores estão corretos
        if (digito1 != Character.getNumericValue(cpf.charAt(9)) || digito2 != Character.getNumericValue(cpf.charAt(10))) {
            return false;
        }

        return true;
    }

    private static int calcularDigitoVerificador(String cpfParcial) {
        int soma = 0;
        int peso = cpfParcial.length() + 1;
        for (int i = 0; i < cpfParcial.length(); i++) {
            soma += Character.getNumericValue(cpfParcial.charAt(i)) * peso;
            peso--;
        }
        int resto = soma % 11;
        if (resto < 2) {
            return 0;
        } else {
            return 11 - resto;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cpf other = (Cpf) obj;
        return Objects.equals(numero, other.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }
}
