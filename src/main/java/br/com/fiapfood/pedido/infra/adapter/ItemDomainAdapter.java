package br.com.fiapfood.pedido.infra.adapter;

import br.com.fiapfood.pedido.domain.entities.Categoria;
import br.com.fiapfood.pedido.domain.entities.Item;
import br.com.fiapfood.pedido.domain.enuns.StatusItem;
import br.com.fiapfood.pedido.infra.entities.ItemEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ItemDomainAdapter {
    private ItemDomainAdapter() {
    }

    public static ItemDomainAdapter build() {
        return new ItemDomainAdapter();
    }

    public Item adapt(ItemEntity itemEntity) {
        if (itemEntity == null) {
            return null;
        } else {
            Categoria categoria = CategoriaDomainAdapter.build().adapt(itemEntity.getCategoria());
            return Item.builder().id(itemEntity.getId()).categoria(categoria).nome(itemEntity.getNome()).preco(itemEntity.getPreco()).quantidadeEstoque(itemEntity.getQuantidadeEstoque()).status(StatusItem.valueOf(itemEntity.getStatus().name())).build();
        }
    }

    public List<Item> adapt(List<ItemEntity> itensEntity) {
        if (itensEntity != null && !itensEntity.isEmpty()) {
            List<Item> items = new ArrayList();
            Iterator var3 = itensEntity.iterator();

            while(var3.hasNext()) {
                ItemEntity request = (ItemEntity)var3.next();
                items.add(this.adapt(request));
            }

            return items;
        } else {
            return null;
        }
    }
}
