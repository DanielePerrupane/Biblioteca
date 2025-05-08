package it.rf.biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.rf.biblioteca.DTO.PrenotazioneDTO;
import it.rf.biblioteca.model.Prenotazione;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer>{
	
	@Query(value="SELECT prenotazione.id_prenotazione,prenotazione.data_inizio_prenotazione, prenotazione.data_fine_prenotazione, prenotazione.acconto, prenotazione.totale, prenotazione.cf_cliente, libro.titolo_libro\n"
			+ "from prenotazione join comprende on prenotazione.id_prenotazione=comprende.id_prenotazione\n"
			+ "join libro on comprende.id_libro=libro.id_libro order by prenotazione.id_prenotazione", nativeQuery=true)
	public List<PrenotazioneDTO> prendiListaPrenotazioni();

}
