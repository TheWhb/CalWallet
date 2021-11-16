package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;


import pe.edu.upc.spring.model.Factura;

public interface IFacturaService {

	public boolean guardar(Factura factura);
	public Optional<Factura> listarId(int factura_id);
	public List<Factura> listar();
}
