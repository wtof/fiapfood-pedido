package br.com.fiapfood.pedido.infra.adapter;

import br.com.fiapfood.pedido.domain.entities.Combo;
import br.com.fiapfood.pedido.domain.entities.Item;
import br.com.fiapfood.pedido.domain.enuns.StatusItem;
import br.com.fiapfood.pedido.infra.entities.ComboEntity;
import br.com.fiapfood.pedido.infra.entities.ItemEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ComboEntityAdapterTest {

    private ComboEntityAdapter comboEntityAdapter;

    @BeforeEach
    void setUp() {
        comboEntityAdapter = ComboEntityAdapter.build();
    }

    @Test
    void testAdaptSingleEntity() {
        Combo combo = new Combo();
        combo.setId(1L);
        combo.setNome("Test");
        combo.setPreco(100.0f);
        combo.setStatus(StatusItem.DISPONIVEL);

        Item item = new Item();
        item.setId(1L);
        item.setNome("ItemTest");
        item.setPreco(50.0f);
        item.setStatus(StatusItem.DISPONIVEL);
        combo.setItens(Arrays.asList(item));

        ComboEntity comboEntity = comboEntityAdapter.adapt(combo);

        assertEquals(combo.getId(), comboEntity.getId());
        assertEquals(combo.getNome(), comboEntity.getNome());
        assertEquals(combo.getPreco(), comboEntity.getPreco());
        assertEquals(combo.getStatus().name(), comboEntity.getStatus().name());
        assertEquals(combo.getItens().size(), comboEntity.getItens().size());
        assertEquals(combo.getItens().get(0).getId(), ((ItemEntity)comboEntity.getItens().get(0)).getId());
        assertEquals(combo.getItens().get(0).getNome(), ((ItemEntity)comboEntity.getItens().get(0)).getNome());
        assertEquals(combo.getItens().get(0).getPreco(), ((ItemEntity)comboEntity.getItens().get(0)).getPreco());
        assertEquals(combo.getItens().get(0).getStatus().name(), ((ItemEntity)comboEntity.getItens().get(0)).getStatus().name());
    }

    @Test
    void testAdaptSingleEntityNull() {
        ComboEntity comboEntity = comboEntityAdapter.adapt((Combo) null);
        assertNull(comboEntity);
    }

    @Test
    void testAdaptEntityList() {

        Item item = new Item();
        item.setNome("ItemTest");
        item.setPreco(50.0f);
        item.setStatus(StatusItem.DISPONIVEL);


        Combo combo1 = new Combo();
        combo1.setId(1L);
        combo1.setNome("Test1");
        combo1.setPreco(100.0f);
        combo1.setStatus(StatusItem.DISPONIVEL);
        combo1.setItens(List.of(item));

        Combo combo2 = new Combo();
        combo2.setId(2L);
        combo2.setNome("Test2");
        combo2.setPreco(200.0f);
        combo2.setStatus(StatusItem.DISPONIVEL);
        combo2.setItens(List.of(item));

        List<ComboEntity> comboEntities = comboEntityAdapter.adapt(Arrays.asList(combo1, combo2));

        assertEquals(2, comboEntities.size());
        assertEquals(combo1.getId(), comboEntities.get(0).getId());
        assertEquals(combo1.getNome(), comboEntities.get(0).getNome());
        assertEquals(combo1.getPreco(), comboEntities.get(0).getPreco());
        assertEquals(combo1.getStatus().name(), comboEntities.get(0).getStatus().name());
        assertEquals(combo2.getId(), comboEntities.get(1).getId());
        assertEquals(combo2.getNome(), comboEntities.get(1).getNome());
        assertEquals(combo2.getPreco(), comboEntities.get(1).getPreco());
        assertEquals(combo2.getStatus().name(), comboEntities.get(1).getStatus().name());
    }

    @Test
    void testAdaptListNull() {
        List<ComboEntity> comboEntities = comboEntityAdapter.adapt((List<Combo>) null);
        assertNull(comboEntities);
    }

    @Test
    void testAdaptListEmpty() {
        List<ComboEntity> comboEntities = comboEntityAdapter.adapt(Arrays.asList());
        assertNull(comboEntities);
    }
}