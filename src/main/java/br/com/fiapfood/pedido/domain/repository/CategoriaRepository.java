package br.com.fiapfood.pedido.domain.repository;

import br.com.fiapfood.pedido.domain.entities.Categoria;
import java.util.List;

public interface CategoriaRepository {
    Categoria buscarCategoriaPorId(Integer idCategoria);

    Categoria salvarCategoria(Categoria categoria);

    List<Categoria> buscarTodasCategorias();

    Categoria buscarCategoriaPorNome(String nomeCategoria);

    void removerCategoria(Integer idCategoria);
}
