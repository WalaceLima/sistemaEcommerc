package com.possistemaecommerc;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.possistemaecommerc.application.dtos.Conta.AtualizarDadosDTO;
import com.possistemaecommerc.application.dtos.Conta.CriarContaDTO;
import com.possistemaecommerc.application.dtos.Conta.RecuperarSenhaDTO;
import com.possistemaecommerc.application.dtos.auth.AutenticarDTO;
import com.possistemaecommerc.application.dtos.auth.AutenticarResponseDTO;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ApiUsuariosApplicationTests {

    @Autowired
    private MockMvc mock;
    @Autowired
    private ObjectMapper objectMapper;

    private static String id;
    private static String email;
    private static String senha;
    private static String accessToken;

    @Test
    @Order(1)
    public void criarContaTest() throws Exception {
        CriarContaDTO dto = new CriarContaDTO();
        Faker faker = new Faker();
        dto.setNome(faker.name().fullName());
        dto.setEmail("julima@gmail.com");
        dto.setSenha("JuEli@301214");
        mock.perform((MockMvcRequestBuilders.post("/api/usuarios/criar-conta"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status()
                        .isCreated());
        email = dto.getEmail();
        senha = dto.getSenha();
    }
    @Test
    @Order(2)
    public void autenticarTest() throws Exception {
        AutenticarDTO dto = new AutenticarDTO();
        dto.setEmail(email);
        dto.setSenha(senha);
        MvcResult result= mock.perform((MockMvcRequestBuilders.post("/api/usuarios/autenticar"))
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk()).andReturn();

        String content=result.getResponse().getContentAsString();
        AutenticarResponseDTO autenticarResponseDTO=objectMapper.readValue(content,AutenticarResponseDTO.class);
        id=autenticarResponseDTO.getId();
        accessToken=autenticarResponseDTO.getAccessToken();
    }
    @Test
    @Order(3)
    public void atualizarDadosTest() throws Exception {

        AtualizarDadosDTO dto = new AtualizarDadosDTO();
        Faker faker = new Faker();
        dto.setIdUsuario(dto.getIdUsuario());
        dto.setNome(faker.name().fullName());
        dto.setSenha("JuEli@301214");
        mock.perform(put("/api/usuarios/atualizar-dados")

                .header("Authorization", "Bearer " + accessToken)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status()
                        .isOk());
    }
    @Test
    @Order(4)
    public void recuperarSenhaTest() throws Exception {
        RecuperarSenhaDTO dto = new RecuperarSenhaDTO();
        dto.setEmail(email);
        mock.perform(MockMvcRequestBuilders.post("/api/usuarios/recuperar-senha")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status()
                        .isOk());
    }
    @Test
    public void testEndpointProtegidoPorJWT() throws Exception {
        // Obtém um token JWT válido (pode ser gerado manualmente ou obtido de outra forma)
        String tokenJWT = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqdWxpbWFAZ21haWwuY29tIiwiaWF0IjoxNzEwMjg3NTgyfQ.ivyjxpNAtXly4xhMxlz88t0j52H6RscYwfS9CYHhJnQ";

        // Define o cabeçalho Authorization com o token JWT
        mock.perform(get("/api/usuarios/atualizar-dados")
                        .header("Authorization", "Bearer " + tokenJWT))
                .andExpect(status().isOk());
    }
}

