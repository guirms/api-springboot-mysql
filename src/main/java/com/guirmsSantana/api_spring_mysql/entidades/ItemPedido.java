package com.guirmsSantana.api_spring_mysql.entidades;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.guirmsSantana.api_spring_mysql.pk.ItemPedidoPK;

@Entity
public class ItemPedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ItemPedidoPK itemPK = new ItemPedidoPK();

	private Integer quantidade;

	private Double preco;

	public ItemPedido() {
	}

	public ItemPedido(Produto produto, Pedido pedido, Integer quantidade, Double preco) {
		itemPK.setProduto(produto);
		itemPK.setPedido(pedido);
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	public Produto getProduto() {
		return itemPK.getProduto();
	}
	
	public void setProduto(Produto produto) {
		itemPK.setProduto(produto);
	}
	
	@JsonIgnore
	public Pedido getPedido() {
		return itemPK.getPedido();
	}
	
	public void setPedido(Pedido pedido) {
		itemPK.setPedido(pedido);
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public Double getSubTotalPedido() { //pq na plataforma java enterprise, o que vale é o get
		return preco * quantidade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemPK);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		return Objects.equals(itemPK, other.itemPK);
	}

}
