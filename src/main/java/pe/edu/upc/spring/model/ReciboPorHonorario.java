package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ReciboPorHonorario")
public class ReciboPorHonorario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReciboPorHonorario;
	
	@Column(name ="Total", nullable=false)
	private double Total;
	
	@Column(name ="Retencion", nullable=false)
	private double Retencion;
	
	@Column(name ="Total_neto", nullable=false)
	private double Total_neto;
	
	@Column(name = "Periodo",nullable = false)
	private int Periodo;
	
	@Column(name = "AlDescuento",nullable = false)
	private double AlDescuento;
	
	@Column(name="RTCEA", length=10, nullable=false)
	private double RTCEA;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUsuario", nullable = false)
	private Usuario usuario;

	public ReciboPorHonorario() {
		super();
	}

	public ReciboPorHonorario(int idReciboPorHonorario, double total, double retencion, double total_neto, int periodo,
			double alDescuento, double rTCEA, Usuario usuario) {
		super();
		this.idReciboPorHonorario = idReciboPorHonorario;
		Total = total;
		Retencion = retencion;
		Total_neto = total_neto;
		Periodo = periodo;
		AlDescuento = alDescuento;
		RTCEA = rTCEA;
		this.usuario = usuario;
	}

	public int getIdReciboPorHonorario() {
		return idReciboPorHonorario;
	}

	public void setIdReciboPorHonorario(int idReciboPorHonorario) {
		this.idReciboPorHonorario = idReciboPorHonorario;
	}

	public double getTotal() {
		return Total;
	}

	public void setTotal(double total) {
		Total = total;
	}

	public double getRetencion() {
		return Retencion;
	}

	public void setRetencion(double retencion) {
		Retencion = retencion;
	}

	public double getTotal_neto() {
		return Total_neto;
	}

	public void setTotal_neto(double total_neto) {
		Total_neto = total_neto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getPeriodo() {
		return Periodo;
	}

	public void setPeriodo(int periodo) {
		Periodo = periodo;
	}

	public double getAlDescuento() {
		return AlDescuento;
	}

	public void setAlDescuento(double alDescuento) {
		AlDescuento = alDescuento;
	}

	public double getRTCEA() {
		return RTCEA;
	}

	public void setRTCEA(double rTCEA) {
		RTCEA = rTCEA;
	}
}
