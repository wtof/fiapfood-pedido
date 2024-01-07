package br.com.fiapfood.pedido.infra.controller;

import br.com.fiapfood.pedido.application.interfaces.PedidoService;
import br.com.fiapfood.pedido.application.payload.dto.StatusPedidoDTO;
import br.com.fiapfood.pedido.application.payload.request.EdicaoPedidoRequest;
import br.com.fiapfood.pedido.application.payload.request.PedidoRequest;
import br.com.fiapfood.pedido.application.payload.response.PedidoResponse;
import br.com.fiapfood.pedido.application.services.PedidoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoServiceImpl pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping({"/checkout"})
    @Operation(
            summary = "Operação responsável efetuar o checkout do pedido"
    )
    public ResponseEntity<PedidoResponse> checkoutPedido(@RequestBody PedidoRequest pedido) {
        return ResponseEntity.ok(this.pedidoService.efetuarCheckout(pedido));
    }

    @GetMapping({"/pedidos/{id}"})
    @Operation(
            summary = "Operação responsável por buscar um pedido por id"
    )
    public ResponseEntity<PedidoResponse> buscarPedido(@PathVariable Long id) {
        return ResponseEntity.ok(this.pedidoService.buscarPedido(id));
    }

    @PutMapping({"/pedidos"})
    @Operation(
            summary = "Operação responsável por atualizar um pedido"
    )
    public ResponseEntity<PedidoResponse> atualizarPedido(@RequestBody EdicaoPedidoRequest pedido) {
        return ResponseEntity.ok(this.pedidoService.atualizarPedido(pedido));
    }

    @GetMapping({"/pedidos/"})
    @Operation(
            summary = "Operação responsável por listar pedidos por status"
    )
    public ResponseEntity<List<PedidoResponse>> buscarPedido(@RequestParam StatusPedidoDTO status) {
        return ResponseEntity.ok(this.pedidoService.buscarPedidoPorStatus(status));
    }

    @GetMapping({"/pedidos/ativos"})
    @Operation(
            summary = "Operação responsável por listar pedidos por status"
    )
    public ResponseEntity<List<PedidoResponse>> buscarPedidosAtivos() {
        return ResponseEntity.ok(this.pedidoService.buscarPedidosAtivos());
    }
}
