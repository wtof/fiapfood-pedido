package br.com.fiapfood.pedido.domain.entities;


import br.com.fiapfood.pedido.domain.enuns.StatusPedido;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

    private Long id;

    private Cliente cliente;

    private StatusPedido status;

    private List<Item> itens;

    private List<Combo> combos;

    private Long numero;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id) && Objects.equals(cliente, pedido.cliente) && status == pedido.status && Objects.equals(itens, pedido.itens) && Objects.equals(combos, pedido.combos) && Objects.equals(numero, pedido.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cliente, status, itens, combos, numero);
    }
}