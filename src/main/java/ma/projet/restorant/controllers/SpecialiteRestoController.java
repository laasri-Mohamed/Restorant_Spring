package ma.projet.restorant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.projet.restorant.entities.LigneSpecialite;
import ma.projet.restorant.entities.Serie;
import ma.projet.restorant.entities.Specialite;
import ma.projet.restorant.entities.Ville;
import ma.projet.restorant.entities.Zone;
import ma.projet.restorant.reposit.SpecialiteRestoRepository;

@RestController
@RequestMapping("ligneSpecialites")
public class SpecialiteRestoController {
	@Autowired
	private SpecialiteRestoRepository specialiteRestoRepository;

	@PostMapping("/save")
	public void save(@RequestBody LigneSpecialite ligneSpecialite) {
		specialiteRestoRepository.save(ligneSpecialite);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		LigneSpecialite s = specialiteRestoRepository.findById(Integer.parseInt(id));
		specialiteRestoRepository.delete(s);
	}

	@GetMapping("/all")
	public List<LigneSpecialite> findAll() {
		return specialiteRestoRepository.findAll();
	}

	@GetMapping(value = "/count")
	public long countResto() {
		return specialiteRestoRepository.count();
	}
	
	@GetMapping("/findbySpecId/{id}")
	public List<LigneSpecialite> findAllById(@PathVariable(required = false) String id){
		LigneSpecialite v = specialiteRestoRepository.findById(Integer.parseInt(id));
        return (List<LigneSpecialite>) v.getSpecialite();
    }

}
