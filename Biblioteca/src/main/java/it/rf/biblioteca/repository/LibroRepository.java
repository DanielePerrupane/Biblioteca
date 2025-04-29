package it.rf.biblioteca.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.rf.biblioteca.DTO.LibroDTO;
import it.rf.biblioteca.model.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer>{
	
	public Optional<Libro> findByTitoloLibro(String titoloLibro);
	
	@Query(value=
			"select libro.autore_libro,libro.titolo_libro,libro.costo_giornaliero,genere.nome_genere from prenotazione \n"
			+ "join comprende on prenotazione.id_prenotazione=comprende.id_prenotazione\n"
			+ "join libro on comprende.id_libro=libro.id_libro\n"
			+ "join genere on libro.id_genere=genere.id_genere\n"
			+ "where prenotazione.cf_cliente= ?1",nativeQuery = true)
	public List<LibroDTO> listaLibriPrenotati(String cfCliente);
	

}
