package br.com.fiapfood.pedido.infra.adapter;

import br.com.fiapfood.pedido.domain.entities.Item;
import br.com.fiapfood.pedido.domain.enuns.StatusItem;
import br.com.fiapfood.pedido.infra.entities.ItemEntity;
import br.com.fiapfood.pedido.infra.exceptions.InfraException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemEntityAdapterTest {

    private ItemEntityAdapter itemEntityAdapter;

    @BeforeEach
    void setUp() {
        itemEntityAdapter = ItemEntityAdapter.build();
    }

    @Test
    void testAdaptSingleEntity() {
        Item item = new Item();
        item.setId(1L);
        item.setNome("Test");
        item.setPreco(100.0f);
        item.setQuantidadeEstoque(10);
        item.setStatus(StatusItem.DISPONIVEL);

        ItemEntity itemEntity = itemEntityAdapter.adapt(item);

        assertEquals(item.getId(), itemEntity.getId());
        assertEquals(item.getNome(), itemEntity.getNome());
        assertEquals(item.getPreco(), itemEntity.getPreco());
        assertEquals(item.getQuantidadeEstoque(), itemEntity.getQuantidadeEstoque());
        assertEquals(item.getStatus().name(), itemEntity.getStatus().name());
    }

    @Test
    void testAdaptSingleEntityNull() {
        assertThrows(InfraException.class, () -> itemEntityAdapter.adapt((Item) null));
    }

    @Test
    void testAdaptEntityList() {
        Item item1 = new Item();
        item1.setId(1L);
        item1.setNome("Test1");
        item1.setPreco(100.0f);
        item1.setQuantidadeEstoque(10);
        item1.setStatus(StatusItem.DISPONIVEL);

        Item item2 = new Item();
        item2.setId(2L);
        item2.setNome("Test2");
        item2.setPreco(200.0f);
        item2.setQuantidadeEstoque(20);
        item2.setStatus(StatusItem.DISPONIVEL);

        List<ItemEntity> itemEntities = itemEntityAdapter.adapt(Arrays.asList(item1, item2));

        assertEquals(2, itemEntities.size());
        assertEquals(item1.getId(), itemEntities.get(0).getId());
        assertEquals(item1.getNome(), itemEntities.get(0).getNome());
        assertEquals(item1.getPreco(), itemEntities.get(0).getPreco());
        assertEquals(item1.getQuantidadeEstoque(), itemEntities.get(0).getQuantidadeEstoque());
        assertEquals(item1.getStatus().name(), itemEntities.get(0).getStatus().name());
        assertEquals(item2.getId(), itemEntities.get(1).getId());
        assertEquals(item2.getNome(), itemEntities.get(1).getNome());
        assertEquals(item2.getPreco(), itemEntities.get(1).getPreco());
        assertEquals(item2.getQuantidadeEstoque(), itemEntities.get(1).getQuantidadeEstoque());
        assertEquals(item2.getStatus().name(), itemEntities.get(1).getStatus().name());
    }

    @Test
    void testAdaptListNull() {
        List<ItemEntity> itemEntities = itemEntityAdapter.adapt((List<Item>) null);
        assertNull(itemEntities);
    }

    @Test
    void testAdaptListEmpty() {
        List<ItemEntity> itemEntities = itemEntityAdapter.adapt(Arrays.asList());
        assertNull(itemEntities);
    }
}