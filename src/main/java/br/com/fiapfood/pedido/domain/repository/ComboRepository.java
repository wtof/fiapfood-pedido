package br.com.fiapfood.pedido.domain.repository;

import br.com.fiapfood.pedido.domain.entities.Combo;

public interface ComboRepository {
    Combo salvarCombo(Combo combo);

    Combo atualizarCombo(Combo combo);

    void removerCombo(Combo combo);

    Combo buscarComboPorId(Long id);
}
