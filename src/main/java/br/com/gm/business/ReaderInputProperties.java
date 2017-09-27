package br.com.gm.business;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import br.com.gm.business.excepction.InputInvalidException;
import br.com.gm.jumper.util.InputProperties;
import br.com.gm.jumper.util.PropertiesKey;

public class ReaderInputProperties {

    public InputProperties readInput() throws InputInvalidException{
	Properties prop = new Properties();
	InputStream input = null;

	try {

	    input = new FileInputStream((new File("input.properties")).getAbsoluteFile());
	    prop.load(input);

	    String boardSize = prop.getProperty(PropertiesKey.BOARD_SIZE);
	    String jumperMoves = prop.getProperty(PropertiesKey.JUMPER_MOVES);
	    String stones = prop.getProperty(PropertiesKey.STONES);
	    String startSquare = prop.getProperty(PropertiesKey.START_SQUARE_LOCATION);
	    String endSquare = prop.getProperty(PropertiesKey.END_SQUARE_LOCATION);

	    if(boardSize == null ||
		    jumperMoves== null ||
		    stones == null ||
		    startSquare == null ||
		    endSquare == null
		    ){
		throw new InputInvalidException();
	    }

	    return new InputProperties(boardSize, jumperMoves, stones, startSquare, endSquare);
	} catch (IOException ex) {
	    ex.printStackTrace();
	} finally {
	    if (input != null) {
		try {
		    input.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    }
	}
	return null;
    }
}