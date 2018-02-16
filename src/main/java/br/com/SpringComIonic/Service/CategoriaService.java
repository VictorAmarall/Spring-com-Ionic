package br.com.SpringComIonic.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.SpringComIonic.Entity.Categoria;
import br.com.SpringComIonic.Repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository repo;
	
	
	public Categoria buscar(Integer id) {
		
		Categoria obj = repo.findOne(id);
		return obj;
	}
}
