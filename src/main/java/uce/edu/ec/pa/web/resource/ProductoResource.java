package uce.edu.ec.pa.web.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import uce.edu.ec.pa.application.service.ProductoService;
import uce.edu.ec.pa.domain.model.Producto;

@Path("/productos")
public class ProductoResource {

    @Inject
    private ProductoService productoService;

    public Producto buscarPorId(Integer id) {

        return productoService.obtenerProductoPorId(id);

    }

}
