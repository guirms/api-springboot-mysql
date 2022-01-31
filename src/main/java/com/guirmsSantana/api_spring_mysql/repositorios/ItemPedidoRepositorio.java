package com.guirmsSantana.api_spring_mysql.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guirmsSantana.api_spring_mysql.entidades.ItemPedido;

@Repository
public interface ItemPedidoRepositorio extends JpaRepository<ItemPedido, Long> {

}
