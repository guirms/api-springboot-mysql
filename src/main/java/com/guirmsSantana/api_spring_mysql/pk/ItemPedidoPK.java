package com.guirmsSantana.api_spring_mysql.pk;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.guirmsSantana.api_spring_mysql.entidades.Pedido;
import com.guirmsSantana.api_spring_mysql.entidades.Produto;

@Embeddable
public class ItemPedidoPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Produto produto;

	@ManyToOne
	private Pedido pedido;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pedido, produto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedidoPK other = (ItemPedidoPK) obj;
		return Objects.equals(pedido, other.pedido) && Objects.equals(produto, other.produto);
	}

}
