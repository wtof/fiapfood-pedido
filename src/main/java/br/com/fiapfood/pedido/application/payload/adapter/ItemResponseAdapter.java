package br.com.fiapfood.pedido.application.payload.adapter;

import br.com.fiapfood.pedido.application.exceptions.ApplicationException;
import br.com.fiapfood.pedido.application.payload.dto.StatusDTO;
import br.com.fiapfood.pedido.application.payload.response.ItemResponse;
import br.com.fiapfood.pedido.domain.entities.Item;
import br.com.fiapfood.pedido.domain.enuns.StatusItem;

import java.util.ArrayList;
import java.util.List;

public class ItemResponseAdapter {

    private ItemResponseAdapter() {
        super();
    }

    public static ItemResponseAdapter build() {
        return new ItemResponseAdapter();
    }

    public ItemResponse adapt(Item item) {
        if (item == null) {
            throw new ApplicationException("Não é possível converter um Item nulo");
        }

        return ItemResponse.builder()
                .id(item.getId())
                .categoria(item.getCategoria())
                .nome(item.getNome())
                .preco(item.getPreco())
                .quantidadeEstoque(item.getQuantidadeEstoque())
                .status(convertStatus(item.getStatus()))
                .build();
    }

    public List<ItemResponse> adapt(List<Item> itens) {

        List<ItemResponse> itemResponses = new ArrayList<>();

        for (Item item : itens) {
            itemResponses.add(adapt(item));
        }

        return itemResponses;
    }

    private StatusDTO convertStatus(StatusItem statusItem) {
        if (statusItem == null) {
            return null;
        }

        return StatusDTO.valueOf(statusItem.name());
    }
}
