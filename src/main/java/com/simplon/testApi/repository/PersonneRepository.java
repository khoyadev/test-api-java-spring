package com.simplon.testApi.repository;

import org.springframework.data.repository.CrudRepository;

import com.simplon.testApi.model.Personne;

public interface PersonneRepository extends CrudRepository<Personne, Integer>{

}
