package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Letra;

@Repository
public interface ILetraRepository extends JpaRepository<Letra, Integer>{
	@Query("SELECT l FROM Letra l LEFT JOIN FETCH l.usuario u where u.idUsuario = :id")
	List<Letra> BuscarLetrasConUsuarioId(@Param("id") int id);
}
