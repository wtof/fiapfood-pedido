package br.com.fiapfood.pedido.domain.usecases;

import br.com.fiapfood.pedido.domain.entities.Combo;
import br.com.fiapfood.pedido.domain.exceptions.DominioException;
import br.com.fiapfood.pedido.domain.interfaces.ComboUseCase;
import br.com.fiapfood.pedido.domain.repository.ComboRepository;
import org.springframework.stereotype.Component;

@Component
public class ComboUseCaseImpl implements ComboUseCase {
    private final ComboRepository comboRepository;

    public ComboUseCaseImpl(ComboRepository comboRepository) {
        this.comboRepository = comboRepository;
    }

    public Combo salvarCombo(Combo combo) {
        combo.validarDados();
        return this.comboRepository.salvarCombo(combo);
    }

    public Combo buscarComboPorId(Long id) {
        return this.comboRepository.buscarComboPorId(id);
    }

    public Combo atualizarCombo(Combo combo) {
        return this.comboRepository.atualizarCombo(combo);
    }

    public void removerCombo(Long id) {
        Combo combo = this.comboRepository.buscarComboPorId(id);
        if (combo == null) {
            throw new DominioException("Não foi possível localizar o Combo com o id fornecido");
        } else {
            this.comboRepository.removerCombo(combo);
        }
    }
}
