package com.guirmsSantana.api_spring_mysql.entidades.enums;

public enum StatusPedido {
	
	AGUARDANDO_PAGAMENTO(1),
	PAGO(2),
	ENVIADO(3),
	RECEBIDO(4),
	CANCELADO(5);
	
	private int codigoEnum;
	
	private StatusPedido(int codigoEnum) {
		this.codigoEnum = codigoEnum;
	}
	
	public int getCodigoEnum() {
		return codigoEnum;
	}
	
	public static StatusPedido valorDe(int valor) {
		for(StatusPedido codigo : StatusPedido.values()) {
			if (codigo.getCodigoEnum() == valor) {
				return codigo;
			}
		}
		throw new IllegalArgumentException("Código de busca inválido");
	}
	

}
