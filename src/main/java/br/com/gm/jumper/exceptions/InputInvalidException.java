package br.com.gm.jumper.exceptions;

import br.com.gm.jumper.util.PropertiesKey;

public class InputInvalidException extends Exception {
    
    private static final long serialVersionUID = 6573674009118115596L;
    
    private static String MSG = "Input file must have property keys as follows: \n"+
	    PropertiesKey.BOARD_SIZE +"\n"+
	    PropertiesKey.JUMPER_MOVES +"\n"+
	    PropertiesKey.STONES +"\n"+
	    PropertiesKey.START_SQUARE_LOCATION +"\n"+
	    PropertiesKey.END_SQUARE_LOCATION; 
    
    public InputInvalidException(){
	super(MSG);
    }
}
