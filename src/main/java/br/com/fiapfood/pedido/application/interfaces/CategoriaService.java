package br.com.fiapfood.pedido.application.interfaces;

import br.com.fiapfood.pedido.application.payload.request.CategoriaRequest;
import br.com.fiapfood.pedido.application.payload.response.CategoriaResponse;
import java.util.List;

public interface CategoriaService {
    CategoriaResponse salvarCategoria(CategoriaRequest categoriaRequest);

    CategoriaResponse buscarCategoriaPorId(Integer id);

    List<CategoriaResponse> buscarTodasCategorias();

    void removerCategoriasPorId(Integer id);
}
