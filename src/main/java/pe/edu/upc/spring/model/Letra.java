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
	
	@Temporal(TemporalType.DATE)
	@Column(name ="FechaPagarLetra")
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	private Date FechaPagarLetra;
	
	@Column(name="InteresAnual", length = 10, nullable=false)
	private float InteresAnual;
	
	@Column(name="MoraAnual", length = 10, nullable=false)
	private float MoraAnual;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="idUsuario", nullable=false)
	private Usuario usuario;

	public Letra() {
		super();
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

	public float getInteresAnual() {
		return InteresAnual;
	}

	public void setInteresAnual(float interesAnual) {
		InteresAnual = interesAnual;
	}

	public float getMoraAnual() {
		return MoraAnual;
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
	
}
