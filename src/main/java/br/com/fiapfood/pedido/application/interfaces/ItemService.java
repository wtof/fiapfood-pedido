package br.com.fiapfood.pedido.application.interfaces;

import br.com.fiapfood.pedido.application.payload.request.EdicaoItemRequest;
import br.com.fiapfood.pedido.application.payload.request.ItemRequest;
import br.com.fiapfood.pedido.application.payload.response.ItemResponse;
import java.util.List;

public interface ItemService {
    ItemResponse salvarItem(ItemRequest itemRequest);

    ItemResponse atualizarItem(EdicaoItemRequest edicaoItemRequest);

    void removerItem(Long idItem);

    List<ItemResponse> buscarItemPorIdCategoria(Integer idCategoria);

    ItemResponse buscarItemPorId(Long idItem);

    List<ItemResponse> buscarItemPorNomeCategoria(String nomeCategoria);
}
