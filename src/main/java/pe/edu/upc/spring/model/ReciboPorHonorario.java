package pe.edu.upc.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ReciboPorHonorario")
public class ReciboPorHonorario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name ="total", nullable=false)
	private double total;
	
	@Column(name ="retencion", nullable=false)
	private double retencion;
	
	@Column(name ="total_neto", nullable=false)
	private double total_neto;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario", nullable = false)
	private Usuario idUsuario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getRetencion() {
		return retencion;
	}

	public void setRetencion(double retencion) {
		this.retencion = retencion;
	}

	public double getTotal_neto() {
		return total_neto;
	}

	public void setTotal_neto(double total_neto) {
		this.total_neto = total_neto;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	public ReciboPorHonorario(Integer id, double total, double retencion, double total_neto, Usuario idUsuario) {
		super();
		this.id = id;
		this.total = total;
		this.retencion = retencion;
		this.total_neto = total_neto;
		this.idUsuario = idUsuario;
	}

	public ReciboPorHonorario() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	
}
