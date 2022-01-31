package com.guirmsSantana.api_spring_mysql.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guirmsSantana.api_spring_mysql.entidades.Categoria;
import com.guirmsSantana.api_spring_mysql.servico.CategoriaServico;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaRecurso{

	@Autowired
	CategoriaServico categoriaServ;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> encontrarTudo(){
		List<Categoria> lista = categoriaServ.encontrarTudo();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> encontrarPorId(@PathVariable Long id){
		Categoria cat = categoriaServ.encontrarPorId(id);
		return ResponseEntity.ok(cat);
	}
	

}
