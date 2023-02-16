package ma.projet.restorant.reposit;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ma.projet.restorant.entities.Serie;

public interface SerieRepository extends JpaRepository<Serie, Integer>{

	Serie findById(int id);

	@Query("select s from Serie s where s.nom = :nom")
	List<Serie> findByNom(String nom);
	
}
