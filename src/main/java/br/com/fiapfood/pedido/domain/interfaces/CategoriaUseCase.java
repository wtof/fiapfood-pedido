package br.com.fiapfood.pedido.domain.interfaces;

import br.com.fiapfood.pedido.domain.entities.Categoria;
import java.util.List;

public interface CategoriaUseCase {
    Categoria salvarCategoria(Categoria categoria);

    List<Categoria> buscarTodasCategorias();

    Categoria buscarCategoriaPorId(Integer id);

    void removerCategoriasPorId(Integer idCategoria);
}
