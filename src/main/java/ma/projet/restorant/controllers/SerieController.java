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

import ma.projet.restorant.entities.Serie;
import ma.projet.restorant.reposit.SerieRepository;

@RestController
@RequestMapping("series")
public class SerieController {
	@Autowired
	private SerieRepository serieRepository;

	@PostMapping("/save")
	public void save(@RequestBody Serie Serie) {
		serieRepository.save(Serie);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		Serie s = serieRepository.findById(Integer.parseInt(id));
		serieRepository.delete(s);
	}

	@GetMapping("/all")
	public List<Serie> findAll() {
		return serieRepository.findAll();
	}

	@GetMapping(value = "/count")
	public long countResto() {
		return serieRepository.count();
	}
	
	@GetMapping("/byName/{nom}")
	public List<Serie> findByNom(@PathVariable(required = true) String nom) {
		return serieRepository.findByNom(nom);
	}
	
}
