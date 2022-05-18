package com.simplon.testApi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplon.testApi.model.Personne;
import com.simplon.testApi.repository.PersonneRepository;

import lombok.Data;

@Data
@Service
public class PersonneService {
	@Autowired
	private PersonneRepository personneRepository;
	
	public Optional<Personne> getPersonne(int id){
		return personneRepository.findById(id);
	}
	
	public Iterable<Personne> getPersonneAll(){
		return personneRepository.findAll();
	}
	
	public void deletePersonne(int id) {
		 personneRepository.deleteById(id);
	}
	
	public Personne savePersonne(Personne personne) {
		Personne p = personneRepository.save(personne);
		return p;
	}
}

