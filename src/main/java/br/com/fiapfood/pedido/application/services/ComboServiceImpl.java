package br.com.fiapfood.pedido.application.services;

import br.com.fiapfood.pedido.application.interfaces.ComboService;
import br.com.fiapfood.pedido.application.payload.adapter.ComboAdapter;
import br.com.fiapfood.pedido.application.payload.adapter.ComboResponseAdapter;
import br.com.fiapfood.pedido.application.payload.request.ComboRequest;
import br.com.fiapfood.pedido.application.payload.response.ComboResponse;
import br.com.fiapfood.pedido.domain.entities.Combo;
import br.com.fiapfood.pedido.domain.interfaces.ComboUseCase;
import br.com.fiapfood.pedido.domain.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ComboServiceImpl implements ComboService {
    private final ComboUseCase comboUseCase;
    private final ItemRepository itemRepository;

    public ComboServiceImpl(ComboUseCase comboUseCase, ItemRepository itemRepository) {
        this.comboUseCase = comboUseCase;
        this.itemRepository = itemRepository;
    }

    public ComboResponse salvarCombo(ComboRequest comboRequest) {
        Combo combo = this.comboUseCase.salvarCombo(ComboAdapter.build(this.itemRepository).adapt(comboRequest));
        return ComboResponseAdapter.build().adapt(combo);
    }

    public ComboResponse buscarComboPorId(Long id) {
        Combo combo = this.comboUseCase.buscarComboPorId(id);
        return ComboResponseAdapter.build().adapt(combo);
    }

    public ComboResponse atualizarCombo(ComboRequest comboRequest) {
        Combo combo = this.comboUseCase.atualizarCombo(ComboAdapter.build(this.itemRepository).adapt(comboRequest));
        return ComboResponseAdapter.build().adapt(combo);
    }

    public void removerCombo(Long id) {
        this.comboUseCase.removerCombo(id);
    }
}
