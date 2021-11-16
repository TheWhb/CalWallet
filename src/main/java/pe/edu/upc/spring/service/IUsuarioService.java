package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Usuario;

public interface IUsuarioService {
	public boolean grabar(Usuario usuario);
	public Optional<Usuario> listarId(int idUsuario);
	public List<Usuario> listar();
	public List<Usuario> findByUsernameAndPassword(String Username, String Contraseña);

}
