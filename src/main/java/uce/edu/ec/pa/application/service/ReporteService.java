package uce.edu.ec.pa.application.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import uce.edu.ec.pa.application.interceptor.Auditoria;
import uce.edu.ec.pa.domain.model.Reporte;
import uce.edu.ec.pa.infrastructure.repository.ReporteRepositoryImpl;

@Transactional
@ApplicationScoped
public class ReporteService {

    @Inject
    private ReporteRepositoryImpl reporteRepositoryImpl;

    @Auditoria
    public void guardarReporte(Reporte reporte) {
        String nombreHilo = Thread.currentThread().getName();
        System.out.println("Nombre del hilo ReporteService: " + nombreHilo);
        System.out.println("ID: " + Thread.currentThread().threadId());

        // try {
        // Thread.sleep(3000);
        // } catch (Exception e) {

        // }
        this.reporteRepositoryImpl.persist(reporte);

    }

    public void eliminarReporte(Integer id) {
        this.reporteRepositoryImpl.delete(this.reporteRepositoryImpl.findById(id));
    }

    public void actualizarReporte(Reporte reporte, Integer id) {

        Reporte reporteBase = this.buscarPorId(id);
        reporteBase.setDescripcion(reporte.getDescripcion());
        reporteBase.setEstado(reporte.getEstado());
        reporteBase.setFecha(reporte.getFecha());
        reporteBase.setNombre(reporte.getNombre());
        reporteBase.setTipo(reporte.getTipo());
        reporteBase.setNumero(reporte.getNumero());
        // no hace falta realizar explicitamente un update
        // ya que al ser una entidad administrada por JPA, cualquier cambio realizado en
        // el objeto se sincroniza automáticamente con la base de datos al finalizar la
        // transacción.
    }

    public Reporte buscarPorId(Integer id) {
        return this.reporteRepositoryImpl.findById(id);
    }

    public List<Reporte> buscarTodos() {
        return this.reporteRepositoryImpl.buscarTodos();
    }

    ////////////////////////////

    @Auditoria
    public void guardarListaReportes(List<Reporte> lista) {
        for (Reporte repo : lista) {
            this.reporteRepositoryImpl.persist(repo);
        }

    }

    public Reporte buscarPorTitulo(String titulo) {
        return this.reporteRepositoryImpl.buscarPorTitulo(titulo);
    }

}