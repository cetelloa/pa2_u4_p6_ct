package uce.edu.ec.pa.domain.model;

@Entity
@Table(name = "producto")
public class Producto extends PanacheEnityBase{
    
    @SequenceGenerator(name = "seq_producto_generador", sequenceName = "seq_producto", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_producto_generador")
    @Id
    private Integer id;
    
    @Column(name = "prod_nombre")
    private String nombre;
    @Column(name = "prod_descripcion")
    private String descripcion;
    @Column (name = "prod_fecha_vencimiento")
    private LocalDate fecha_vencimiento;
    @Column(name = "prod_precio")
    private Double precio;
    @Column(name = "prod_cantidad")
    private Integer cantidad;

}
