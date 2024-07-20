package com.example.exerciciossb.controllers;

import com.example.exerciciossb.model.entities.Categoria;
import com.example.exerciciossb.model.entities.Produto;
import com.example.exerciciossb.model.repositories.CategoriaRepository;
import com.example.exerciciossb.model.repositories.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public @ResponseBody Produto novoProduto(@Valid @RequestBody Produto produto) {
        Optional<Categoria> optionalCategoria = categoriaRepository.findById(produto.getCategoria().getId());

        if (optionalCategoria.isPresent()) {
            produto.setCategoria(optionalCategoria.get());
        } else {
            throw new EntityNotFoundException("Categoria não encontrada com o ID: " + produto.getCategoria().getId());
        }
        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping
    public Iterable<Produto> obterProduto(){
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Produto> obterProdutoPorId(@PathVariable int id){
        return produtoRepository.findById(id);
    }


    @DeleteMapping("/{id}")
    public void excluirProduto(@PathVariable int id){
        produtoRepository.deleteById(id);
    }

}
