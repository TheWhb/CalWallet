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
@Table(name="Factura")
public class Factura implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idFactura;
	
	@Column(name = "Sub_total",nullable = false)
	private double Sub_total;
	
	@Column(name = "Anticipos",nullable = false)
	private double Anticipos;
	
	@Column(name = "Descuentos",nullable = false)
	private double Descuentos;
	
	@Column(name = "Valor_venta",nullable = false)
	private double Valor_venta;
	
	@Column(name = "ISC",nullable = false)
	private double ISC;
	
	@Column(name = "IGV",nullable = false)
	private double IGV;
	
	@Column(name = "Otro_cargo",nullable = false)
	private double Otro_cargo;
	
	@Column(name = "Otro_tributo",nullable = false)
	private double Otro_tributo;
	
	@Column(name = "Importe_total",nullable = false)
	private double Importe_total;
	
	@Column(name = "Periodo",nullable = false)
	private int Periodo;
	
	@Column(name = "AlDescuento",nullable = false)
	private double AlDescuento;
	
	@Column(name="FTCEA", length=10, nullable=false)
	private double FTCEA;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUsuario", nullable = false)
	private Usuario usuario;

	public Factura() {
		super();
	}

	public Factura(int idFactura, double sub_total, double anticipos, double descuentos, double valor_venta, double iSC,
			double iGV, double otro_cargo, double otro_tributo, double importe_total, int periodo, double alDescuento,
			double fTCEA, Usuario usuario) {
		super();
		this.idFactura = idFactura;
		Sub_total = sub_total;
		Anticipos = anticipos;
		Descuentos = descuentos;
		Valor_venta = valor_venta;
		ISC = iSC;
		IGV = iGV;
		Otro_cargo = otro_cargo;
		Otro_tributo = otro_tributo;
		Importe_total = importe_total;
		Periodo = periodo;
		AlDescuento = alDescuento;
		FTCEA = fTCEA;
		this.usuario = usuario;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public double getSub_total() {
		return Sub_total;
	}

	public void setSub_total(double sub_total) {
		Sub_total = sub_total;
	}

	public double getAnticipos() {
		return Anticipos;
	}

	public void setAnticipos(double anticipos) {
		Anticipos = anticipos;
	}

	public double getDescuentos() {
		return Descuentos;
	}

	public void setDescuentos(double descuentos) {
		Descuentos = descuentos;
	}

	public double getValor_venta() {
		return Valor_venta;
	}

	public void setValor_venta(double valor_venta) {
		Valor_venta = valor_venta;
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
		return Otro_cargo;
	}

	public void setOtro_cargo(double otro_cargo) {
		Otro_cargo = otro_cargo;
	}

	public double getOtro_tributo() {
		return Otro_tributo;
	}

	public void setOtro_tributo(double otro_tributo) {
		Otro_tributo = otro_tributo;
	}

	public double getImporte_total() {
		return Importe_total;
	}

	public void setImporte_total(double importe_total) {
		Importe_total = importe_total;
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

	public double getFTCEA() {
		return FTCEA;
	}

	public void setFTCEA(double fTCEA) {
		FTCEA = fTCEA;
	}
}