package br.com.fiapfood.pedido.domain.repository;

import br.com.fiapfood.pedido.domain.entities.Item;
import java.util.List;

public interface ItemRepository {
    Item salvarItem(Item item);

    Item atualizarItem(Item item);

    void removerItem(Item item);

    List<Item> buscarItensPorIdCategoria(Integer idCategoria);

    List<Item> buscarItensPorNomeCategoria(String nomeCategoria);

    Item buscarItemPorId(Long id);
}
