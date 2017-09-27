package br.com.gm.jumper;

import br.com.gm.business.JumperBusiness;
import br.com.gm.business.ReaderInputProperties;
import br.com.gm.jumper.exceptions.BoardSizeException;
import br.com.gm.jumper.exceptions.InputParseException;
import br.com.gm.jumper.exceptions.InvalidPositionException;
import br.com.gm.jumper.exceptions.JumperPositionInvalidException;
import br.com.gm.jumper.exceptions.NoMovesException;
import br.com.gm.jumper.util.InputProperties;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws BoardSizeException, NumberFormatException, NoMovesException, InvalidPositionException, JumperPositionInvalidException
    {
	InputProperties input = new ReaderInputProperties().readInput();
	try{
	    new JumperBusiness().createScenario(input);
	}catch (InputParseException e) {
	    System.err.println(e.getMessage());
	};
    }
}
