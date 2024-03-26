package com.possistemaecommerc.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.possistemaecommerc.application.dtos.pedidos.PedidoDTO;
import com.possistemaecommerc.application.dtos.response.PedidoResponseDTO;
import com.possistemaecommerc.infrastructure.repositories.IClienteRepository;
import com.possistemaecommerc.infrastructure.repositories.IPedidoRepository;
import com.possistemaecommerc.infrastructure.repositories.IProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/pedidos", produces = MediaType.APPLICATION_JSON_VALUE)
public class PedidosController {

    @Autowired
    private IPedidoRepository pedidoRepository;

    @Autowired
    private IProdutoRepository produtoRepository;

    @Autowired
    private IClienteRepository clienteRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping
    @ResponseBody
    public ResponseEntity<PedidoResponseDTO>
    post(@RequestBody PedidoDTO request) {
        String message = null;
        try {
            message = objectMapper.writeValueAsString(request);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        PedidoResponseDTO response = new PedidoResponseDTO();
        response.setMensagem("Pedido realizado com sucesso.");
        response.setStatus("created");
        response.setNumeroPedido(UUID.randomUUID().toString());

        return ResponseEntity.status(201).body(response);
    }
}
