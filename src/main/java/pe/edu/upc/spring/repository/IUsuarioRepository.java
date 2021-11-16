package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{
	@Query("from Usuario p where p.Username = :User and p.Contraseña = :Contra")
	List<Usuario> findByUsernameAndPassword(@Param("User")String Username, @Param("Contra")String Contraseña);

}
