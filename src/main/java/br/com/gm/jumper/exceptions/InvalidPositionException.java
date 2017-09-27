package br.com.gm.jumper.exceptions;

public class InvalidPositionException extends Exception {

    private static final long serialVersionUID = 5136890917570748317L;

    public InvalidPositionException(String message){
	super(message);
    }
}
