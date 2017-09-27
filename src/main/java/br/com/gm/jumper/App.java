package br.com.gm.jumper;

import br.com.gm.business.JumperBusiness;
import br.com.gm.business.Logger;
import br.com.gm.business.ReaderInputProperties;
import br.com.gm.business.excepction.InputInvalidException;
import br.com.gm.jumper.exceptions.BoardSizeException;
import br.com.gm.jumper.exceptions.InputParseException;
import br.com.gm.jumper.exceptions.InvalidPositionException;
import br.com.gm.jumper.exceptions.JumperPositionInvalidException;
import br.com.gm.jumper.exceptions.NoMovesException;
import br.com.gm.jumper.model.Result;
import br.com.gm.jumper.util.InputProperties;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws BoardSizeException, NumberFormatException, NoMovesException, InvalidPositionException, JumperPositionInvalidException
    {	
	
	try{
	    InputProperties input = new ReaderInputProperties().readInput();
	     JumperBusiness business = new JumperBusiness();
	     business.createScenario(input);
	     Result result =business.process();
	     Logger.logResult(result);
	}catch (InputParseException | InputInvalidException e) {
	    System.err.println(e.getMessage());
	};
    }
}
