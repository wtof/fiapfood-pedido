package br.com.fiapfood.pedido.application.services;

import br.com.fiapfood.pedido.application.interfaces.ItemService;
import br.com.fiapfood.pedido.application.payload.adapter.ItemAdapter;
import br.com.fiapfood.pedido.application.payload.adapter.ItemResponseAdapter;
import br.com.fiapfood.pedido.application.payload.request.EdicaoItemRequest;
import br.com.fiapfood.pedido.application.payload.request.ItemRequest;
import br.com.fiapfood.pedido.application.payload.response.ItemResponse;
import br.com.fiapfood.pedido.domain.entities.Item;
import br.com.fiapfood.pedido.domain.interfaces.ItemUseCase;
import br.com.fiapfood.pedido.domain.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    private final CategoriaRepository categoriaRepository;
    private final ItemUseCase itemUseCase;

    public ItemServiceImpl(CategoriaRepository categoriaRepository, ItemUseCase itemUseCase) {
        this.categoriaRepository = categoriaRepository;
        this.itemUseCase = itemUseCase;
    }

    public ItemResponse salvarItem(ItemRequest itemRequest) {
        Item item = ItemAdapter.build(this.categoriaRepository).adapt(itemRequest);
        return ItemResponseAdapter.build().adapt(this.itemUseCase.salvarItem(item));
    }

    public ItemResponse atualizarItem(EdicaoItemRequest edicaoItemRequest) {
        Item item = ItemAdapter.build(this.categoriaRepository).adapt(edicaoItemRequest);
        return ItemResponseAdapter.build().adapt(this.itemUseCase.atualizarItem(item, edicaoItemRequest.getId()));
    }

    public void removerItem(Long idItem) {
        this.itemUseCase.removerItem(idItem);
    }

    public List<ItemResponse> buscarItemPorIdCategoria(Integer idCategoria) {
        return ItemResponseAdapter.build().adapt(this.itemUseCase.buscarItensPorIdCategoria(idCategoria));
    }

    public ItemResponse buscarItemPorId(Long idItem) {
        return ItemResponseAdapter.build().adapt(this.itemUseCase.buscarItemPorId(idItem));
    }

    public List<ItemResponse> buscarItemPorNomeCategoria(String nomeCategoria) {
        return ItemResponseAdapter.build().adapt(this.itemUseCase.buscarItemPorNomeCategoria(nomeCategoria));
    }
}
