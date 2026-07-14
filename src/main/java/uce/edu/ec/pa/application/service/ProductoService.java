package uce.edu.ec.pa.application.service;

@ApplicationScoped
@Transactional
public class ProductoService {

    @Inject
    private ProductoRepositoryImpl productoRepositoryImpl;

    public void guardarProducto(Producto producto) {
        this.productoRepositoryImpl.persist(producto);
    }

    public Producto obtenerProductoPorId(Integer id) {
        return this.productoRepositoryImpl.findById(id);
    }

    public void actualizarProducto(Producto producto, Integer id) {
        Producto productoBase = this.productoRepositoryImpl.findById(id);
        productoBase.setNombre(producto.getNombre());
        productoBase.setDescripcion(producto.getDescripcion());
        productoBase.setFecha_vencimiento(producto.getFecha_vencimiento());
        productoBase.setPrecio(producto.getPrecio());
        productoBase.setCantidad(producto.getCantidad());
    }

    public void eliminarProducto(Integer id) {
        Producto producto = this.productoRepositoryImpl.findById(id);
        if (producto != null) {
            this.productoRepositoryImpl.delete(producto);
        }
    }

    public List<Producto> obtenerTodosLosProductos() {
        return this.productoRepositoryImpl.buscarTodos();
    }
    

}
