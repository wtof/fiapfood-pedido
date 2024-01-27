package br.com.fiapfood.pedido.infra.controller;

import br.com.fiapfood.pedido.application.interfaces.ItemService;
import br.com.fiapfood.pedido.application.payload.request.ItemRequest;
import br.com.fiapfood.pedido.application.payload.request.EdicaoItemRequest;
import br.com.fiapfood.pedido.application.payload.response.ItemResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ItemControllerTest {

    @InjectMocks
    private ItemController itemController;

    @Mock
    private ItemService itemService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSalvarItem() {
        ItemResponse item = new ItemResponse();

        when(itemService.salvarItem(any())).thenReturn(item);

        ResponseEntity<ItemResponse> response = itemController.salvarItem(new ItemRequest());
        assertEquals(item, response.getBody());
    }

    @Test
    void testBuscarItemPorIdCategoria() {
        ItemResponse item1 = new ItemResponse();
        ItemResponse item2 = new ItemResponse();

        when(itemService.buscarItemPorIdCategoria(anyInt())).thenReturn(Arrays.asList(item1, item2));

        ResponseEntity<List<ItemResponse>> response = itemController.buscarItemPorIdCategoria(1);
        assertEquals(2, response.getBody().size());
    }

    @Test
    void testBuscarItemPorNomeCategoria() {
        ItemResponse item1 = new ItemResponse();
        ItemResponse item2 = new ItemResponse();

        when(itemService.buscarItemPorNomeCategoria(anyString())).thenReturn(Arrays.asList(item1, item2));

        ResponseEntity<List<ItemResponse>> response = itemController.buscarItemPorNomeCategoria("categoria");
        assertEquals(2, response.getBody().size());
    }

    @Test
    void testBuscarItemPorId() {
        ItemResponse item = new ItemResponse();
        when(itemService.buscarItemPorId(anyLong())).thenReturn(item);

        ResponseEntity<ItemResponse> response = itemController.buscarItemPorId(1L);
        assertEquals(item, response.getBody());
    }

    @Test
    void testRemoverItemPorId() {
        doNothing().when(itemService).removerItem(anyLong());

        ResponseEntity<String> response = itemController.removerItemPorId(1L);
        assertEquals("Item removido com sucesso", response.getBody());
    }

    @Test
    void testAtualizarItemPorId() {
        ItemResponse item = new ItemResponse();

        when(itemService.atualizarItem(any())).thenReturn(item);

        ResponseEntity<ItemResponse> response = itemController.atualizarItemPorId(new EdicaoItemRequest());
        assertEquals(item, response.getBody());
    }
}