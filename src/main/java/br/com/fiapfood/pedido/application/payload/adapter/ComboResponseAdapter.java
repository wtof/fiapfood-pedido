package br.com.fiapfood.pedido.application.payload.adapter;

import br.com.fiapfood.pedido.application.exceptions.ApplicationException;
import br.com.fiapfood.pedido.application.payload.dto.StatusDTO;
import br.com.fiapfood.pedido.application.payload.response.ComboResponse;
import br.com.fiapfood.pedido.domain.entities.Combo;
import br.com.fiapfood.pedido.domain.enuns.StatusItem;
import java.util.ArrayList;
import java.util.List;

public class ComboResponseAdapter {
    private ComboResponseAdapter() {
    }

    public static ComboResponseAdapter build() {
        return new ComboResponseAdapter();
    }

    public ComboResponse adapt(Combo combo) {
        if (combo == null) {
            throw new ApplicationException("Não é possível adaptar um combo nulo");
        } else {
            return ComboResponse.builder().id(combo.getId()).preco(combo.getPreco()).nome(combo.getNome()).status(this.convertStatus(combo.getStatus())).itens(ItemResponseAdapter.build().adapt(combo.getItens())).build();
        }
    }

    public List<ComboResponse> adapt(List<Combo> combos) {
        if (combos != null && !combos.isEmpty()) {
            List<ComboResponse> combosResponse = new ArrayList();
            combos.forEach((combo) -> {
                combosResponse.add(this.adapt(combo));
            });
            return combosResponse;
        } else {
            throw new ApplicationException("Não é possível adaptar uma lista vazia ou nula de combos");
        }
    }

    private StatusDTO convertStatus(StatusItem statusItem) {
        return statusItem == null ? null : StatusDTO.valueOf(statusItem.name());
    }
}
