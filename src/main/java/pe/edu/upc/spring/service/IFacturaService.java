package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Factura;

public interface IFacturaService {
	public boolean grabar(Factura factura);
	public void eliminar(int idFactura);
	public Optional<Factura> listarId(int idFactura);
	public List<Factura> listar();
	public List<Factura> BuscarFacturasConUsuarioId(int idUsuario);
}
