package br.com.fiapfood.pedido.domain.usecases;

import br.com.fiapfood.pedido.domain.entities.Item;
import br.com.fiapfood.pedido.domain.entities.Pedido;
import br.com.fiapfood.pedido.domain.repository.PedidoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PedidoUseCaseImplTest {

    @Mock
    private PedidoRepository pedidoRepository;

    private PedidoUseCaseImpl pedidoUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        pedidoUseCase = new PedidoUseCaseImpl(pedidoRepository);
    }

    @Test
    void testSalvarPedido() {
        Pedido pedido = new Pedido();
        ArrayList<Item> items = new ArrayList<>();

        Item item = new Item();
        item.setNome("Item 1");
        items.add(item);
        pedido.setItens(items);

        when(pedidoRepository.salvarPedido(any())).thenReturn(pedido);
        Pedido result = pedidoUseCase.salvarPedido(pedido);
        assertEquals(pedido, result);
        verify(pedidoRepository).salvarPedido(pedido);
    }
}