package com.possistemaecommerc.api.controllers;

import com.possistemaecommerc.api.controllers.configuration.domain.Endereco;
import com.possistemaecommerc.infrastructure.repositories.IEnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/enderecos", produces = MediaType.APPLICATION_JSON_VALUE)
public class EnderecosController {

    @Autowired
    IEnderecoRepository enderecoRepository;

/*    private final IEnderecoRepository enderecoRepository;*/

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
    public ResponseEntity<List<Endereco>> getList() {
        return getList();
    }

}
