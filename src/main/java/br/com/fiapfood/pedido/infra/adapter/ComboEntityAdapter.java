package br.com.fiapfood.pedido.infra.adapter;

import br.com.fiapfood.pedido.domain.entities.Combo;
import br.com.fiapfood.pedido.domain.entities.Item;
import br.com.fiapfood.pedido.domain.enuns.StatusItem;
import br.com.fiapfood.pedido.infra.entities.ComboEntity;
import java.util.ArrayList;
import java.util.List;

public class ComboEntityAdapter {
    private ComboEntityAdapter() {
    }

    public static ComboEntityAdapter build() {
        return new ComboEntityAdapter();
    }

    public ComboEntity adapt(Combo combo) {
        if (combo == null) {
            return null;
        } else {
            ArrayList<Item> itens = new ArrayList(combo.getItens());
            return ComboEntity.builder().id(combo.getId()).nome(combo.getNome()).preco(combo.getPreco()).status(StatusItem.valueOf(combo.getStatus().name())).itens(ItemEntityAdapter.build().adapt(itens)).build();
        }
    }

    public List<ComboEntity> adapt(List<Combo> combos) {
        if (combos != null && !combos.isEmpty()) {
            List<ComboEntity> entities = new ArrayList();
            combos.forEach((combo) -> {
                entities.add(this.adapt(combo));
            });
            return entities;
        } else {
            return null;
        }
    }
}
