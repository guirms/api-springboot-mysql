package com.guirmsSantana.api_spring_mysql.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guirmsSantana.api_spring_mysql.entidades.Produto;
import com.guirmsSantana.api_spring_mysql.servico.ProdutoServico;

@RestController
@RequestMapping(value="/produtos")

public class ProdutoRecurso {
	
	@Autowired
	ProdutoServico produtoServ;
	
	@GetMapping
	public ResponseEntity<List<Produto>> encontrarTudo(){
		List<Produto> produto = produtoServ.encontrarTudo();
		return ResponseEntity.ok().body(produto);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Produto> encontrarPorId(@PathVariable Long id){
		Produto produto = produtoServ.encontrarPorId(id);
		return ResponseEntity.ok().body(produto);
	}

}
