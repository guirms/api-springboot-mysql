package com.guirmsSantana.api_spring_mysql.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guirmsSantana.api_spring_mysql.entidades.Categoria;
import com.guirmsSantana.api_spring_mysql.exceptions.NaoEncontradoException;
import com.guirmsSantana.api_spring_mysql.repositorios.CategoriaRepositorio;

@Service
public class CategoriaServico {
	
	@Autowired
	CategoriaRepositorio categoriaRepo;

	public List<Categoria> encontrarTudo(){
		return categoriaRepo.findAll();
	}
	
	public Categoria encontrarPorId(Long id) {
		Optional<Categoria> optCat = categoriaRepo.findById(id);
		return optCat.orElseThrow(() -> new NaoEncontradoException(id));
	}

	
}
