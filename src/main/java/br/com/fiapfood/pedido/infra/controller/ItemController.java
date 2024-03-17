package br.com.fiapfood.pedido.infra.controller;

import br.com.fiapfood.pedido.application.interfaces.ItemService;
import br.com.fiapfood.pedido.application.payload.request.EdicaoItemRequest;
import br.com.fiapfood.pedido.application.payload.request.ItemRequest;
import br.com.fiapfood.pedido.application.payload.response.ItemResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping({"/itens"})
    @Operation(
            summary = "Operação responsável por salvar um item na base de dados"
    )
    public ResponseEntity<ItemResponse> salvarItem(@RequestBody ItemRequest item) {
        return ResponseEntity.ok(this.itemService.salvarItem(item));
    }

    @GetMapping({"/itens/categorias/{id-categoria}"})
    @Operation(
            summary = "Operação responsável por buscar itens por id de categoria"
    )
    public ResponseEntity<List<ItemResponse>> buscarItemPorIdCategoria(@PathVariable("id-categoria") Integer idCategoria) {
        return ResponseEntity.ok(this.itemService.buscarItemPorIdCategoria(idCategoria));
    }

    @GetMapping({"/itens/categorias"})
    @Operation(
            summary = "Operação responsável por filtrar itens por nome de categoria"
    )
    public ResponseEntity<List<ItemResponse>> buscarItemPorNomeCategoria(@RequestParam("nome-categoria") String nomeCategoria) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Content-Type-Options", "nosniff");
        List<ItemResponse> items = this.itemService.buscarItemPorNomeCategoria(nomeCategoria);
        return new ResponseEntity<>(items, headers, HttpStatus.OK);
    }

    @GetMapping({"/itens/{id}"})
    @Operation(
            summary = "Operação responsável por buscar um item por id"
    )
    public ResponseEntity<ItemResponse> buscarItemPorId(@PathVariable Long id) {
        return ResponseEntity.ok(this.itemService.buscarItemPorId(id));
    }

    @DeleteMapping({"/itens/{id}"})
    @Operation(
            summary = "Operação responsável por remover um Item da base de dados"
    )
    public ResponseEntity<String> removerItemPorId(@PathVariable Long id) {
        this.itemService.removerItem(id);
        return ResponseEntity.ok("Item removido com sucesso");
    }

    @PutMapping({"/itens"})
    @Operation(
            summary = "Operação responsável por atualizar um Item na base de dados"
    )
    public ResponseEntity<ItemResponse> atualizarItemPorId(@RequestBody EdicaoItemRequest item) {
        return ResponseEntity.ok(this.itemService.atualizarItem(item));
    }
}
