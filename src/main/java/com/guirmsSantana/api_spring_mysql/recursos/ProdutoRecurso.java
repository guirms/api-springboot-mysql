package com.guirmsSantana.api_spring_mysql.recursos;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		return ResponseEntity.ok(produto);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Produto> encontrarPorId(@PathVariable Long id){
		Produto produto = produtoServ.encontrarPorId(id);
		return ResponseEntity.ok(produto);
	}
	
	@PostMapping
	public ResponseEntity<Produto> inserir(@RequestBody Produto produto){
		produtoServ.inserir(produto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(produto.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		produtoServ.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody Produto produto){
		Produto prod = produtoServ.atualizar(id, produto);
		return ResponseEntity.ok(prod);
	}
}