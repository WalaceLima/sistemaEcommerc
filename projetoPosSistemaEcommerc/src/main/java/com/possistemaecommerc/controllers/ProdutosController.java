package com.possistemaecommerc.api.controllers;

import com.possistemaecommerc.application.dtos.produtos.ProdutoGetDTO;
import com.possistemaecommerc.api.controllers.configuration.domain.Produto;
import com.possistemaecommerc.infrastructure.repositories.IProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/produtos", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProdutosController {

    @Autowired
    private IProdutoRepository produtoRepository;
//    private final IProdutoRepository clienteRepository;

    @GetMapping
@ResponseBody
public ResponseEntity<List<ProdutoGetDTO>> getAll() {
    try {
        List<ProdutoGetDTO> result
                = new ArrayList<ProdutoGetDTO>();
        for (Produto produto :produtoRepository.findAll()) {
            ProdutoGetDTO dto = new ProdutoGetDTO();
            dto.setIdProduto(produto.getIdProduto());
            dto.setNome(produto.getNome());
            dto.setPreco(produto.getPreco());
            dto.setDescricao(produto.getDescricao());
            dto.setFoto(produto.getFoto());
            result.add(dto);
        }
        return ResponseEntity
                .status(HttpStatus.OK).body(result);
    } catch (Exception e) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR).body(null)
                ;
    }
}

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<ProdutoGetDTO> getById(@PathVariable("id") Integer id) {
        try {
            Optional<Produto> result = produtoRepository
                    .findById(id);
            if (result == null || result.isEmpty()) {
                return ResponseEntity.status
                        (HttpStatus.NO_CONTENT).body(null);
            }
            Produto produto = result.get();
            ProdutoGetDTO dto = new ProdutoGetDTO();
            dto.setIdProduto(produto.getIdProduto());
            dto.setNome(produto.getNome());
            dto.setPreco(produto.getPreco());
            dto.setDescricao(produto.getDescricao());
            dto.setFoto(produto.getFoto());
            return ResponseEntity.status
                    (HttpStatus.OK).body(dto);
        } catch (Exception e) {
            return ResponseEntity.status
                    (HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
}

//    @GetMapping
//    @ResponseBody
//    public ResponseEntity<List<ProdutoGetDTO>> getList() {
//        try {
//            List<ProdutoGetDTO> result= new ArrayList<ProdutoGetDTO>();
//            for (Produto produto :produtoRepository.findAll()) {
//                ProdutoGetDTO dto = new ProdutoGetDTO();
//                dto.setIdProduto(produto.getIdProduto());
//                dto.setNome(produto.getNome());
//                dto.setPreco(produto.getPreco());
//                dto.setDescricao(produto.getDescricao());
//                dto.setFoto(produto.getFoto());
//                result.add(dto);
//            }
//            return ResponseEntity
//                    .status(HttpStatus.OK).body(result);
//        } catch (Exception e) {
//            return ResponseEntity
//                    .status(HttpStatus.INTERNAL_SERVER_ERROR).body(null)
//                    ;
//        }
//
//    }
}
