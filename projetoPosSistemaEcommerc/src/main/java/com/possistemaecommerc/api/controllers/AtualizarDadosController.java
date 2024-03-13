package com.possistemaecommerc.api.controllers;

import com.possistemaecommerc.application.dtos.AtualizarDadosResponseDTO;
import com.possistemaecommerc.application.dtos.Conta.AtualizarDadosDTO;
import com.possistemaecommerc.application.interfaces.IUsuarioAppService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AtualizarDadosController {

/*    @Autowired
    private IUsuarioAppService usuarioAppService;

    @PutMapping("/api/usuarios/atualizar-dados")
    public String put(@Valid @RequestBody AtualizarDadosDTO dto) {
        AtualizarDadosResponseDTO response= usuarioAppService.(dto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }*/
}
