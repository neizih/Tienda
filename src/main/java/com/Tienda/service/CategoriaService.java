
package com.Tienda.service;

import com.Tienda.domain.Categoria;
import com.Tienda.domain.Cliente;
import java.util.List;


public interface CategoriaService {
    
    public List<Categoria> Categorias(boolean activo);
    
    public Categoria Categoria(Categoria categoria);
    
    public void save(Categoria categoria);
    
    public void delete(Categoria categoria);
}
