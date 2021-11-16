package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Letra;
import pe.edu.upc.spring.repository.ILetraRepository;
import pe.edu.upc.spring.service.ILetraService;

@Service
public class LetraServiceImpl implements ILetraService {

	@Autowired
	private ILetraRepository dLetra;
	
	@Override
	@Transactional
	public boolean grabar(Letra letra) {
		Letra objLetra = dLetra.save(letra);
		if (objLetra == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public void eliminar(int idLetra) {
		dLetra.deleteById(idLetra);		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Letra> listarId(int idLetra) {
		return dLetra.findById(idLetra);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Letra> listar() {
		return dLetra.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Letra> BuscarLetrasConUsuarioId(int idUsuario) {
		return dLetra.BuscarLetrasConUsuarioId(idUsuario);
	}


}
