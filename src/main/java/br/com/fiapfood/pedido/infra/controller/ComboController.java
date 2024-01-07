package br.com.fiapfood.pedido.infra.controller;

import br.com.fiapfood.pedido.application.interfaces.ComboService;
import br.com.fiapfood.pedido.application.payload.request.ComboRequest;
import br.com.fiapfood.pedido.application.payload.response.ComboResponse;
import br.com.fiapfood.pedido.application.services.ComboServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ComboController {
    private final ComboService comboService;

    public ComboController(ComboServiceImpl comboService) {
        this.comboService = comboService;
    }

    @PostMapping({"/combos"})
    @Operation(
            summary = "Operação responsável por salvar um combo na base de dados"
    )
    public ResponseEntity<ComboResponse> salvarCombo(@RequestBody ComboRequest combo) {
        return ResponseEntity.ok(this.comboService.salvarCombo(combo));
    }

    @GetMapping({"/combos/{id}"})
    @Operation(
            summary = "Operação responsável por buscar um combo por id"
    )
    public ResponseEntity<ComboResponse> buscarComboPorCpf(@PathVariable Long id) {
        return ResponseEntity.ok(this.comboService.buscarComboPorId(id));
    }
}
