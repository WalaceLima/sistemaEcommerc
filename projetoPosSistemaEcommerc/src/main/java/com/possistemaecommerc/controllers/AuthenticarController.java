package com.possistemaecommerc.controllers;

import com.possistemaecommerc.application.dtos.auth.AutenticarDTO;
import com.possistemaecommerc.application.dtos.auth.AutenticarResponseDTO;
import com.possistemaecommerc.application.dtos.auth.AuthenticarGetDTO;
import com.possistemaecommerc.application.dtos.auth.AuthenticarPostDTO;
import com.possistemaecommerc.application.dtos.clientes.ClienteGetDTO;
import com.possistemaecommerc.application.interfaces.IUsuarioAppService;
import com.possistemaecommerc.controllers.configuration.domain.Cliente;
import com.possistemaecommerc.infrastructure.repositories.IClienteRepository;
import com.possistemaecommerc.infrastructure.security.Criptografia;
import com.possistemaecommerc.infrastructure.security.TokenSecurity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping(path = "/api/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticarController {

    @Autowired
    private IClienteRepository clienteRepository;

    @Autowired
    @Qualifier("usuarioServiceImplTODO")
    private IUsuarioAppService usuarioAppService;


    @PostMapping("/api/clientes")
    @ResponseBody
    public ResponseEntity<AuthenticarGetDTO> post(@RequestBody AuthenticarPostDTO dto) {
        try {

            Cliente cliente = clienteRepository.findByEmailAndSenha(dto.getEmail(), Criptografia.criptografar(dto.getSenha()));

            if (cliente == null) { //não foi encontrado..
                return ResponseEntity.status
                        (HttpStatus.UNAUTHORIZED).body(null);
            }
            AuthenticarGetDTO result = new AuthenticarGetDTO();
            result.setAccessToken(TokenSecurity.generateToken(cliente.getEmail()));
            result.setCliente(new ClienteGetDTO());
            result.getCliente()
                    .setIdCliente(cliente.getIdCliente());
            result.getCliente().setNome(cliente.getNome());
            result.getCliente().setEmail(cliente.getEmail());
            result.getCliente().setCpf(cliente.getCpf());
            result.getCliente().setTelefone
                    (cliente.getTelefone());
            result.getCliente().setLogradouro
                    (cliente.getEndereco().getLogradouro());
            result.getCliente().setNumero
                    (cliente.getEndereco().getNumero());
            result.getCliente().setComplemento
                    (cliente.getEndereco().getComplemento());
            result.getCliente().setBairro
                    (cliente.getEndereco().getBairro());
            result.getCliente().setCidade
                    (cliente.getEndereco().getCidade());
            result.getCliente().setEstado
                    (cliente.getEndereco().getEstado());
            result.getCliente().setCep
                    (cliente.getEndereco().getCep());
            return ResponseEntity.status
                    (HttpStatus.OK).body(result);
        } catch (Exception e) {
            return ResponseEntity.status
                    (HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/api/usuarios/autenticar")
    public ResponseEntity<AutenticarResponseDTO> post
            (@Valid @RequestBody AutenticarDTO dto) {
        AutenticarResponseDTO autenticarResponseDTO = usuarioAppService.autenticar(dto);
        return ResponseEntity.status(HttpStatus.OK).body(autenticarResponseDTO);
    }
}

