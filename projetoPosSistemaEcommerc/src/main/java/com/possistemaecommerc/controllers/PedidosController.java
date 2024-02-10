package com.possistemaecommerc.controllers;

import com.possistemaecommerc.entities.Endereco;
import com.possistemaecommerc.entities.Pedido;
import com.possistemaecommerc.entities.interfaces.IClienteRepository;
import com.possistemaecommerc.entities.interfaces.IPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/pedidos", produces = MediaType.APPLICATION_JSON_VALUE)

public class PedidosController {
    @Autowired
    private IPedidoRepository iPedidoRepository;
//    private final IPedidoRepository iPedidoRepository;

    @PostMapping
    @ResponseBody
    public ResponseEntity<String> post() {
        return null;
    }
    @PutMapping
    @ResponseBody
    public ResponseEntity<String> put() {
        return null;
    }
    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        return null;
    }
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> getById(@PathVariable("id") Integer id) {
        return null;
    }
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Pedido>> getList() {
        return getList();
    }
}
