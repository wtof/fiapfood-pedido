package br.com.fiapfood.pedido.infra.adapter;

import br.com.fiapfood.pedido.domain.entities.Item;
import br.com.fiapfood.pedido.domain.enuns.StatusItem;
import br.com.fiapfood.pedido.infra.entities.ItemEntity;
import br.com.fiapfood.pedido.infra.exceptions.InfraException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ItemEntityAdapter {
    private ItemEntityAdapter() {
    }

    public static ItemEntityAdapter build() {
        return new ItemEntityAdapter();
    }

    public ItemEntity adapt(Item item) {
        if (item == null) {
            throw new InfraException("Não é possível converter um ItemRequest nulo");
        } else {
            return ItemEntity.builder().id(item.getId()).categoria(CategoriaEntityAdapter.build().adapt(item.getCategoria())).nome(item.getNome()).preco(item.getPreco()).quantidadeEstoque(item.getQuantidadeEstoque()).status(StatusItem.valueOf(item.getStatus().name())).build();
        }
    }

    public List<ItemEntity> adapt(List<Item> itens) {
        if (itens != null && !itens.isEmpty()) {
            List<ItemEntity> itensEntity = new ArrayList();
            Iterator var3 = itens.iterator();

            while(var3.hasNext()) {
                Item request = (Item)var3.next();
                itensEntity.add(this.adapt(request));
            }

            return itensEntity;
        } else {
            return null;
        }
    }
}
