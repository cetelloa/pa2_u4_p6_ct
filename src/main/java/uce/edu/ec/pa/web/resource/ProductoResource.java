package uce.edu.ec.pa.web.resource;

@Path("/productos")
public class ProductoResource {

    @Inject
    private ProductoService productoService;

    public Producto buscarPorId(Integer id) {

        return productoService.obtenerProductoPorId(id);

    }

}
