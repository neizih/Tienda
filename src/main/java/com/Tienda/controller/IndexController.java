package com.Tienda.controller;


import com.Tienda.domain.Cliente;
import com.Tienda.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class IndexController {
    
    @Autowired
    private ClienteService clienteService;
            
    @GetMapping("/")
    public String inicio(Model model){        
        log.info("Ahora utilizamos MVC");
        
        /*Cliente cliente = new Cliente("Nazih","Houssain Zayzafoun","nazihhoussain20@gmail.com","63407593");
        Cliente cliente2 = new Cliente("Jose","Rivera","joserivera@gmail.com","12345");
        Cliente cliente3 = new Cliente("Luis","Fernando","luisloco1@gmail.com","98682028");
        
        var clientes = Arrays.asList(cliente,cliente2,cliente3);
        
        model.addAttribute("clientes", cliente);
        model.addAttribute("clientes", clientes);*/
        
        var clientes = clienteService.getClientes();
        model.addAttribute("clientes", clientes);
        
        return "index";
    }
    
    @GetMapping("/nuevoCliente")
    public String nuevoCliente(Cliente cliente){
        return "modificarCliente";
    }
    
    @PostMapping("/guardarCliente")
    public String guardarCliente(Cliente cliente){
        clienteService.save(cliente);
        return "redirect:/";
    }
    
    @GetMapping("/modificarCliente/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model){
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "modificarCliente";
    }
    
    @GetMapping("/eliminarCliente/{idCliente}")
    public String eliminarCliente (Cliente cliente){
        clienteService.delete(cliente);
        
        return "redirect:/";
    }
}
