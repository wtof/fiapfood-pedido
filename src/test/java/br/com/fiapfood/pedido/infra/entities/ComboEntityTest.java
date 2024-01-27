package br.com.fiapfood.pedido.infra.entities;

import br.com.fiapfood.pedido.domain.enuns.StatusItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class ComboEntityTest {

    private ComboEntity comboEntity;

    @BeforeEach
    void setUp() {
        comboEntity = new ComboEntity();
    }

    @Test
    void testId() {
        Long id = 1L;
        comboEntity.setId(id);
        assertEquals(id, comboEntity.getId());
    }

    @Test
    void testNome() {
        String nome = "Test";
        comboEntity.setNome(nome);
        assertEquals(nome, comboEntity.getNome());
    }

    @Test
    void testPreco() {
        Float preco = 10.0f;
        comboEntity.setPreco(preco);
        assertEquals(preco, comboEntity.getPreco());
    }

    @Test
    void testStatus() {
        StatusItem status = StatusItem.DISPONIVEL;
        comboEntity.setStatus(status);
        assertEquals(status, comboEntity.getStatus());
    }

    @Test
    void testItens() {
        ItemEntity item = new ItemEntity();
        comboEntity.setItens(Collections.singletonList(item));
        assertEquals(1, comboEntity.getItens().size());
        assertEquals(item, comboEntity.getItens().get(0));
    }

    @Test
    void testEquals() {
        ComboEntity comboEntity1 = new ComboEntity(1L, "Test", 10.0f, StatusItem.DISPONIVEL, Collections.singletonList(new ItemEntity()));
        ComboEntity comboEntity2 = new ComboEntity(1L, "Test", 10.0f, StatusItem.DISPONIVEL, Collections.singletonList(new ItemEntity()));
        assertEquals(comboEntity1, comboEntity2);
    }

    @Test
    void testHashCode() {
        ComboEntity comboEntity1 = new ComboEntity(1L, "Test", 10.0f, StatusItem.DISPONIVEL, Collections.singletonList(new ItemEntity()));
        ComboEntity comboEntity2 = new ComboEntity(1L, "Test", 10.0f, StatusItem.DISPONIVEL, Collections.singletonList(new ItemEntity()));
        assertEquals(comboEntity1.hashCode(), comboEntity2.hashCode());
    }

    @Test
    void testToString() {
        ComboEntity comboEntity = new ComboEntity(1L, "Test", 10.0f, StatusItem.DISPONIVEL, Collections.singletonList(new ItemEntity()));
        String expected = "ComboEntity(id=1, nome=Test, preco=10.0, status=DISPONIVEL, itens=[ItemEntity(id=null, categoria=null, nome=null, preco=null, quantidadeEstoque=null, status=null)])";
        assertEquals(expected, comboEntity.toString());
    }

    @Test
    void testBuilder() {
        ComboEntity comboEntity = ComboEntity.builder()
                .id(1L)
                .nome("Test")
                .preco(10.0f)
                .status(StatusItem.DISPONIVEL)
                .itens(Collections.singletonList(new ItemEntity()))
                .build();

        assertNotNull(comboEntity);
        assertEquals(1L, comboEntity.getId());
        assertEquals("Test", comboEntity.getNome());
        assertEquals(10.0f, comboEntity.getPreco());
        assertEquals(StatusItem.DISPONIVEL, comboEntity.getStatus());
        assertEquals(1, comboEntity.getItens().size());
    }
}