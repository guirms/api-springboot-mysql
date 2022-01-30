package com.guirmsSantana.api_spring_mysql.servico;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.guirmsSantana.api_spring_mysql.entidades.Produto;
import com.guirmsSantana.api_spring_mysql.exceptions.BancoDeDadosException;
import com.guirmsSantana.api_spring_mysql.exceptions.NaoEncontradoException;
import com.guirmsSantana.api_spring_mysql.repositorios.ProdutoRepositorio;

@Service
public class ProdutoServico {

	@Autowired
	ProdutoRepositorio produtoRepo;

	public List<Produto> encontrarTudo() {
		return produtoRepo.findAll();
	}

	public Produto encontrarPorId(Long id) {
		Optional<Produto> optProd = produtoRepo.findById(id);
		return optProd.orElseThrow(() -> new NaoEncontradoException(id));
	}

	public Produto inserir(Produto produto) {
		return produtoRepo.save(produto);
	}

	public void deletar(Long id) {
		try {
			produtoRepo.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new NaoEncontradoException(id);
		} catch (DataIntegrityViolationException e) {
			throw new BancoDeDadosException(e.getMessage());
		}
	}

	public Produto atualizar(Long id, Produto produto) {
		try {
			Produto prod = produtoRepo.getById(id);
			atualizarDados(prod, produto);
			return produtoRepo.save(prod);
		} catch (EntityNotFoundException e) {
			throw new NaoEncontradoException(id);
		}
	}

	private void atualizarDados(Produto prod, Produto produto) {
		prod.setNome(produto.getNome());
		prod.setPreco(produto.getPreco());		
	}
}
