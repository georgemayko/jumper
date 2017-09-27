package br.com.gm.jumper.exceptions;

public class InputParseException extends Exception {

    private static final long serialVersionUID = 1276647167428334617L;
    
    private static String MSG_PREFIX = "Input invalid: ";

    public InputParseException(String message) {
	super(MSG_PREFIX + message);
    }

}
