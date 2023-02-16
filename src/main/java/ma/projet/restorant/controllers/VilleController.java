package ma.projet.restorant.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.projet.restorant.entities.Ville;
import ma.projet.restorant.reposit.VilleRepository;

@RestController
@RequestMapping("villes")
public class VilleController {
	@Autowired
	private VilleRepository villeRepository;

	@PostMapping("/save")
	public void save(@RequestBody Ville Ville) {
		villeRepository.save(Ville);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		Ville s = villeRepository.findById(Integer.parseInt(id));
		villeRepository.delete(s);
	}
	@GetMapping("/findById/{id}")
	public Ville findById(@PathVariable(required = true) String id) {
		return villeRepository.findById(Integer.parseInt(id));
	}

	@GetMapping("/all")
	public List<Ville> findAll() {
		return villeRepository.findAll();
	}

	@GetMapping(value = "/count")
	public long countVille() {
		return villeRepository.count();
	}
	
	@GetMapping("/byName/{nom}")
	public List<Ville> findByNom(@Param(value = "nom") String nom) {
		return villeRepository.findByNom(nom);
	}
	
	
}
