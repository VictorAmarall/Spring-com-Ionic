package br.com.SpringComIonic.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.SpringComIonic.Entity.Pedido;
import br.com.SpringComIonic.Service.PedidoService;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoController {

	@Autowired
	PedidoService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Pedido cat1 = service.buscar(id);
		
		return ResponseEntity.ok(cat1);
	}
}
