package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Letra;

public interface ILetraService {
	public boolean grabar(Letra letra);
	public void eliminar(int idLetra);
	public Optional<Letra> listarId(int idLetra);
	public List<Letra> listar();
	public List<Letra> BuscarLetrasConUsuarioId(int idUsuario);
}
