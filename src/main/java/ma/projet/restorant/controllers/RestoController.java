package ma.projet.restorant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.projet.restorant.entities.Resto;
import ma.projet.restorant.entities.Serie;
import ma.projet.restorant.entities.Ville;
import ma.projet.restorant.entities.Zone;
import ma.projet.restorant.reposit.RestoRepository;
import ma.projet.restorant.reposit.VilleRepository;
import ma.projet.restorant.reposit.ZoneRepository;

@RestController
@RequestMapping("restos")
public class RestoController {
	@Autowired
	private RestoRepository restoRepository;
	@Autowired
	private ZoneRepository  zoneRepository;

	@PostMapping("/save")
	public void save(@RequestBody Resto Resto) {
		restoRepository.save(Resto);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		Resto s = restoRepository.findById(Integer.parseInt(id));
		restoRepository.delete(s);
	}

	@PutMapping("/update/{id}")
	public void update(@PathVariable(required = true) String id, @RequestBody Resto Rest) {
		//restoRepository.update(id, Rest);
	}
	
	@GetMapping("/all")
	public List<Resto> findAll() {
		return restoRepository.findAll();
	}

	@GetMapping(value = "/count")
	public long countResto() {
		return restoRepository.count();
	}
	
	@GetMapping("/name/{nom}")
	public List<Resto> findByNom(@RequestParam(required = false) String nom) {
		return restoRepository.findByNom(nom);
	}
	
	@GetMapping("/address/{adresse}")
	public List<Resto> findByAdresse(@RequestParam(required = false) String adresse) {
		return restoRepository.findByAdresse(adresse);
	}

	@GetMapping("/rank/{rank}")
	public List<Resto> findByRank(@RequestParam(required = false) Integer rank) {
		return restoRepository.findByRank(rank);
	}
	
	
	
	@GetMapping("/serie/{serie}")
	public List<Resto> findBySerie(@RequestParam(required = false) Serie serie) {
		return restoRepository.findBySerie(serie);
	}
	

	@GetMapping("/findByIdZone/{id}")
	public List<Resto> findAllById(@PathVariable(required = false) String id){
		Zone v = zoneRepository.findById(Integer.parseInt(id));
        return v.getRestos();
    }


}
