package com.Tienda.controller;

import com.Tienda.domain.Categoria;
import com.Tienda.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping("/categoria/listado")
    public String inicio(Model model){
        var categorias = categoriaService.Categorias(false);
        model.addAttribute("categoria", categorias);
        return "/categorias/listado";
    }
    
     @GetMapping("/categoria/nuevoCategoria")
    public String nuevoCategoria(Categoria categoria){
        return "/categoria/modificarCategoria";
    }
    
    @PostMapping("/categoria/guardarCategoria")
    public String guardarCategoria(Categoria categoria){
        categoriaService.save(categoria);
        return "redirect:/categoria/listado";
    }
    
    @GetMapping("/categoria/modificar/{idCategoria}")
    public String modificarCategoria(Categoria categoria, Model model){
        categoria = categoriaService.Categoria(categoria);
        model.addAttribute("categoria", categoria);
        return "/categoria/modificar";
    }
    
    @GetMapping("/categoria/eliminar/{idCategoria}")
    public String eliminarCategoria (Categoria categoria){
        categoriaService.delete(categoria);
        
        return "redirect:/categoria/listado";
    }
}
