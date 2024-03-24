package com.possistemaecommerc.api.controllers;

import com.possistemaecommerc.application.dtos.contas.CriarContaDTO;
import com.possistemaecommerc.application.dtos.contas.CriarContaResponseDTO;
import com.possistemaecommerc.application.services.UsuarioAppServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CriarContaController {

    @Autowired
    private UsuarioAppServiceImpl usuarioAppService;

    @PostMapping("/api/usuarios/criar-conta")
    public ResponseEntity<CriarContaResponseDTO> post(@Valid @RequestBody CriarContaDTO dto){

        CriarContaResponseDTO responseDTO= usuarioAppService.criarConta(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
}
