package com.guirmsSantana.api_spring_mysql.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guirmsSantana.api_spring_mysql.entidades.Pedido;
import com.guirmsSantana.api_spring_mysql.servico.PedidoServico;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoRecurso {

	@Autowired
	PedidoServico pedidoServ;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> encontrarTudo(){
		List<Pedido> pedido = pedidoServ.encontrarTudo();
		return ResponseEntity.ok(pedido);
	}
}
