package br.com.fiapfood.pedido.application.interfaces;

import br.com.fiapfood.pedido.application.payload.request.ComboRequest;
import br.com.fiapfood.pedido.application.payload.response.ComboResponse;

public interface ComboService {
    ComboResponse salvarCombo(ComboRequest comboRequest);

    ComboResponse buscarComboPorId(Long id);

    ComboResponse atualizarCombo(ComboRequest comboRequest);

    void removerCombo(Long id);
}
