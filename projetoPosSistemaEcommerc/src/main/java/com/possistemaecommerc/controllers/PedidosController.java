package com.possistemaecommerc.api.controllers;

import com.possistemaecommerc.application.dtos.pedidos.PedidoGetDTO;
import com.possistemaecommerc.application.dtos.pedidos.PedidoPostDTO;
import com.possistemaecommerc.api.controllers.configuration.domain.Pedido;
import com.possistemaecommerc.api.controllers.configuration.domain.Produto;
import com.possistemaecommerc.infrastructure.repositories.IClienteRepository;
import com.possistemaecommerc.infrastructure.repositories.IPedidoRepository;
import com.possistemaecommerc.infrastructure.repositories.IProdutoRepository;
import com.possistemaecommerc.helpers.DateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(path = "/api/pedidos", produces = MediaType.APPLICATION_JSON_VALUE)
public class PedidosController {

    @Autowired
    private IPedidoRepository pedidoRepository;

    @Autowired
    private IProdutoRepository produtoRepository;

    @Autowired
    private IClienteRepository clienteRepository;

    /*    private final IProdutoRepository produtoRepository
    private final IClienteRepository clienteRepository;
    private final IPedidoRepository pedidoRepository;*/

    @PostMapping
    @ResponseBody
    public ResponseEntity<String> post(@RequestBody PedidoPostDTO dto) {

        try {
            if(dto.getIdProduto() == null || dto.getIdProduto()
                    .length == 0) {
                return ResponseEntity.status
                                (HttpStatus.BAD_REQUEST)
                        .body("Não há produtos adicionados a este pedido.");
            }
            Pedido pedido = new Pedido();
            pedido.setDataPedido(DateHelper.toDate
                    (dto.getDataPedido()));
            pedido.setValor(Double.parseDouble(dto.getValor()));
            pedido.setCliente(clienteRepository
                    .findById(Integer.parseInt
                            (dto.getIdCliente())).get());
            pedido.setProdutos(new ArrayList<Produto>());
            for (int i= 0; i < dto.getIdProduto().length; i++) {
                pedido.getProdutos()
                        .add(produtoRepository.findById
                                (dto.getIdProduto()[i]).get());
            }
            pedido.setCodigoPedido(new Random().nextInt(999999)
                    + DateHelper.toStringLine(pedido.getDataPedido()));
// salvando o pedido na base de dados
            pedidoRepository.save(pedido);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Pedido cadastrado com sucesso.Código: " + pedido.getCodigoPedido());
        } catch (Exception e) {
            return ResponseEntity.status
                            (HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro: " + e.getMessage() + ", "
                            + e.getLocalizedMessage());
        }
    }
    @GetMapping("/{idCliente}")
    @ResponseBody
    public ResponseEntity<List<PedidoGetDTO>> getById(@PathVariable("idCliente")Integer idCliente){
 /*       try {
List<PedidoGetDTO> result=new ArrayList<>();
for (Pedido pedido : pedidoRepository.findByCliente(idCliente)){
    PedidoGetDTO dto=new PedidoGetDTO();
    dto.setIdPedido(pedido.getIdPedido());
    dto.setCodigoPedido(pedido.getCodigoPedido());
    dto.setDataPedido(DateHelper
            .toStringPtBR(pedido.getDataPedido()));
    dto.setValor(pedido.getValor());
    dto.setCliente(new ClienteGetDTO());
    dto.getCliente().setIdCliente
            (pedido.getCliente().getIdCliente());
    dto.getCliente()
            .setNome(pedido.getCliente().getNome());
    dto.getCliente()
            .setEmail(pedido.getCliente().getEmail());
    dto.getCliente()
            .setCpf(pedido.getCliente().getCpf());
    dto.getCliente()
            .setTelefone(pedido.getCliente()
                    .getTelefone());
    dto.getCliente()
            .setLogradouro(pedido.getCliente()
                    .getEndereco().getLogradouro());
    dto.getCliente().setNumero
            (pedido.getCliente().getEndereco().getNumero()
            );
    dto.getCliente().setComplemento
            (pedido.getCliente().getEndereco()

                    .getComplemento());
    dto.getCliente().setBairro
            (pedido.getCliente().getEndereco().getBairro());
    dto.getCliente().setCidade
            (pedido.getCliente().getEndereco().getCidade());
    dto.getCliente().setEstado
            (pedido.getCliente().getEndereco().getEstado());
    dto.getCliente().setCep
            (pedido.getCliente().getEndereco().getCep());
    dto.setProdutos(new ArrayList
            <ProdutoGetDTO>());
    for (Produto produto : pedido.getProdutos()) {
        ProdutoGetDTO produtoDTO
                = new ProdutoGetDTO();
        produtoDTO.setIdProduto
                (produto.getIdProduto());
        produtoDTO.setNome(produto.getNome());
        produtoDTO.setPreco(produto.getPreco());
        produtoDTO.setDescricao
                (produto.getDescricao());
        produtoDTO.setFoto(produto.getFoto());
        dto.getProdutos().add(produtoDTO);
    }
    result.add(dto);
}
            return ResponseEntity.status
                    (HttpStatus.OK).body(result);
        } catch (Exception e) {
            return ResponseEntity.status
                    (HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }*/
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
    /*@GetMapping("/{idCliente}")
    @ResponseBody
    public ResponseEntity<List<PedidoGetDTO>> getById(@PathVariable("idCliente") Integer idCliente) {
        try {
            List<PedidoGetDTO> result= new ArrayList<PedidoGetDTO>();
            for (Pedido pedido : pedidoRepository.findByClientePorIdPedido(idCliente)) {
                PedidoGetDTO dto= new PedidoGetDTO();
                dto.setIdPedido(pedido.getIdPedido());
                dto.setCodigoPedido(pedido.getCodigoPedido());
                dto.setDataPedido(DateHelper
                        .toStringPtBR(pedido.getDataPedido()));
                dto.setValor(pedido.getValor());
                dto.setCliente(new ClienteGetDTO());
                dto.getCliente().setIdCliente
                        (pedido.getCliente().getIdCliente());
                dto.getCliente()
                        .setNome(pedido.getCliente().getNome());
                dto.getCliente()
                        .setEmail(pedido.getCliente().getEmail());
                dto.getCliente()
                        .setCpf(pedido.getCliente().getCpf());
                dto.getCliente()
                        .setTelefone(pedido.getCliente()
                                .getTelefone());
                dto.getCliente()
                        .setLogradouro(pedido.getCliente()
                                .getEndereco().getLogradouro());
                dto.getCliente().setNumero
                        (pedido.getCliente().getEndereco().getNumero()
                        );
                dto.getCliente().setComplemento
                        (pedido.getCliente().getEndereco()
                                .getComplemento());
                dto.getCliente().setBairro
                        (pedido.getCliente().getEndereco().getBairro());
                dto.getCliente().setCidade
                        (pedido.getCliente().getEndereco().getCidade());
                dto.getCliente().setEstado
                        (pedido.getCliente().getEndereco().getEstado());
                dto.getCliente().setCep
                        (pedido.getCliente().getEndereco().getCep());
                dto.setProdutos(new ArrayList
                        <ProdutoGetDTO>());
                for (Produto produto : pedido.getProdutos()) {
                    ProdutoGetDTO produtoDTO
                            = new ProdutoGetDTO();
                    produtoDTO.setIdProduto
                            (produto.getIdProduto());
                    produtoDTO.setNome(produto.getNome());
                    produtoDTO.setPreco(produto.getPreco());
                    produtoDTO.setDescricao
                            (produto.getDescricao());
                    produtoDTO.setFoto(produto.getFoto());
                    dto.getProdutos().add(produtoDTO);
                }
                result.add(dto);
            }
            return ResponseEntity.status
                    (HttpStatus.OK).body(result);
        } catch (Exception e) {
            return ResponseEntity.status
                    (HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }*/

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Pedido>> getList() {
        return getList();
    }
}
