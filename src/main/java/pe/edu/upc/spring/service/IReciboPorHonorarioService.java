package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.ReciboPorHonorario;

public interface IReciboPorHonorarioService {
	public boolean grabar(ReciboPorHonorario reciboPorHonorario);
	public void eliminar(int idReciboPorHonorario);
	public Optional<ReciboPorHonorario> listarId(int idReciboPorHonorario);
	public List<ReciboPorHonorario> listar();
	public List<ReciboPorHonorario> BuscarRecibosConUsuarioId(int idUsuario);
}
