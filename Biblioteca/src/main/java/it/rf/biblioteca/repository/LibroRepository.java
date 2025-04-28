package it.rf.biblioteca.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.rf.biblioteca.model.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer>{
	
	public Optional<Libro> findByTitoloLibro(String titoloLibro);
	

}
