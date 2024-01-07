package br.com.fiapfood.pedido.domain.usecases;

import br.com.fiapfood.pedido.domain.entities.Item;
import br.com.fiapfood.pedido.domain.exceptions.DominioException;
import br.com.fiapfood.pedido.domain.interfaces.ItemUseCase;
import br.com.fiapfood.pedido.domain.repository.ItemRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemUseCaseImpl implements ItemUseCase {
    private final ItemRepository itemRepository;

    public ItemUseCaseImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item salvarItem(Item item) {
        item.validarDados();
        return this.itemRepository.salvarItem(item);
    }

    public Item atualizarItem(Item item, Long id) {
        Item itemBase = this.itemRepository.buscarItemPorId(id);
        if (itemBase == null) {
            throw new DominioException("Não foi possível atualizar, item nao  encontrado na base de dados");
        } else {
            item.validarDados();
            return this.itemRepository.atualizarItem(item);
        }
    }

    public void removerItem(Long idItem) {
        Item item = this.itemRepository.buscarItemPorId(idItem);
        if (item == null) {
            throw new DominioException("Não foi possível localizar o Item com o id fornecido");
        } else {
            this.itemRepository.removerItem(item);
        }
    }

    public List<Item> buscarItensPorIdCategoria(Integer idCategoria) {
        List<Item> itens = this.itemRepository.buscarItensPorIdCategoria(idCategoria);
        if (itens != null && !itens.isEmpty()) {
            return itens;
        } else {
            throw new DominioException("Item nao encontrado com o id da categoria fornecido");
        }
    }

    public List<Item> buscarItemPorNomeCategoria(String nomeCategoria) {
        List<Item> itens = this.itemRepository.buscarItensPorNomeCategoria(nomeCategoria);
        return (List)(itens != null && !itens.isEmpty() ? itens : new ArrayList(new ArrayList()));
    }

    public Item buscarItemPorId(Long idItem) {
        Item item = this.itemRepository.buscarItemPorId(idItem);
        if (item == null) {
            throw new DominioException("Item nao encontrado na base de dados");
        } else {
            return item;
        }
    }
}
