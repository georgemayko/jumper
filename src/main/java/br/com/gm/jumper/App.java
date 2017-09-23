package br.com.gm.jumper;

import br.com.gm.business.JumperBusiness;
import br.com.gm.business.ReaderInputProperties;
import br.com.gm.jumper.exceptions.BoardSizeException;
import br.com.gm.jumper.util.InputProperties;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws BoardSizeException
    {
	InputProperties input = new ReaderInputProperties().readInput();
	new JumperBusiness().createScenario(input);
	
    }
}
