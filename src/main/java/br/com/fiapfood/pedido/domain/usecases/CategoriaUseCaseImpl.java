package br.com.fiapfood.pedido.domain.usecases;

import br.com.fiapfood.pedido.domain.entities.Categoria;
import br.com.fiapfood.pedido.domain.exceptions.DominioException;
import br.com.fiapfood.pedido.domain.interfaces.CategoriaUseCase;
import br.com.fiapfood.pedido.domain.repository.CategoriaRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoriaUseCaseImpl implements CategoriaUseCase {
    private final CategoriaRepository categoriaRepository;

    public CategoriaUseCaseImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria salvarCategoria(Categoria categoria) {
        this.validaSeExisteCategoriaComNomeInformado(categoria.getNome());
        categoria.validarDados();
        return this.categoriaRepository.salvarCategoria(categoria);
    }

    public List<Categoria> buscarTodasCategorias() {
        List<Categoria> categorias = this.categoriaRepository.buscarTodasCategorias();
        return (List)(categorias != null && !categorias.isEmpty() ? categorias : new ArrayList());
    }

    public Categoria buscarCategoriaPorId(Integer id) {
        Categoria categoria = this.categoriaRepository.buscarCategoriaPorId(id);
        if (categoria == null) {
            throw new DominioException("Categoria não encontrada");
        } else {
            return categoria;
        }
    }

    public void removerCategoriasPorId(Integer idCategoria) {
        Categoria categoria = this.categoriaRepository.buscarCategoriaPorId(idCategoria);
        if (null == categoria) {
            throw new DominioException("Não foi possível encontrar a categoria a ser deletada");
        } else {
            this.categoriaRepository.removerCategoria(idCategoria);
        }
    }

    private void validaSeExisteCategoriaComNomeInformado(String nomeCategoria) {
        Categoria resultado = this.categoriaRepository.buscarCategoriaPorNome(nomeCategoria);
        if (resultado != null) {
            throw new DominioException("Já existe uma categoria cadastrada com o nome informado");
        }
    }
}
