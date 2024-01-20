package br.com.fiapfood.pedido.infra.adapter;

import br.com.fiapfood.pedido.domain.entities.Combo;
import br.com.fiapfood.pedido.domain.enuns.StatusItem;
import br.com.fiapfood.pedido.infra.entities.ComboEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ComboDomainAdapterTest {

    private ComboDomainAdapter comboDomainAdapter;

    @BeforeEach
    void setUp() {
        comboDomainAdapter = ComboDomainAdapter.build();
    }

    @Test
    void testAdaptSingleEntity() {
        ComboEntity comboEntity = new ComboEntity();
        comboEntity.setId(1L);
        comboEntity.setNome("Test");
        comboEntity.setPreco(100.0f);
        comboEntity.setStatus(StatusItem.DISPONIVEL);

        Combo combo = comboDomainAdapter.adapt(comboEntity);

        assertEquals(comboEntity.getId(), combo.getId());
        assertEquals(comboEntity.getNome(), combo.getNome());
        assertEquals(comboEntity.getPreco(), combo.getPreco());
        assertEquals(comboEntity.getStatus().name(), combo.getStatus().name());
    }

    @Test
    void testAdaptSingleEntityNull() {
        Combo combo = comboDomainAdapter.adapt((ComboEntity) null);
        assertNull(combo);
    }

    @Test
    void testAdaptEntityList() {
        ComboEntity comboEntity1 = new ComboEntity();
        comboEntity1.setId(1L);
        comboEntity1.setNome("Test1");
        comboEntity1.setPreco(100.0f);
        comboEntity1.setStatus(StatusItem.DISPONIVEL);

        ComboEntity comboEntity2 = new ComboEntity();
        comboEntity2.setId(2L);
        comboEntity2.setNome("Test2");
        comboEntity2.setPreco(200.0f);
        comboEntity2.setStatus(StatusItem.DISPONIVEL);

        List<Combo> combos = comboDomainAdapter.adapt(Arrays.asList(comboEntity1, comboEntity2));

        assertEquals(2, combos.size());
        assertEquals(comboEntity1.getId(), combos.get(0).getId());
        assertEquals(comboEntity1.getNome(), combos.get(0).getNome());
        assertEquals(comboEntity1.getPreco(), combos.get(0).getPreco());
        assertEquals(comboEntity1.getStatus().name(), combos.get(0).getStatus().name());
        assertEquals(comboEntity2.getId(), combos.get(1).getId());
        assertEquals(comboEntity2.getNome(), combos.get(1).getNome());
        assertEquals(comboEntity2.getPreco(), combos.get(1).getPreco());
        assertEquals(comboEntity2.getStatus().name(), combos.get(1).getStatus().name());
    }

    @Test
    void testAdaptListNull() {
        List<Combo> combos = comboDomainAdapter.adapt((List<ComboEntity>) null);
        assertNull(combos);
    }

    @Test
    void testAdaptListEmpty() {
        List<Combo> combos = comboDomainAdapter.adapt(Arrays.asList());
        assertNull(combos);
    }
}