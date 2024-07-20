package com.example.exerciciossb.controllers;

import com.example.exerciciossb.model.entities.Categoria;
import com.example.exerciciossb.model.repositories.CategoriaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @RequestMapping(method =  {RequestMethod.POST, RequestMethod.PUT})
    public @ResponseBody Categoria novaCategoria(@Valid @RequestBody Categoria categoria){
        categoriaRepository.save(categoria);
        return categoria;
    }

}
