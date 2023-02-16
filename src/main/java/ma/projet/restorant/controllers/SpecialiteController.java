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

import ma.projet.restorant.entities.Specialite;
import ma.projet.restorant.reposit.SpecialiteRepository;

@RestController
@RequestMapping("specialites")
public class SpecialiteController {
	@Autowired
	private SpecialiteRepository specialiteRepository;

	@PostMapping("/save")
	public void save(@RequestBody Specialite Specialite) {
		specialiteRepository.save(Specialite);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		Specialite s = specialiteRepository.findById(Integer.parseInt(id));
		specialiteRepository.delete(s);
	}

	@GetMapping("/all")
	public List<Specialite> findAll() {
		return specialiteRepository.findAll();
	}

	@GetMapping(value = "/count")
	public long countResto() {
		return specialiteRepository.count();
	}
	
	@GetMapping("/byName/{nom}")
	public List<Specialite> findByNom(@PathVariable(required = true) String nom) {
		return specialiteRepository.findByNom(nom);
	}
	
}
