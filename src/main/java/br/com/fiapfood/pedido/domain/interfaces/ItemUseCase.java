package br.com.fiapfood.pedido.domain.interfaces;

import br.com.fiapfood.pedido.domain.entities.Item;
import java.util.List;

public interface ItemUseCase {
    Item salvarItem(Item item);

    Item atualizarItem(Item item, Long id);

    void removerItem(Long idItem);

    List<Item> buscarItensPorIdCategoria(Integer idCategoria);

    List<Item> buscarItemPorNomeCategoria(String nomeCategoria);

    Item buscarItemPorId(Long idItem);
}
