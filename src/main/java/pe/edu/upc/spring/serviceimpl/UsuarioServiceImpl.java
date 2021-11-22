package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Usuario;
import pe.edu.upc.spring.repository.IUsuarioRepository;
import pe.edu.upc.spring.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	private IUsuarioRepository dUsuario;
	
	@Override
	@Transactional
	public boolean grabar(Usuario usuario) {
		Usuario objUsuario = dUsuario.save(usuario);
		if (objUsuario == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> listarId(int idUsuario) {
		return dUsuario.findById(idUsuario);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> listar() {
		return dUsuario.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Usuario> findByUsernameAndPassword(String Username, String Contraseña) {
		return dUsuario.findByUsernameAndPassword(Username, Contraseña);
	}
}
