package br.com.SpringComIonic;

import java.text.SimpleDateFormat;
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
import br.com.SpringComIonic.Entity.ItemPedido;
import br.com.SpringComIonic.Entity.Pagamento;
import br.com.SpringComIonic.Entity.PagamentoComBoleto;
import br.com.SpringComIonic.Entity.PagamentoComCartao;
import br.com.SpringComIonic.Entity.Pedido;
import br.com.SpringComIonic.Entity.Produto;
import br.com.SpringComIonic.Entity.enums.EstadoPagamento;
import br.com.SpringComIonic.Entity.enums.TipoCliente;
import br.com.SpringComIonic.Repository.CategoriaRepository;
import br.com.SpringComIonic.Repository.CidadeRepository;
import br.com.SpringComIonic.Repository.ClienteRepository;
import br.com.SpringComIonic.Repository.EnderecoRepository;
import br.com.SpringComIonic.Repository.EstadoRepository;
import br.com.SpringComIonic.Repository.ItemPedidoRepository;
import br.com.SpringComIonic.Repository.PagamentoRepository;
import br.com.SpringComIonic.Repository.PedidoRepository;
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
	@Autowired
	private PagamentoRepository pagamentoRepo;
	@Autowired
	private PedidoRepository pedidoRepo;
	@Autowired
	private ItemPedidoRepository itemPedidoRepo;
	
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
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy hh:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		pedidoRepo.save(Arrays.asList(ped1,ped2));
		pagamentoRepo.save(Arrays.asList(pagto1,pagto2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepo.save(Arrays.asList(ip1,ip2,ip3));
		
	}
}
