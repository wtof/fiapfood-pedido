package br.com.fiapfood.pedido.infra.adapter;

import br.com.fiapfood.pedido.domain.entities.Combo;
import br.com.fiapfood.pedido.domain.entities.Item;
import br.com.fiapfood.pedido.domain.entities.Pedido;
import br.com.fiapfood.pedido.domain.enuns.StatusPedido;
import br.com.fiapfood.pedido.infra.entities.ComboEntity;
import br.com.fiapfood.pedido.infra.entities.ItemEntity;
import br.com.fiapfood.pedido.infra.entities.PedidoComboEntity;
import br.com.fiapfood.pedido.infra.entities.PedidoComboId;
import br.com.fiapfood.pedido.infra.entities.PedidoEntity;
import br.com.fiapfood.pedido.infra.entities.PedidoItemEntity;
import br.com.fiapfood.pedido.infra.entities.PedidoItemId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PedidoEntityAdapter {
    private PedidoEntityAdapter() {
    }

    public static PedidoEntityAdapter build() {
        return new PedidoEntityAdapter();
    }

    public PedidoEntity adapt(Pedido pedido) {
        if (pedido == null) {
            return null;
        } else {
            PedidoEntity pedidoEntity = new PedidoEntity();
            pedidoEntity.setCliente(ClienteEntityAdapter.build().adapt(pedido.getCliente()));
            List<PedidoItemEntity> pedidoComItens = this.adaptPedidoItemEntity(pedido, pedidoEntity);
            pedidoEntity.setPedidoItens(pedidoComItens);
            List<PedidoComboEntity> pedidoComCombos = this.adaptPedidoComboEntity(pedido, pedidoEntity);
            pedidoEntity.setPedidoCombos(pedidoComCombos);
            pedidoEntity.setId(pedido.getId());
            pedidoEntity.setStatus(StatusPedido.valueOf(pedido.getStatus().name()));
            return pedidoEntity;
        }
    }

    public List<PedidoEntity> adapt(List<Pedido> pedidos) {
        if (pedidos != null && !pedidos.isEmpty()) {
            List<PedidoEntity> pedidoEntities = new ArrayList();
            Iterator var3 = pedidos.iterator();

            while(var3.hasNext()) {
                Pedido pedido = (Pedido)var3.next();
                pedidoEntities.add(this.adapt(pedido));
            }

            return pedidoEntities;
        } else {
            return null;
        }
    }

    private List<PedidoComboEntity> adaptPedidoComboEntity(Pedido pedido, PedidoEntity pedidoEntity) {
        List<PedidoComboEntity> pedidoComSeusCombos = new ArrayList();
        List<Combo> combos = pedido.getCombos();
        if (combos != null && !combos.isEmpty()) {
            Iterator var5 = combos.iterator();

            while(var5.hasNext()) {
                Combo combo = (Combo)var5.next();
                PedidoComboEntity pedidoItemEntity = new PedidoComboEntity();
                PedidoComboId pedidoComboId = new PedidoComboId();
                ComboEntity comboEntity = ComboEntityAdapter.build().adapt(combo);
                pedidoComboId.setCombo(comboEntity);
                pedidoComboId.setPedido(pedidoEntity);
                pedidoItemEntity.setId(pedidoComboId);
                pedidoItemEntity.setQuantidade(combo.getQuantidade());
                pedidoComSeusCombos.add(pedidoItemEntity);
            }

            return pedidoComSeusCombos;
        } else {
            return null;
        }
    }

    private List<PedidoItemEntity> adaptPedidoItemEntity(Pedido pedido, PedidoEntity pedidoEntity) {
        List<PedidoItemEntity> pedidoComSeusItens = new ArrayList();
        List<Item> itens = pedido.getItens();
        if (itens != null && !itens.isEmpty()) {
            Iterator var5 = itens.iterator();

            while(var5.hasNext()) {
                Item item = (Item)var5.next();
                PedidoItemEntity pedidoItemEntity = new PedidoItemEntity();
                PedidoItemId pedidoItemId = new PedidoItemId();
                ItemEntity itemEntity = ItemEntityAdapter.build().adapt(item);
                pedidoItemId.setItem(itemEntity);
                pedidoItemId.setPedido(pedidoEntity);
                pedidoItemEntity.setId(pedidoItemId);
                pedidoItemEntity.setQuantidade(item.getQuantidade());
                pedidoComSeusItens.add(pedidoItemEntity);
            }

            return pedidoComSeusItens;
        } else {
            return null;
        }
    }
}
