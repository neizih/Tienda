package com.Tienda.controller;

import com.Tienda.domain.Articulo;
import com.Tienda.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


public class ArticuloController {
    @Autowired
    private ArticuloService articuloService;
    
    @GetMapping("/articulo/listado")
    public String inicio(Model model){
        var articulos = articuloService.getArticulos(false);
        model.addAttribute("articulo", articulos);
        return "/articulos/listado";
    }
    
     @GetMapping("/articulo/nuevoArticulo")
    public String nuevoArticulo(Articulo articulo){
        return "/articulo/modificarArticulo";
    }
    
    @PostMapping("/articulo/guardarArticulo")
    public String guardarArticulo(Articulo articulo){
        articuloService.save(articulo);
        return "redirect:/articulo/listado";
    }
    
    @GetMapping("/articulo/modificar/{idArticulo}")
    public String modificarArticulo(Articulo articulo, Model model){
        articulo = articuloService.getArticulo(articulo);
        model.addAttribute("articulo", articulo);
        return "/articulo/modificar";
    }
    
    @GetMapping("/articulo/eliminar/{idArticulo}")
    public String eliminarArticulo (Articulo articulo){
        articuloService.delete(articulo);
        
        return "redirect:/articulo/listado";
    }
}