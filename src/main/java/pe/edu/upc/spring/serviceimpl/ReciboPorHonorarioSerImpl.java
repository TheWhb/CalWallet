package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.ReciboPorHonorario;
import pe.edu.upc.spring.repository.IReciboPorHonorariosRepo;
import pe.edu.upc.spring.service.IReciboPorHonorarioService;

@Service
public class ReciboPorHonorarioSerImpl implements IReciboPorHonorarioService{

	@Autowired
	private IReciboPorHonorariosRepo dRecibo;
	
	@Override
	@Transactional
	public boolean grabar(ReciboPorHonorario reciboPorHonorario) {
		ReciboPorHonorario objRecibo = dRecibo.save(reciboPorHonorario);
		if (objRecibo == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public void eliminar(int idRecibo) {
		dRecibo.deleteById(idRecibo);		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<ReciboPorHonorario> listarId(int idRecibo) {
		return dRecibo.findById(idRecibo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReciboPorHonorario> listar() {
		return dRecibo.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReciboPorHonorario> BuscarRecibosConUsuarioId(int idUsuario) {
		return dRecibo.BuscarRecibosConUsuarioId(idUsuario);
	}


}
