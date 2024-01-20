package br.com.fiapfood.pedido.infra.entities;

import br.com.fiapfood.pedido.domain.enuns.StatusItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemEntityTest {

    private ItemEntity itemEntity;

    @BeforeEach
    void setUp() {
        itemEntity = new ItemEntity();
    }

    @Test
    void testId() {
        Long id = 1L;
        itemEntity.setId(id);
        assertEquals(id, itemEntity.getId());
    }

    @Test
    void testCategoria() {
        CategoriaEntity categoria = new CategoriaEntity();
        itemEntity.setCategoria(categoria);
        assertEquals(categoria, itemEntity.getCategoria());
    }

    @Test
    void testNome() {
        String nome = "Item";
        itemEntity.setNome(nome);
        assertEquals(nome, itemEntity.getNome());
    }

    @Test
    void testPreco() {
        Float preco = 10.0f;
        itemEntity.setPreco(preco);
        assertEquals(preco, itemEntity.getPreco());
    }

    @Test
    void testQuantidadeEstoque() {
        Integer quantidadeEstoque = 100;
        itemEntity.setQuantidadeEstoque(quantidadeEstoque);
        assertEquals(quantidadeEstoque, itemEntity.getQuantidadeEstoque());
    }

    @Test
    void testStatus() {
        StatusItem status = StatusItem.DISPONIVEL;
        itemEntity.setStatus(status);
        assertEquals(status, itemEntity.getStatus());
    }

    @Test
    void testEquals() {
        ItemEntity itemEntity1 = new ItemEntity(1L, new CategoriaEntity(), "Item", 10.0f, 100, StatusItem.DISPONIVEL);
        ItemEntity itemEntity2 = new ItemEntity(1L, new CategoriaEntity(), "Item", 10.0f, 100, StatusItem.DISPONIVEL);
        assertEquals(itemEntity1, itemEntity2);
    }

    @Test
    void testHashCode() {
        ItemEntity itemEntity1 = new ItemEntity(1L, new CategoriaEntity(), "Item", 10.0f, 100, StatusItem.DISPONIVEL);
        ItemEntity itemEntity2 = new ItemEntity(1L, new CategoriaEntity(), "Item", 10.0f, 100, StatusItem.DISPONIVEL);
        assertEquals(itemEntity1.hashCode(), itemEntity2.hashCode());
    }

    @Test
    void testToString() {
        ItemEntity itemEntity = new ItemEntity(1L, new CategoriaEntity(), "Item", 10.0f, 100, StatusItem.DISPONIVEL);
        String expected = "ItemEntity(id=1, categoria=CategoriaEntity(id=null, nome=null, descricao=null), nome=Item, preco=10.0, quantidadeEstoque=100, status=DISPONIVEL)";
        assertEquals(expected, itemEntity.toString());
    }

    @Test
    void testBuilder() {
        ItemEntity itemEntity = ItemEntity.builder()
                .id(1L)
                .categoria(new CategoriaEntity())
                .nome("Item")
                .preco(10.0f)
                .quantidadeEstoque(100)
                .status(StatusItem.DISPONIVEL)
                .build();

        assertNotNull(itemEntity);
        assertEquals(1L, itemEntity.getId());
        assertNotNull(itemEntity.getCategoria());
        assertEquals("Item", itemEntity.getNome());
        assertEquals(10.0f, itemEntity.getPreco());
        assertEquals(100, itemEntity.getQuantidadeEstoque());
        assertEquals(StatusItem.DISPONIVEL, itemEntity.getStatus());
    }
}