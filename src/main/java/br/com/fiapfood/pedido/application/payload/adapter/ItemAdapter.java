package br.com.fiapfood.pedido.application.payload.adapter;

import br.com.fiapfood.pedido.application.exceptions.ApplicationException;
import br.com.fiapfood.pedido.application.payload.request.EdicaoItemRequest;
import br.com.fiapfood.pedido.application.payload.request.ItemRequest;
import br.com.fiapfood.pedido.domain.entities.Categoria;
import br.com.fiapfood.pedido.domain.entities.Item;
import br.com.fiapfood.pedido.domain.enuns.StatusItem;
import br.com.fiapfood.pedido.domain.repository.CategoriaRepository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ItemAdapter {
    private final CategoriaRepository categoriaRepository;

    private ItemAdapter(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public static ItemAdapter build(CategoriaRepository categoriaRepository) {
        return new ItemAdapter(categoriaRepository);
    }

    public Item adapt(ItemRequest itemRequest) {
        if (itemRequest == null) {
            throw new ApplicationException("Não é possível converter um ItemRequest nulo");
        } else if (itemRequest.getCategoriaId() == null) {
            throw new ApplicationException("Id da categoria está nulo");
        } else {
            Categoria categoria = this.categoriaRepository.buscarCategoriaPorId(itemRequest.getCategoriaId());
            if (categoria == null) {
                throw new ApplicationException("Nao foi encontrada a categoria com o id informado");
            } else {
                EdicaoItemRequest edicaoItemRequest = null;
                if (itemRequest instanceof EdicaoItemRequest) {
                    edicaoItemRequest = (EdicaoItemRequest)itemRequest;
                }

                return Item.builder().id(edicaoItemRequest != null ? edicaoItemRequest.getId() : null).categoria(categoria).nome(itemRequest.getNome()).preco(itemRequest.getPreco()).quantidadeEstoque(itemRequest.getQuantidadeEstoque()).status(StatusItem.valueOf(itemRequest.getStatus().name())).build();
            }
        }
    }

    public List<Item> adapt(List<ItemRequest> itemsRequest) {
        if (itemsRequest != null && !itemsRequest.isEmpty()) {
            List<Item> items = new ArrayList();
            Iterator var3 = itemsRequest.iterator();

            while(var3.hasNext()) {
                ItemRequest request = (ItemRequest)var3.next();
                items.add(this.adapt(request));
            }

            return items;
        } else {
            throw new ApplicationException("Não é possível converter uma lista vazia ou nula de ItemRequests");
        }
    }
}
