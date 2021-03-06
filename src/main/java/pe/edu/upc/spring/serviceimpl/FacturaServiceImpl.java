package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Factura;
import pe.edu.upc.spring.repository.IFacturaRepository;
import pe.edu.upc.spring.service.IFacturaService;

@Service
public class FacturaServiceImpl implements IFacturaService {
	
	@Autowired
	private IFacturaRepository dFactura;
	
	@Override
	@Transactional
	public boolean grabar(Factura factura) {
		Factura objFactura= dFactura.save(factura);
		if (objFactura == null)
			return false;
		else
			return true;
	}
	
	@Override
	@Transactional
	public void eliminar(int idFactura) {
		dFactura.deleteById(idFactura);		
	}
	
	@Override
	@Transactional(readOnly=true)
	public Optional<Factura> listarId(int factura_id)  {
		return dFactura.findById(factura_id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Factura> listar() {
		return dFactura.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Factura> BuscarFacturasConUsuarioId(int idUsuario) {
		return dFactura.BuscarFacturasConUsuarioId(idUsuario);
	}
	
	
}
