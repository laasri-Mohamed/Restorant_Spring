package ma.projet.restorant.reposit;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ma.projet.restorant.entities.LigneSpecialite;
import ma.projet.restorant.entities.Serie;

public interface SpecialiteRestoRepository extends JpaRepository<LigneSpecialite, Integer>{

	LigneSpecialite findById(int id);


	
}
