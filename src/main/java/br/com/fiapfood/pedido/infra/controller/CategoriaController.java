package br.com.fiapfood.pedido.infra.controller;

import br.com.fiapfood.pedido.application.interfaces.CategoriaService;
import br.com.fiapfood.pedido.application.payload.request.CategoriaRequest;
import br.com.fiapfood.pedido.application.payload.response.CategoriaResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping({"/categorias"})
    @Operation(
            summary = "Operação responsável por salvar uma categoria na base de dados"
    )
    public ResponseEntity<CategoriaResponse> salvarCategoria(@RequestBody CategoriaRequest categoria) {
        return ResponseEntity.ok(this.categoriaService.salvarCategoria(categoria));
    }

    @GetMapping({"/categorias/{id}"})
    @Operation(
            summary = "Operação responsável por buscar um categorias por id"
    )
    public ResponseEntity<CategoriaResponse> buscarClientePorCpf(@PathVariable Integer id) {
        return ResponseEntity.ok(this.categoriaService.buscarCategoriaPorId(id));
    }

    @GetMapping({"/categorias/"})
    @Operation(
            summary = "Operação responsável por buscar todas categorias da base de dados"
    )
    public ResponseEntity<List<CategoriaResponse>> buscarTodasCategorias() {
        return ResponseEntity.ok(this.categoriaService.buscarTodasCategorias());
    }

    @DeleteMapping({"/categorias/{id}"})
    @Operation(
            summary = "Operação responsável por deletar as categorias por id"
    )
    public ResponseEntity<String> removerCategoriaPorId(@PathVariable Integer id) {
        this.categoriaService.removerCategoriasPorId(id);
        return ResponseEntity.ok("Categoria removida com sucesso");
    }
}
