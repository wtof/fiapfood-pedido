package br.com.fiapfood.pedido.application.payload.adapter;

import br.com.fiapfood.pedido.application.exceptions.ApplicationException;
import br.com.fiapfood.pedido.application.payload.dto.StatusDTO;
import br.com.fiapfood.pedido.application.payload.response.ItemResponse;
import br.com.fiapfood.pedido.domain.entities.Item;
import br.com.fiapfood.pedido.domain.enuns.StatusItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ItemResponseAdapter {
    private ItemResponseAdapter() {
    }

    public static ItemResponseAdapter build() {
        return new ItemResponseAdapter();
    }

    public ItemResponse adapt(Item item) {
        if (item == null) {
            throw new ApplicationException("Não é possível converter um Item nulo");
        } else {
            return ItemResponse.builder().id(item.getId()).categoria(item.getCategoria()).nome(item.getNome()).preco(item.getPreco()).quantidadeEstoque(item.getQuantidadeEstoque()).status(this.convertStatus(item.getStatus())).build();
        }
    }

    public List<ItemResponse> adapt(List<Item> itens) {
        List<ItemResponse> itemResponses = new ArrayList();
        Iterator var3 = itens.iterator();

        while(var3.hasNext()) {
            Item item = (Item)var3.next();
            itemResponses.add(this.adapt(item));
        }

        return itemResponses;
    }

    private StatusDTO convertStatus(StatusItem statusItem) {
        return statusItem == null ? null : StatusDTO.valueOf(statusItem.name());
    }
}
