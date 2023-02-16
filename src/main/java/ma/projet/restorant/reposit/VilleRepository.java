package ma.projet.restorant.reposit;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ma.projet.restorant.entities.Ville;

public interface VilleRepository extends JpaRepository<Ville, Integer> {

	Ville findById(int id);

	@Query("select v from Ville v where v.nom = :nom")
	List<Ville> findByNom(String nom);
}
