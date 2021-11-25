package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Factura;

@Repository
public interface IFacturaRepository extends JpaRepository<Factura, Integer>{
	@Query("SELECT f FROM Factura f LEFT JOIN FETCH f.usuario u where u.idUsuario = :id")
	List<Factura> BuscarFacturasConUsuarioId(@Param("id") int id);
}
