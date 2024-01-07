package br.com.fiapfood.pedido.domain.interfaces;

import br.com.fiapfood.pedido.domain.entities.Combo;

public interface ComboUseCase {
    Combo salvarCombo(Combo combo);

    Combo buscarComboPorId(Long id);

    Combo atualizarCombo(Combo combo);

    void removerCombo(Long id);
}
