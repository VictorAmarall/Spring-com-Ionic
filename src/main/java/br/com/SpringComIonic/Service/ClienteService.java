package br.com.SpringComIonic.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.SpringComIonic.Entity.Cliente;
import br.com.SpringComIonic.Repository.ClienteRepository;
import br.com.SpringComIonic.Service.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository repo;
	
	
	public Cliente buscar(Integer id) {
		Cliente obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Não Encontrado! ID:" + id + " Tipo: " + Cliente.class.getName());
		}
		return obj;
	}
}
