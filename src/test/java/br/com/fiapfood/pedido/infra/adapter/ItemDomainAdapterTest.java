package br.com.fiapfood.pedido.infra.adapter;

import br.com.fiapfood.pedido.domain.entities.Item;
import br.com.fiapfood.pedido.domain.enuns.StatusItem;
import br.com.fiapfood.pedido.infra.entities.ItemEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ItemDomainAdapterTest {

    private ItemDomainAdapter itemDomainAdapter;

    @BeforeEach
    void setUp() {
        itemDomainAdapter = ItemDomainAdapter.build();
    }

    @Test
    void testAdaptSingleEntity() {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId(1L);
        itemEntity.setNome("Test");
        itemEntity.setPreco(100.0f);
        itemEntity.setQuantidadeEstoque(10);
        itemEntity.setStatus(StatusItem.DISPONIVEL);

        Item item = itemDomainAdapter.adapt(itemEntity);

        assertEquals(itemEntity.getId(), item.getId());
        assertEquals(itemEntity.getNome(), item.getNome());
        assertEquals(itemEntity.getPreco(), item.getPreco());
        assertEquals(itemEntity.getQuantidadeEstoque(), item.getQuantidadeEstoque());
        assertEquals(itemEntity.getStatus().name(), item.getStatus().name());
    }

    @Test
    void testAdaptSingleEntityNull() {
        Item item = itemDomainAdapter.adapt((ItemEntity) null);
        assertNull(item);
    }

    @Test
    void testAdaptEntityList() {
        ItemEntity itemEntity1 = new ItemEntity();
        itemEntity1.setId(1L);
        itemEntity1.setNome("Test1");
        itemEntity1.setPreco(100.0f);
        itemEntity1.setQuantidadeEstoque(10);
        itemEntity1.setStatus(StatusItem.DISPONIVEL);

        ItemEntity itemEntity2 = new ItemEntity();
        itemEntity2.setId(2L);
        itemEntity2.setNome("Test2");
        itemEntity2.setPreco(200.0f);
        itemEntity2.setQuantidadeEstoque(20);
        itemEntity2.setStatus(StatusItem.DISPONIVEL);

        List<Item> items = itemDomainAdapter.adapt(Arrays.asList(itemEntity1, itemEntity2));

        assertEquals(2, items.size());
        assertEquals(itemEntity1.getId(), items.get(0).getId());
        assertEquals(itemEntity1.getNome(), items.get(0).getNome());
        assertEquals(itemEntity1.getPreco(), items.get(0).getPreco());
        assertEquals(itemEntity1.getQuantidadeEstoque(), items.get(0).getQuantidadeEstoque());
        assertEquals(itemEntity1.getStatus().name(), items.get(0).getStatus().name());
        assertEquals(itemEntity2.getId(), items.get(1).getId());
        assertEquals(itemEntity2.getNome(), items.get(1).getNome());
        assertEquals(itemEntity2.getPreco(), items.get(1).getPreco());
        assertEquals(itemEntity2.getQuantidadeEstoque(), items.get(1).getQuantidadeEstoque());
        assertEquals(itemEntity2.getStatus().name(), items.get(1).getStatus().name());
    }

    @Test
    void testAdaptListNull() {
        List<Item> items = itemDomainAdapter.adapt((List<ItemEntity>) null);
        assertNull(items);
    }

    @Test
    void testAdaptListEmpty() {
        List<Item> items = itemDomainAdapter.adapt(Arrays.asList());
        assertNull(items);
    }
}