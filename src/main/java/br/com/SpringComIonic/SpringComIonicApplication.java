package br.com.SpringComIonic;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.SpringComIonic.Entity.Categoria;
import br.com.SpringComIonic.Entity.Produto;
import br.com.SpringComIonic.Repository.CategoriaRepository;
import br.com.SpringComIonic.Repository.ProdutoRepository;

@SpringBootApplication
public class SpringComIonicApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository CategoriaRepo;
	@Autowired
	private ProdutoRepository ProdutoRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringComIonicApplication.class, args);
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		CategoriaRepo.save(Arrays.asList(cat1,cat2));
		ProdutoRepo.save(Arrays.asList(p1,p2,p3));
		
	}
}
