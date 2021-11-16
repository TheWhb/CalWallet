package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Factura")
public class Factura implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int factura_id;
	
	@Column(name = "sub_total",nullable = false)
	private double sub_total;
	
	@Column(name = "anticipos",nullable = false)
	private double anticipos;
	
	@Column(name = "descuentos",nullable = false)
	private double descuentos;
	
	@Column(name = "valor_venta",nullable = false)
	private double valor_venta;
	
	@Column(name = "ISC",nullable = false)
	private double ISC;
	
	@Column(name = "IGV",nullable = false)
	private double IGV;
	
	@Column(name = "otro_cargo",nullable = false)
	private double otro_cargo;
	
	@Column(name = "otro_tributo",nullable = false)
	private double otro_tributo;
	
	@Column(name = "importe_total",nullable = false)
	private double importe_total;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario", nullable = false)
	private Usuario usuario;

	public Factura() {
		super();
		
	}

	public Factura(int factura_id, double sub_total, double anticipos, double descuentos, double valor_venta,
			double iSC, double iGV, double otro_cargo, double otro_tributo, double importe_total, Usuario usuario) {
		super();
		this.factura_id = factura_id;
		this.sub_total = sub_total;
		this.anticipos = anticipos;
		this.descuentos = descuentos;
		this.valor_venta = valor_venta;
		ISC = iSC;
		IGV = iGV;
		this.otro_cargo = otro_cargo;
		this.otro_tributo = otro_tributo;
		this.importe_total = importe_total;
		this.usuario = usuario;
	}

	public int getFactura_id() {
		return factura_id;
	}

	public void setFactura_id(int factura_id) {
		this.factura_id = factura_id;
	}

	public double getSub_total() {
		return sub_total;
	}

	public void setSub_total(double sub_total) {
		this.sub_total = sub_total;
	}

	public double getAnticipos() {
		return anticipos;
	}

	public void setAnticipos(double anticipos) {
		this.anticipos = anticipos;
	}

	public double getDescuentos() {
		return descuentos;
	}

	public void setDescuentos(double descuentos) {
		this.descuentos = descuentos;
	}

	public double getValor_venta() {
		return valor_venta;
	}

	public void setValor_venta(double valor_venta) {
		this.valor_venta = valor_venta;
	}

	public double getISC() {
		return ISC;
	}

	public void setISC(double iSC) {
		ISC = iSC;
	}

	public double getIGV() {
		return IGV;
	}

	public void setIGV(double iGV) {
		IGV = iGV;
	}

	public double getOtro_cargo() {
		return otro_cargo;
	}

	public void setOtro_cargo(double otro_cargo) {
		this.otro_cargo = otro_cargo;
	}

	public double getOtro_tributo() {
		return otro_tributo;
	}

	public void setOtro_tributo(double otro_tributo) {
		this.otro_tributo = otro_tributo;
	}

	public double getImporte_total() {
		return importe_total;
	}

	public void setImporte_total(double importe_total) {
		this.importe_total = importe_total;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}