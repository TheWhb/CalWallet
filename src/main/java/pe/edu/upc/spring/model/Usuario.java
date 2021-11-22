package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Usuario")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	
	@Column(name="Username", length=20, nullable=false, unique=true)
	private String Username;
	
	@Column(name="Contraseña", length=20, nullable=false)
	private String Contraseña;
	
	@Column(name="Email", length=20, nullable=false)
	private int Email;
	
	@Column(name="RUC", length=11, nullable=false)
	private String RUC;
	
	@Column(name="TipoMoneda", length=10, nullable=false)
	private String Tipo_Moneda;
	
	@Column(name="TipoTasa", length=10, nullable=false)
	private String TipoTasa;
	
	@Column(name="UTCEA", length=10, nullable=false)
	private float UTCEA;

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(int idUsuario, String username, String contraseña, int email, String rUC, String tipo_Moneda,
			String tipoTasa, float uTCEA) {
		super();
		this.idUsuario = idUsuario;
		Username = username;
		Contraseña = contraseña;
		Email = email;
		RUC = rUC;
		Tipo_Moneda = tipo_Moneda;
		TipoTasa = tipoTasa;
		UTCEA = uTCEA;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getContraseña() {
		return Contraseña;
	}

	public void setContraseña(String contraseña) {
		Contraseña = contraseña;
	}

	public int getEmail() {
		return Email;
	}

	public void setEmail(int email) {
		Email = email;
	}

	public String getRUC() {
		return RUC;
	}

	public void setRUC(String rUC) {
		RUC = rUC;
	}

	public String getTipo_Moneda() {
		return Tipo_Moneda;
	}

	public void setTipo_Moneda(String tipo_Moneda) {
		Tipo_Moneda = tipo_Moneda;
	}

	public String getTipoTasa() {
		return TipoTasa;
	}

	public void setTipoTasa(String tipoTasa) {
		TipoTasa = tipoTasa;
	}

	public float getUTCEA() {
		return UTCEA;
	}

	public void setUTCEA(float uTCEA) {
		UTCEA = uTCEA;
	}
	
	
	
}
