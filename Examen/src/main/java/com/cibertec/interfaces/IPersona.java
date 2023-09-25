package com.cibertec.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.modelo.Persona;

@Repository
public interface IPersona extends CrudRepository<Persona, Integer>{

}
