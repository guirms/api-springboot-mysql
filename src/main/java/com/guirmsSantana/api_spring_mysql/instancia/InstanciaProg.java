package com.guirmsSantana.api_spring_mysql.instancia;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.guirmsSantana.api_spring_mysql.entidades.Categoria;
import com.guirmsSantana.api_spring_mysql.entidades.Produto;
import com.guirmsSantana.api_spring_mysql.repositorios.CategoriaRepositorio;
import com.guirmsSantana.api_spring_mysql.repositorios.ProdutoRepositorio;

@Configuration
@Profile("test")
public class InstanciaProg implements CommandLineRunner{

	@Autowired
	CategoriaRepositorio categoriaRepo;
	
	@Autowired
	ProdutoRepositorio produtoRepo;
	
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
	}
	
	

}
