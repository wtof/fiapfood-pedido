package br.com.fiapfood.pedido.application.payload.adapter;

import br.com.fiapfood.pedido.application.exceptions.ApplicationException;
import br.com.fiapfood.pedido.application.payload.dto.ComboDTO;
import br.com.fiapfood.pedido.application.payload.dto.ItemDTO;
import br.com.fiapfood.pedido.application.payload.request.EdicaoPedidoRequest;
import br.com.fiapfood.pedido.application.payload.request.PedidoRequest;
import br.com.fiapfood.pedido.domain.entities.Cliente;
import br.com.fiapfood.pedido.domain.entities.Combo;
import br.com.fiapfood.pedido.domain.entities.Item;
import br.com.fiapfood.pedido.domain.entities.Pedido;
import br.com.fiapfood.pedido.domain.enuns.StatusPedido;
import br.com.fiapfood.pedido.domain.repository.ClienteRepository;
import br.com.fiapfood.pedido.domain.repository.ComboRepository;
import br.com.fiapfood.pedido.domain.repository.ItemRepository;

import java.util.ArrayList;
import java.util.List;

public class PedidoAdapter {
    private final ItemRepository itemRepository;
    private final ComboRepository comboRepository;
    private final ClienteRepository clienteRepository;

    public PedidoAdapter(ItemRepository itemRepository, ComboRepository comboRepository, ClienteRepository clienteRepository) {
        this.comboRepository = comboRepository;
        this.clienteRepository = clienteRepository;
        this.itemRepository = itemRepository;
    }

    public static PedidoAdapter build(ItemRepository itemRepository, ComboRepository comboRepository, ClienteRepository clienteRepository) {
        return new PedidoAdapter(itemRepository, comboRepository, clienteRepository);
    }

    public Pedido adapt(PedidoRequest pedidoRequest) {
        if (pedidoRequest == null) {
            throw new ApplicationException("Não é possível converter um PedidoRequest nulo");
        }

        Pedido pedido = new Pedido();

        List<ItemDTO> itensDTO = pedidoRequest.getItens();
        List<ComboDTO> combosDTO = pedidoRequest.getCombos();
        ArrayList<Item> setPedidoItens = new ArrayList<>();
        ArrayList<Combo> setPedidoCombos = new ArrayList<>();

        adaptCliente(pedido,pedidoRequest.getClienteId());
        adaptItens(pedido, setPedidoItens, itensDTO);
        adaptCombos(pedido, setPedidoCombos, combosDTO);

        EdicaoPedidoRequest edicaoPedidoRequest = null;
        if (pedidoRequest instanceof EdicaoPedidoRequest) {
            edicaoPedidoRequest = (EdicaoPedidoRequest) pedidoRequest;
            pedido.setId(edicaoPedidoRequest.getId());
            pedido.setStatus(StatusPedido.valueOf(edicaoPedidoRequest.getStatus().name()));
        }

        return pedido;
    }

    private void adaptCliente(Pedido pedido, Long clienteId) {
        if(clienteId != null) {
            Cliente cliente = clienteRepository.buscarClientePorId(clienteId);
            if(cliente == null) {
                throw new ApplicationException("Não foi possível encontrar o cliente informado na base de dados. cliente: " + clienteId);
            }
            pedido.setCliente(cliente);
        }
    }

    public List<Pedido> adapt(List<PedidoRequest> pedidosRequest) {
        if (pedidosRequest == null || pedidosRequest.isEmpty()) {
            throw new ApplicationException("Não é possível converter uma lista vazia ou nula de PedidoRequests");
        }

        List<Pedido> pedidos = new ArrayList<>();

        for (PedidoRequest request : pedidosRequest) {
            pedidos.add(adapt(request));
        }
        return pedidos;
    }

    private void adaptCombos(Pedido pedido, ArrayList<Combo> combos, List<ComboDTO> combosDTO) {
        if (combosDTO == null || combosDTO.isEmpty()) {
            return;
        }
        for (ComboDTO comboDTO : combosDTO) {
            Combo combo = comboRepository.buscarComboPorId(comboDTO.getId());
            if(combo == null) {
                throw new ApplicationException("Um dos combos informados não foi encontrado na base de dados, Id: " + comboDTO.getId());
            }
            combo.setQuantidade(comboDTO.getQuantidade());
            combos.add(combo);
        }
        pedido.setCombos(combos);
    }

    private void adaptItens(Pedido pedido, ArrayList<Item> itens, List<ItemDTO> itensDTO) {
        if (itensDTO == null || itensDTO.isEmpty()) {
            return;
        }
        for (ItemDTO itemDTO : itensDTO) {
            Item  item = itemRepository.buscarItemPorId(itemDTO.getId());
            if(item == null) {
                throw new ApplicationException("Um dos itens informados não foi encontrado na base de dados, Id: " + itemDTO.getId());
            }
            item.setQuantidade(itemDTO.getQuantidade());
            itens.add(item);
        }
        pedido.setItens(itens);
    }
}
