package uce.edu.ec.pa.infrastructure.repository;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import uce.edu.ec.pa.domain.model.Reporte;

@Transactional
@ApplicationScoped
public class ReporteRepositoryImpl implements PanacheRepositoryBase<Reporte, Integer> {

    @Inject
    private EntityManager entityManager;

    public List<Reporte> buscarTodos() {
        return findAll().list();
    }

    public Reporte buscarPorTitulo(String titulo) {
        return find("titulo", titulo).firstResult();
    }

    public void actualizarReporte(Reporte reporte) {
        this.entityManager.merge(reporte);
    }
}