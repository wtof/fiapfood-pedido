package br.com.fiapfood.pedido.infra.adapter;

import br.com.fiapfood.pedido.domain.entities.Combo;
import br.com.fiapfood.pedido.domain.enuns.StatusItem;
import br.com.fiapfood.pedido.infra.entities.ComboEntity;
import java.util.ArrayList;
import java.util.List;

public class ComboDomainAdapter {
    private ComboDomainAdapter() {
    }

    public static ComboDomainAdapter build() {
        return new ComboDomainAdapter();
    }

    public Combo adapt(ComboEntity comboEntity) {
        return comboEntity == null ? null : Combo.builder().id(comboEntity.getId()).nome(comboEntity.getNome()).preco(comboEntity.getPreco()).status(StatusItem.valueOf(comboEntity.getStatus().name())).itens(ItemDomainAdapter.build().adapt(comboEntity.getItens())).build();
    }

    public List<Combo> adapt(List<ComboEntity> combosRequest) {
        if (combosRequest != null && !combosRequest.isEmpty()) {
            List<Combo> combos = new ArrayList();
            combosRequest.forEach((dto) -> {
                combos.add(this.adapt(dto));
            });
            return combos;
        } else {
            return null;
        }
    }
}
