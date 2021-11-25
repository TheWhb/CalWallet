package pe.edu.upc.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Letra")
public class Letra implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLetra;
	
	@Column(name="ImporteLetra", nullable=false)
	private double ImporteLetra;
	
	//@Future(message = "No se puede insertar esa fecha")
	@Temporal(TemporalType.DATE)
	@Column(name ="FechaPagarLetra")
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	private Date FechaPagarLetra;
	
	@Column(name="InteresAnual", length = 10, nullable=false)
	private double InteresAnual;
	
	@Column(name="MoraAnual", length = 10, nullable=false)
	private double MoraAnual;
	
	@Column(name = "Periodo",nullable = false)
	private int Periodo;
	
	@Column(name = "AlDescuento",nullable = false)
	private double AlDescuento;
	
	@Column(name="LTCEA", length=10, nullable=false)
	private double LTCEA;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="idUsuario", nullable=false)
	private Usuario usuario;

	public Letra() {
		super();
	}

	public Letra(int idLetra, double importeLetra,
			@Future(message = "No se puede insertar esa fecha") Date fechaPagarLetra, double interesAnual,
			double moraAnual, int periodo, double alDescuento, double lTCEA, Usuario usuario) {
		super();
		this.idLetra = idLetra;
		ImporteLetra = importeLetra;
		FechaPagarLetra = fechaPagarLetra;
		InteresAnual = interesAnual;
		MoraAnual = moraAnual;
		Periodo = periodo;
		AlDescuento = alDescuento;
		LTCEA = lTCEA;
		this.usuario = usuario;
	}

	public int getIdLetra() {
		return idLetra;
	}

	public void setIdLetra(int idLetra) {
		this.idLetra = idLetra;
	}

	public double getImporteLetra() {
		return ImporteLetra;
	}

	public void setImporteLetra(double importeLetra) {
		ImporteLetra = importeLetra;
	}

	public Date getFechaPagarLetra() {
		return FechaPagarLetra;
	}

	public void setFechaPagarLetra(Date fechaPagarLetra) {
		FechaPagarLetra = fechaPagarLetra;
	}

	public double getInteresAnual() {
		return InteresAnual;
	}

	public void setInteresAnual(double interesAnual) {
		InteresAnual = interesAnual;
	}

	public double getMoraAnual() {
		return MoraAnual;
	}

	public void setMoraAnual(double moraAnual) {
		MoraAnual = moraAnual;
	}

	public void setMoraAnual(float moraAnual) {
		MoraAnual = moraAnual;
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

	public double getLTCEA() {
		return LTCEA;
	}

	public void setLTCEA(double lTCEA) {
		LTCEA = lTCEA;
	}
}
