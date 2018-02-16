package br.com.SpringComIonic.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.SpringComIonic.Entity.Categoria;
import br.com.SpringComIonic.Service.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaController {

	@Autowired
	CategoriaService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Categoria cat1 = service.buscar(id);
		
		return ResponseEntity.ok(cat1);
	}
}
