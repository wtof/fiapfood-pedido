package br.com.fiapfood.pedido.application.payload.adapter;

import br.com.fiapfood.pedido.application.payload.dto.ItemComboDTO;
import br.com.fiapfood.pedido.application.payload.request.ComboRequest;
import br.com.fiapfood.pedido.domain.entities.Combo;
import br.com.fiapfood.pedido.domain.entities.Item;
import br.com.fiapfood.pedido.domain.enuns.StatusItem;
import br.com.fiapfood.pedido.domain.repository.ItemRepository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ComboAdapter {
    private final ItemRepository itemRepository;

    private ComboAdapter(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public static ComboAdapter build(ItemRepository itemRepository) {
        return new ComboAdapter(itemRepository);
    }

    public Combo adapt(ComboRequest comboRequest) {
        if (comboRequest == null) {
            return null;
        } else {
            ArrayList<Item> itens = new ArrayList();
            Iterator var3 = comboRequest.getItens().iterator();

            while(var3.hasNext()) {
                ItemComboDTO itemDTO = (ItemComboDTO)var3.next();
                Item item = this.itemRepository.buscarItemPorId(itemDTO.getId());
                itens.add(item);
            }

            return Combo.builder().nome(comboRequest.getNome()).preco(comboRequest.getPreco()).status(StatusItem.valueOf(comboRequest.getStatus().name())).itens(itens).build();
        }
    }

    public List<Combo> convert(List<ComboRequest> combosRequest) {
        if (combosRequest != null && !combosRequest.isEmpty()) {
            List<Combo> combos = new ArrayList();
            combosRequest.forEach((dto) -> {
                combos.add(this.adapt(dto));
            });
            return combos;
        } else {
            return null;
        }
    }
}
