package uce.edu.ec.pa.infrastructure.repository;

@Transactional
@ApplicationScoped
public class ProductoRepositoryImpl implements PanacheRepository<Producto, Integer> {

    public List<Reporte> buscarTodos() {
        return findAll().list();
    }

}
