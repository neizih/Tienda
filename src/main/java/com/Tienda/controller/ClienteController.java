package com.Tienda.controller;

import com.Tienda.domain.Cliente;
import com.Tienda.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping("/cliente/listado")
    public String inicio(Model model){
        var clientes = clienteService.getClientes();
        model.addAttribute("cliente", clientes);
        return "/clientes/listado";
    }
    
     @GetMapping("/cliente/nuevoCliente")
    public String nuevoCliente(Cliente cliente){
        return "/cliente/modificarCliente";
    }
    
    @PostMapping("/cliente/guardarCliente")
    public String guardarCliente(Cliente cliente){
        clienteService.save(cliente);
        return "redirect:/cliente/listado";
    }
    
    @GetMapping("/cliente/modificar/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model){
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "/cliente/modificar";
    }
    
    @GetMapping("/cliente/eliminar/{idCliente}")
    public String eliminarCliente (Cliente cliente){
        clienteService.delete(cliente);
        
        return "redirect:/cliente/listado";
    }
}
