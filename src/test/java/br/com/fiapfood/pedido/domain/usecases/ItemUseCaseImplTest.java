package br.com.fiapfood.pedido.domain.usecases;

import br.com.fiapfood.pedido.domain.entities.Categoria;
import br.com.fiapfood.pedido.domain.entities.Item;
import br.com.fiapfood.pedido.domain.enuns.StatusItem;
import br.com.fiapfood.pedido.domain.repository.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ItemUseCaseImplTest {

    @Mock
    private ItemRepository itemRepository;

    private ItemUseCaseImpl itemUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        itemUseCase = new ItemUseCaseImpl(itemRepository);
    }

    @Test
    void testSalvarItem() {
        Item item = new Item();
        Categoria categoria = new Categoria();
        item.setCategoria(categoria);
        item.setNome("Test");
        item.setPreco(10.0F);
        item.setStatus(StatusItem.DISPONIVEL);
        when(itemRepository.salvarItem(any())).thenReturn(item);
        Item result = itemUseCase.salvarItem(item);
        assertEquals(item, result);
        verify(itemRepository).salvarItem(item);
    }
    @Test
    void testAtualizarItem() {
        Item item = new Item();
        Categoria categoria = new Categoria();
        item.setCategoria(categoria);
        item.setNome("Test");
        item.setPreco(10.0F);
        item.setStatus(StatusItem.DISPONIVEL);
        when(itemRepository.buscarItemPorId(anyLong())).thenReturn(item);
        when(itemRepository.atualizarItem(any())).thenReturn(item);
        Item result = itemUseCase.atualizarItem(item, 1L);
        assertEquals(item, result);
        verify(itemRepository).atualizarItem(item);
    }

    @Test
    void testRemoverItem() {
        Item item = new Item();
        Categoria categoria = new Categoria();
        item.setCategoria(categoria);
        item.setNome("Test");
        item.setPreco(10.0F);
        when(itemRepository.buscarItemPorId(anyLong())).thenReturn(item);
        itemUseCase.removerItem(1L);
        verify(itemRepository).removerItem(item);
    }

    @Test
    void testBuscarItensPorIdCategoria() {
        List<Item> items = new ArrayList<>();
        items.add(new Item());
        // Set necessary fields in items
        when(itemRepository.buscarItensPorIdCategoria(anyInt())).thenReturn(items);
        List<Item> result = itemUseCase.buscarItensPorIdCategoria(1);
        assertEquals(items, result);
        verify(itemRepository).buscarItensPorIdCategoria(1);
    }

    @Test
    void testBuscarItemPorNomeCategoria() {
        List<Item> items = new ArrayList<>();
        items.add(new Item());
        // Set necessary fields in items
        when(itemRepository.buscarItensPorNomeCategoria(anyString())).thenReturn(items);
        List<Item> result = itemUseCase.buscarItemPorNomeCategoria("Test");
        assertEquals(items, result);
        verify(itemRepository).buscarItensPorNomeCategoria("Test");
    }

    @Test
    void testBuscarItemPorId() {
        Item item = new Item();
        // Set necessary fields in item
        when(itemRepository.buscarItemPorId(anyLong())).thenReturn(item);
        Item result = itemUseCase.buscarItemPorId(1L);
        assertEquals(item, result);
        verify(itemRepository).buscarItemPorId(1L);
    }
}