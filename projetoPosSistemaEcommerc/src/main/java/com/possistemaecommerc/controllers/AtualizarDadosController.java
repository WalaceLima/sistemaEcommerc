package com.possistemaecommerc.api.controllers;

import com.possistemaecommerc.application.dtos.AtualizarDadosResponseDTO;
import com.possistemaecommerc.application.dtos.contas.AtualizarDadosDTO;
import com.possistemaecommerc.application.interfaces.IUsuarioAppService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AtualizarDadosController {

    @Qualifier("usuarioServiceImplTODO")
    @Autowired
    private IUsuarioAppService usuarioAppService;

    @PutMapping("/api/usuarios/atualizar-dados")
    public ResponseEntity<AtualizarDadosResponseDTO> put(@Valid @RequestBody AtualizarDadosDTO dto) {
        AtualizarDadosResponseDTO atualizarDadosResponseDTO= usuarioAppService.atualizarDados(dto);
        return ResponseEntity.status(HttpStatus.OK).body(atualizarDadosResponseDTO);
    }
}
