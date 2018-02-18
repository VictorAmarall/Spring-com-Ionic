package br.com.SpringComIonic.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.SpringComIonic.Entity.Categoria;
import br.com.SpringComIonic.Repository.CategoriaRepository;
import br.com.SpringComIonic.Service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository repo;
	
	
	public Categoria buscar(Integer id) {
		Categoria obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Não Encontrado! ID:" + id + " Tipo: " + Categoria.class.getName());
		}
		return obj;
	}
}
