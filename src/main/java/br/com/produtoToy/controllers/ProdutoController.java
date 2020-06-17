package br.com.produtoToy.controllers;

import br.com.produtoToy.domains.Produto;
import br.com.produtoToy.repositories.ProdutoRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value ="/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository rep;


    @GetMapping(value = "{id}")
    public ResponseEntity <?> findById(@PathVariable Integer id){
        Optional <Produto> produtoOptional = rep.findById(id);
        if (produtoOptional.isPresent()){
            return ResponseEntity.ok(produtoOptional);
        } else{
            System.out.println("ID não encontrada");
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "search/{descricao}")
    public ResponseEntity <?> findByDescricao(@PathVariable String descricao){
        List <Produto> produtos = rep.findByDescricaoContainingIgnoreCase(descricao);
        if (produtos.size() > 0){
            return ResponseEntity.ok(produtos);
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity <?> deletebyId (@PathVariable Integer id){
        try {
            rep.deleteById(id);
            System.out.println("Produto deletado");
            return ResponseEntity.ok(id);
        }catch (EmptyResultDataAccessException e){
            System.out.println("Produto não encontrado");
            return ResponseEntity.notFound().build();
        }
    }

}
