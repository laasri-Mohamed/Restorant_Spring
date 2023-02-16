package ma.projet.restorant.reposit;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ma.projet.restorant.entities.Ville;
import ma.projet.restorant.entities.Zone;

public interface ZoneRepository extends JpaRepository<Zone, Integer> {

	Zone findById(int id);

	@Query("select s from Zone s where s.nom = :nom")
	List<Zone> findByNom(String nom);

	@Query("select z from Zone z where z.ville =:ville")
	List<Zone> findZoneByVille(int ville);

}
