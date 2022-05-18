package com.simplon.testApi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplon.testApi.model.Personne;
import com.simplon.testApi.service.PersonneService;

@RestController
public class PersonneController {
	@Autowired
	private PersonneService personneService;
	
	@GetMapping("/personnes")
	public Iterable<Personne> getPersonnes(){
		return personneService.getPersonneAll();
	}
	
	@PostMapping("/personne")
	public Personne createPersonne(@RequestBody Personne personne) {
		return personneService.savePersonne(personne);
	}
	
	@GetMapping("/personne/{id}")
	public Optional<Personne> getPersonne(@PathVariable("id") int id) {
		return personneService.getPersonne(id);
	}
	
	@DeleteMapping("/personne/{id}")
	public void deletePersonne(@PathVariable("id") int id){
		personneService.deletePersonne(id);
	}
	
	@RequestMapping("/personne/{id}")
	public Personne updatePersonne(@PathVariable("id") int id, @RequestBody Personne personne) {
		Optional<Personne> personneRechercher = personneService.getPersonne(id);
		if (personneRechercher.isPresent()) {
			Personne personneupdate = personneRechercher.get();
			String nom = personne.getNom();
			if (nom != null) {
				personneupdate.setNom(nom);
			}
			String prenom = personne.getPrenom();
			if (prenom != null) {
				personneupdate.setPrenom(prenom);
			}
			int age = personne.getAge();
			if (age >=0) {
				personneupdate.setAge(age);
			}
			personneService.savePersonne(personneupdate);
			return personneupdate;
		}else {
			return null;
		}
	}
}
