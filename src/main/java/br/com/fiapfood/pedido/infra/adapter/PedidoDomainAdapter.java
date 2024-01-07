package br.com.fiapfood.pedido.infra.adapter;

import br.com.fiapfood.pedido.domain.entities.Combo;
import br.com.fiapfood.pedido.domain.entities.Item;
import br.com.fiapfood.pedido.domain.entities.Pedido;
import br.com.fiapfood.pedido.domain.enuns.StatusPedido;
import br.com.fiapfood.pedido.infra.entities.ComboEntity;
import br.com.fiapfood.pedido.infra.entities.ItemEntity;
import br.com.fiapfood.pedido.infra.entities.PedidoComboEntity;
import br.com.fiapfood.pedido.infra.entities.PedidoEntity;
import br.com.fiapfood.pedido.infra.entities.PedidoItemEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PedidoDomainAdapter {
    private PedidoDomainAdapter() {
    }

    public static PedidoDomainAdapter build() {
        return new PedidoDomainAdapter();
    }

    public Pedido adapt(PedidoEntity pedidoEntity) {
        if (pedidoEntity == null) {
            return null;
        } else {
            Pedido pedido = new Pedido();
            pedido.setId(pedidoEntity.getId());
            pedido.setCombos(this.adaptCombos(pedidoEntity.getPedidoCombos()));
            pedido.setItens(this.adaptItens(pedidoEntity.getPedidoItens()));
            pedido.setCliente(ClienteDomainAdapter.build().adapt(pedidoEntity.getCliente()));
            pedido.setStatus(StatusPedido.valueOf(pedidoEntity.getStatus().name()));
            return pedido;
        }
    }

    public List<Pedido> adapt(List<PedidoEntity> pedidosEntity) {
        if (pedidosEntity != null && !pedidosEntity.isEmpty()) {
            List<Pedido> pedidos = new ArrayList();
            Iterator var3 = pedidosEntity.iterator();

            while(var3.hasNext()) {
                PedidoEntity pedidoEntity = (PedidoEntity)var3.next();
                pedidos.add(this.adapt(pedidoEntity));
            }

            return pedidos;
        } else {
            return null;
        }
    }

    private List<Combo> adaptCombos(List<PedidoComboEntity> pedidoComSeusCombos) {
        if (pedidoComSeusCombos != null && !pedidoComSeusCombos.isEmpty()) {
            ArrayList<Combo> combos = new ArrayList();
            Iterator var3 = pedidoComSeusCombos.iterator();

            while(var3.hasNext()) {
                PedidoComboEntity pedidoComboEntity = (PedidoComboEntity)var3.next();
                ComboEntity comboEntity = pedidoComboEntity.getId().getCombo();
                Combo combo = new Combo();
                combo.setQuantidade(pedidoComboEntity.getQuantidade());
                combo.setNome(comboEntity.getNome());
                combo.setId(comboEntity.getId());
                combo.setPreco(comboEntity.getPreco());
                combo.setItens(ItemDomainAdapter.build().adapt(comboEntity.getItens()));
                combo.setStatus(comboEntity.getStatus());
                combos.add(combo);
            }

            return combos;
        } else {
            return null;
        }
    }

    private List<Item> adaptItens(List<PedidoItemEntity> pedidoComSeusItens) {
        if (pedidoComSeusItens != null && !pedidoComSeusItens.isEmpty()) {
            List<Item> itens = new ArrayList();
            Iterator var3 = pedidoComSeusItens.iterator();

            while(var3.hasNext()) {
                PedidoItemEntity pedidoItemEntity = (PedidoItemEntity)var3.next();
                ItemEntity itemEntity = pedidoItemEntity.getId().getItem();
                Item item = new Item();
                item.setQuantidade(pedidoItemEntity.getQuantidade());
                item.setNome(itemEntity.getNome());
                item.setId(itemEntity.getId());
                item.setPreco(itemEntity.getPreco());
                item.setStatus(itemEntity.getStatus());
                itens.add(item);
            }

            return itens;
        } else {
            return null;
        }
    }
}
