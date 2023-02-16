package ma.projet.restorant.reposit;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ma.projet.restorant.entities.Specialite;

public interface SpecialiteRepository extends JpaRepository<Specialite, Integer>{
	
	Specialite findById(int id);
	
	@Query("select s from Specialite s where s.nom = :nom")
	List<Specialite> findByNom(String nom);
}
