package com.possistemaecommerc.api.controllers;

import com.possistemaecommerc.application.dtos.Conta.RecuperarSenhaDTO;
import com.possistemaecommerc.application.dtos.auth.RecuperarSenhaResponseDTO;
import com.possistemaecommerc.application.interfaces.IUsuarioAppService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecuperarSenhaController {

    @Qualifier("usuarioAppServiceImpl")
    @Autowired
    private IUsuarioAppService usuarioAppService;

    @PostMapping("/api/usuarios/recuperar-senha")
    public ResponseEntity<RecuperarSenhaResponseDTO> post(@Valid @RequestBody RecuperarSenhaDTO dto) {
        RecuperarSenhaResponseDTO recuperarSenhaResponseDTO = usuarioAppService.recuperarSenha(dto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(recuperarSenhaResponseDTO);
    }
}
