
package com.Tienda.service;

import com.Tienda.domain.Articulo;
import com.Tienda.domain.Cliente;
import java.util.List;


public interface ArticuloService {
    
    public List<Articulo> getArticulos(boolean activo);
    
    public Articulo getArticulo(Articulo cliente);
    
    public void save(Articulo articulo);
    
    public void delete(Articulo articulo);
}
