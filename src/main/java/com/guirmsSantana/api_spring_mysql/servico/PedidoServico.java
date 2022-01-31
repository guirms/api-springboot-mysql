package com.guirmsSantana.api_spring_mysql.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guirmsSantana.api_spring_mysql.entidades.Pedido;
import com.guirmsSantana.api_spring_mysql.exceptions.NaoEncontradoException;
import com.guirmsSantana.api_spring_mysql.repositorios.PedidoRepositorio;

@Service
public class PedidoServico {

	@Autowired
	PedidoRepositorio pedidoRepo;

	public List<Pedido> encontrarTudo() {
		return pedidoRepo.findAll();
	}

	public Pedido encontrarPorId(Long id) {
		Optional<Pedido> optPedido = pedidoRepo.findById(id);
		return optPedido.orElseThrow(() -> new NaoEncontradoException(id));
	}

}
