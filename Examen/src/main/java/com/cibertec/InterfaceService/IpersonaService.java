package com.cibertec.InterfaceService;

import java.util.List;
import java.util.Optional;

import com.cibertec.modelo.Persona;

public interface IpersonaService {
      public List<Persona>listar();
      public Optional<Persona>listarId(int id);
      public int save(Persona p);
      public void delete(int id);
	
}
