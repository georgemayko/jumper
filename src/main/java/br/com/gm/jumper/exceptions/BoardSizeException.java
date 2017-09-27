package br.com.gm.jumper.exceptions;

public class BoardSizeException extends Exception{

    private static final long serialVersionUID = -2062284028360302466L;

    public BoardSizeException(String message) {
	super(message);
    }
}
