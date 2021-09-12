package com.thiagowill.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.thiagowill.cursomc.domain.Categoria;
import com.thiagowill.cursomc.domain.Cidade;
import com.thiagowill.cursomc.domain.Cliente;
import com.thiagowill.cursomc.domain.Endereco;
import com.thiagowill.cursomc.domain.Estado;
import com.thiagowill.cursomc.domain.Produto;
import com.thiagowill.cursomc.domain.enums.TipoCliente;
import com.thiagowill.cursomc.repositories.CategoriaRepository;
import com.thiagowill.cursomc.repositories.CidadeRepository;
import com.thiagowill.cursomc.repositories.ClienteRepository;
import com.thiagowill.cursomc.repositories.EnderecoRepository;
import com.thiagowill.cursomc.repositories.EstadoRepository;
import com.thiagowill.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Categoria cat1 = new Categoria(null,"Informatica");
		Categoria cat2 = new Categoria(null,"Escritório");
		
		Produto p1 =  new Produto(null,"Computador",2000.00);
		Produto p2 =  new Produto(null,"Impressora",800.00);
		Produto p3 =  new Produto(null,"Mouse",80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "UberLândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null,"Maria Silva","Maria@gmail.com","44455566678",TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("987271212","98665532"));
		
		Endereco e1 =  new Endereco(null, "Rua Flores", "141", "Casa Fundo", "Santa Cruz", "13272404", cli1, c1);
		Endereco e2 =  new Endereco(null, "Rua José C", "43", "Ap", "Jacarei", "13272505", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
	}

}
