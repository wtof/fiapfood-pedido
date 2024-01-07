package br.com.fiapfood.pedido.application.services;

import br.com.fiapfood.pedido.application.interfaces.CategoriaService;
import br.com.fiapfood.pedido.application.payload.adapter.CategoriaAdapter;
import br.com.fiapfood.pedido.application.payload.adapter.CategoriaResponseAdapter;
import br.com.fiapfood.pedido.application.payload.request.CategoriaRequest;
import br.com.fiapfood.pedido.application.payload.response.CategoriaResponse;
import br.com.fiapfood.pedido.domain.entities.Categoria;
import br.com.fiapfood.pedido.domain.interfaces.CategoriaUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    private final CategoriaUseCase useCaseCategoria;

    public CategoriaServiceImpl(CategoriaUseCase useCaseCategoria) {
        this.useCaseCategoria = useCaseCategoria;
    }

    public CategoriaResponse salvarCategoria(CategoriaRequest categoriaRequest) {
        Categoria categoria = this.useCaseCategoria.salvarCategoria(CategoriaAdapter.build().adapt(categoriaRequest));
        return CategoriaResponseAdapter.build().adapt(categoria);
    }

    public CategoriaResponse buscarCategoriaPorId(Integer id) {
        Categoria categoria = this.useCaseCategoria.buscarCategoriaPorId(id);
        return CategoriaResponseAdapter.build().adapt(categoria);
    }

    public List<CategoriaResponse> buscarTodasCategorias() {
        List<Categoria> categorias = this.useCaseCategoria.buscarTodasCategorias();
        return CategoriaResponseAdapter.build().adapt(categorias);
    }

    public void removerCategoriasPorId(Integer id) {
        this.useCaseCategoria.removerCategoriasPorId(id);
    }
}
