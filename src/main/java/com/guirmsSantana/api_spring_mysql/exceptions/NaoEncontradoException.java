package com.guirmsSantana.api_spring_mysql.exceptions;

public class NaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NaoEncontradoException(Object id) {
		super("Id " + id + " não encontrado");
	}
	

}
