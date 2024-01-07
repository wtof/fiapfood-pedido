package br.com.fiapfood.pedido.infra.controller;

import br.com.fiapfood.pedido.application.interfaces.ClienteService;
import br.com.fiapfood.pedido.application.payload.request.ClienteRequest;
import br.com.fiapfood.pedido.application.payload.response.ClienteResponse;
import br.com.fiapfood.pedido.application.services.ClienteServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteServiceImpl clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping({"/clientes"})
    @Operation(
            summary = "Operação responsável por salvar um cliente na base de dados"
    )
    public ResponseEntity<ClienteResponse> salvarCliente(@RequestBody ClienteRequest cliente) {
        return ResponseEntity.ok(this.clienteService.salvarCliente(cliente));
    }

    @GetMapping({"/clientes/{cpf}"})
    @Operation(
            summary = "Operação responsável por buscar um cliente por cpf"
    )
    public ResponseEntity<ClienteResponse> buscarClientePorCpf(@PathVariable Long cpf) {
        return ResponseEntity.ok(this.clienteService.buscarClientePorCpf(cpf));
    }
}
