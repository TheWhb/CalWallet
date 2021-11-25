package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.ReciboPorHonorario;

@Repository
public interface IReciboPorHonorariosRepo extends JpaRepository<ReciboPorHonorario, Integer>{
	@Query("SELECT r FROM ReciboPorHonorario r LEFT JOIN FETCH r.usuario u where u.idUsuario = :id")
	List<ReciboPorHonorario> BuscarRecibosConUsuarioId(@Param("id") int id);
}
