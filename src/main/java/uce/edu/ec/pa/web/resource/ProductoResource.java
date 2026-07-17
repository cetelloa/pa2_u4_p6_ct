package uce.edu.ec.pa.web.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import uce.edu.ec.pa.application.service.ProductoService;
import uce.edu.ec.pa.domain.model.Producto;

@Path("/productos")
public class ProductoResource {

    @Inject
    private ProductoService productoService;

    @Path("/guardar")
    @POST
    public void guardarProducto(Producto producto) {

        this.productoService.guardarProducto(producto);
    }

    @Path("/porId/{id}")
    @GET
    public Producto buscarProductoPorId(@PathParam("id") Integer id) {

        return this.productoService.obtenerProductoPorId(id);

    }

    @Path("/actualizar/{id}")
    @PUT
    public void actualizarProducto(Producto producto, Integer id) {
        this.productoService.actualizarProducto(producto, id);
    }

    @Path("/eliminar/{id}")
    @DELETE
    public void eliminarProductoPorId(@PathParam("id") Integer id) {
        this.productoService.eliminarProducto(id);
    }

    @Path("/todos")
    @GET
    public List<Producto> buscarTodosLosProductos() {

        return this.productoService.obtenerTodosLosProductos();
    }

}
