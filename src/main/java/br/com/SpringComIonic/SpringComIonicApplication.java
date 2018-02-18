package br.com.SpringComIonic;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.SpringComIonic.Entity.Categoria;
import br.com.SpringComIonic.Entity.Cidade;
import br.com.SpringComIonic.Entity.Cliente;
import br.com.SpringComIonic.Entity.Endereco;
import br.com.SpringComIonic.Entity.Estado;
import br.com.SpringComIonic.Entity.Produto;
import br.com.SpringComIonic.Entity.enums.TipoCliente;
import br.com.SpringComIonic.Repository.CategoriaRepository;
import br.com.SpringComIonic.Repository.CidadeRepository;
import br.com.SpringComIonic.Repository.ClienteRepository;
import br.com.SpringComIonic.Repository.EnderecoRepository;
import br.com.SpringComIonic.Repository.EstadoRepository;
import br.com.SpringComIonic.Repository.ProdutoRepository;

@SpringBootApplication
public class SpringComIonicApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepo;
	@Autowired
	private ProdutoRepository produtoRepo;
	@Autowired
	private EstadoRepository estadoRepo;
	@Autowired
	private CidadeRepository cidadeRepo;
	@Autowired
	private EnderecoRepository enderecoRepo;
	@Autowired
	private ClienteRepository clienteRepo;
	
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
		
		categoriaRepo.save(Arrays.asList(cat1,cat2));
		produtoRepo.save(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepo.save(Arrays.asList(est1,est2));
		cidadeRepo.save(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null, "Maria", "maria@gmail.com", "232139988", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("321231231","2131232134"));
		
		Endereco e1 = new Endereco(null, "Rua Flores","300" ,"Apto 303","Jardim", "31244", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida MAtos","105" ,"Sala 800","Centro", "765432", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepo.save(Arrays.asList(cli1));
		enderecoRepo.save(Arrays.asList(e1,e2));
		
		
		
	}
}
