package br.com.fiapfood.pedido.application.payload.request;

import br.com.fiapfood.pedido.application.payload.dto.ItemComboDTO;
import br.com.fiapfood.pedido.application.payload.dto.StatusDTO;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ComboRequestTest {

    @Test
    void testNome() {
        ComboRequest comboRequest = new ComboRequest();
        String expected = "Teste";
        comboRequest.setNome(expected);
        assertEquals(expected, comboRequest.getNome());
    }

    @Test
    void testPreco() {
        ComboRequest comboRequest = new ComboRequest();
        Float expected = 10.0F;
        comboRequest.setPreco(expected);
        assertEquals(expected, comboRequest.getPreco());
    }

    @Test
    void testStatus() {
        ComboRequest comboRequest = new ComboRequest();
        StatusDTO expected =  StatusDTO.DISPONIVEL;
        comboRequest.setStatus(expected);
        assertEquals(expected, comboRequest.getStatus());
    }

    @Test
    void testItens() {
        ComboRequest comboRequest = new ComboRequest();
        ItemComboDTO item = new ItemComboDTO();
        List<ItemComboDTO> expected = Arrays.asList(item);
        comboRequest.setItens(expected);
        assertEquals(expected, comboRequest.getItens());
    }
}