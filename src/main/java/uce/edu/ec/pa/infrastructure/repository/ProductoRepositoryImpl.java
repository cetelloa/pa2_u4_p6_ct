package uce.edu.ec.pa.infrastructure.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import uce.edu.ec.pa.domain.model.Producto;

@Transactional
@ApplicationScoped
public class ProductoRepositoryImpl implements PanacheRepositoryBase<Producto, Integer> {

}
