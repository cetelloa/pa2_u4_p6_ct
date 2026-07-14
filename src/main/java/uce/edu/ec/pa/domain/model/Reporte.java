package uce.edu.ec.pa.domain.model;

import java.time.LocalDate;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "reporte")
public class Reporte extends PanacheEntityBase {

	@Id
	@SequenceGenerator(name = "seq_reporte_generador", sequenceName = "seq_reporte", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_reporte_generador")
	@Column(name = "rep_id")
	private Integer id;

	@Column(name = "rep_nombre")
	private String nombre;

	@Column(name = "rep_descripcion")
	private String descripcion;

	@Column(name = "rep_numero")
	private String numero;
	@Column(name = "rep_fecha")
	private LocalDate fecha;

	@Column(name = "rep_estado")
	private String estado;

	@Column(name = "rep_tipo")
	private String tipo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
