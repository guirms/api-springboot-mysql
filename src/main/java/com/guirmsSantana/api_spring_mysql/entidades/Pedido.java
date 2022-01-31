package com.guirmsSantana.api_spring_mysql.entidades;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.guirmsSantana.api_spring_mysql.entidades.enums.StatusPedido;

@Entity
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant momento;

	private Integer statusPedido;

	@OneToMany(mappedBy = "itemPK.pedido")
	private Set<ItemPedido> itens = new HashSet<>();

	public Pedido() {
	}

	public Pedido(Long id, Instant momento, StatusPedido statusPedido) {
		this.id = id;
		this.momento = momento;
		setStatusPedido(statusPedido);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}

	public StatusPedido getStatusPedido() {
		return StatusPedido.valorDe(statusPedido);
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		if (statusPedido != null) {
			this.statusPedido = statusPedido.getCodigoEnum();
		}
	}

	public Set<ItemPedido> getItens() {
		return itens;
	}

	public Double getTotalPedido() {
		double total = 0.0;
		for (ItemPedido x : itens) {
			total += x.getSubTotalPedido();
		}
		return total;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}

}
