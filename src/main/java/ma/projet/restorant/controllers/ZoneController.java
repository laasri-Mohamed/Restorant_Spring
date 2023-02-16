package ma.projet.restorant.controllers;


import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.projet.restorant.entities.Ville;
import ma.projet.restorant.entities.Zone;
import ma.projet.restorant.reposit.VilleRepository;
import ma.projet.restorant.reposit.ZoneRepository;

@RestController
@RequestMapping("zones")
public class ZoneController {
	@Autowired
	private ZoneRepository zoneRepository;
	@Autowired
	private VilleRepository  villeRepository;

	@PostMapping("/save")
	public void save(@RequestBody Zone Zone) {
		zoneRepository.save(Zone);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		Zone s = zoneRepository.findById(Integer.parseInt(id));
		zoneRepository.delete(s);
	}

	@GetMapping("/all")
	public List<Zone> findAll() {
		return zoneRepository.findAll();
	}

	@GetMapping(value = "/count")
	public long countResto() {
		return zoneRepository.count();
	}

	@GetMapping("/byName")
	public List<Zone> findByNom(@RequestParam(required = false) String nom) {
		return zoneRepository.findByNom(nom);
	}

	@GetMapping("/findById/{id}")
	public Zone findById(@PathVariable(required = true) String id) {
		return zoneRepository.findById(Integer.parseInt(id));
	}

	@GetMapping("/findByIdVille/{id}")
	public List<Zone> findAllById(@PathVariable(required = false) String id){
		Ville v = villeRepository.findById(Integer.parseInt(id));
        return v.getZones();
    }

	
}
