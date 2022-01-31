package com.guirmsSantana.api_spring_mysql.instancia;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.guirmsSantana.api_spring_mysql.entidades.Categoria;
import com.guirmsSantana.api_spring_mysql.entidades.ItemPedido;
import com.guirmsSantana.api_spring_mysql.entidades.Pedido;
import com.guirmsSantana.api_spring_mysql.entidades.Produto;
import com.guirmsSantana.api_spring_mysql.entidades.enums.StatusPedido;
import com.guirmsSantana.api_spring_mysql.repositorios.CategoriaRepositorio;
import com.guirmsSantana.api_spring_mysql.repositorios.ItemPedidoRepositorio;
import com.guirmsSantana.api_spring_mysql.repositorios.PedidoRepositorio;
import com.guirmsSantana.api_spring_mysql.repositorios.ProdutoRepositorio;

@Configuration
@Profile("test")
public class InstanciaProg implements CommandLineRunner{

	@Autowired
	CategoriaRepositorio categoriaRepo;
	
	@Autowired
	ProdutoRepositorio produtoRepo;
	
	@Autowired
	PedidoRepositorio pedidoRepo;
	
	@Autowired
	ItemPedidoRepositorio itemPedidoRepo;
	
	@Override
	public void run(String... args) throws Exception {
	
		Categoria cat1 = new Categoria(null, "Consoles");
		Categoria cat2 = new Categoria(null, "Controles");
		Categoria cat3 = new Categoria(null, "Jogos");
		
		categoriaRepo.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		Produto p1 = new Produto(null, "God Of War", 150.00);
		Produto p2 = new Produto(null, "Forza Horizon 5", 230.00);
		Produto p3 = new Produto(null, "Playstation 5", 5000.00);
		
		produtoRepo.saveAll(Arrays.asList(p1, p2, p3));
		
		p1.getCategoria().add(cat3);
		p2.getCategoria().add(cat3);
		p3.getCategoria().add(cat1);
		
		produtoRepo.saveAll(Arrays.asList(p1, p2, p3));
		
		Pedido pe1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), StatusPedido.RECEBIDO);
		Pedido pe2 = new Pedido(null, Instant.parse("2020-06-20T19:53:07Z"), StatusPedido.ENVIADO);
		
		pedidoRepo.saveAll(Arrays.asList(pe1, pe2));
		
		ItemPedido ip1 = new ItemPedido(p1, pe2, 2, p1.getPreco());
		
		itemPedidoRepo.saveAll(Arrays.asList(ip1));
		
	}

}
