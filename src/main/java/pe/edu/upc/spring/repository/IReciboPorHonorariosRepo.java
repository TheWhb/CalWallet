package pe.edu.upc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.ReciboPorHonorario;


@Repository
public interface IReciboPorHonorariosRepo extends JpaRepository<ReciboPorHonorario, Long>{

}
