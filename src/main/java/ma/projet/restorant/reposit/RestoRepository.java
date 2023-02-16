package ma.projet.restorant.reposit;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ma.projet.restorant.entities.Resto;
import ma.projet.restorant.entities.Serie;
import ma.projet.restorant.entities.Zone;

public interface RestoRepository extends JpaRepository<Resto, Integer>{

	Resto findById(int id);
	
	@Query("select r from Resto r where r.nom = ?1")
	List<Resto> findByNom(String nom);

	@Query("select r from Resto r where r.adresse = ?1")
	List<Resto> findByAdresse(String adresse);
	
	@Query("select r from Resto r where r.rank = ?1 order by nom desc")
	List<Resto> findByRank(int rank);
	
	
	@Query("select r from Resto r where r.serie like ?1")
	List<Resto> findBySerie(Serie serie);
	
	@Query("select r from Resto r where r.zone =:zone")
	List<Resto> findZoneByVille(int zone);
	
}
