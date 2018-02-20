package br.com.SpringComIonic.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.SpringComIonic.Entity.Pedido;
import br.com.SpringComIonic.Repository.PedidoRepository;
import br.com.SpringComIonic.Service.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository repo;
	
	
	public Pedido buscar(Integer id) {
		Pedido obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Não Encontrado! ID:" + id + " Tipo: " + Pedido.class.getName());
		}
		return obj;
	}
}
