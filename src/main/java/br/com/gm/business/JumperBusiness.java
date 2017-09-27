package br.com.gm.business;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import br.com.gm.jumper.exceptions.BoardSizeException;
import br.com.gm.jumper.exceptions.InputParseException;
import br.com.gm.jumper.exceptions.InvalidPositionException;
import br.com.gm.jumper.exceptions.JumperPositionInvalidException;
import br.com.gm.jumper.exceptions.NoMovesException;
import br.com.gm.jumper.model.Board;
import br.com.gm.jumper.model.Jumper;
import br.com.gm.jumper.model.Move;
import br.com.gm.jumper.model.Position;
import br.com.gm.jumper.model.Stone;
import br.com.gm.jumper.model.XYAxis;
import br.com.gm.jumper.util.InputProperties;
import br.com.gm.jumper.util.StringToCoordenateConverter;

public class JumperBusiness {
    
    private Board board;
    private Position startPosition;
    private Position endPosition;
    private List<Position> stones; 

    public void createScenario(InputProperties input) throws NumberFormatException, BoardSizeException, NoMovesException, InvalidPositionException, JumperPositionInvalidException, InputParseException{
	try{
	    Logger.log("--------Parsing inputs---------");
	    int boarSize =  Integer.parseInt(input.getBoardSize());
	    Board board = new Board(boarSize);
	    
	    Set<Move> moves = StringToCoordenateConverter.convertToSet(input.getJumperMoves(), Move.class);
	    Logger.logValidadInputs("Parsed MOVES", moves);
	    
	    Set<XYAxis> stoneXyAxisList = StringToCoordenateConverter.convertToSet(input.getStones(), XYAxis.class);
	    Logger.logValidadInputs("Parsed STONES", stoneXyAxisList);

	    XYAxis startLocation = StringToCoordenateConverter.convert(input.getStartSquareLocation(), XYAxis.class);
	    Logger.logValidadInputs("Parsed START LOCATION", Arrays.asList(startLocation));
	    
	    XYAxis endLocation = StringToCoordenateConverter.convert(input.getEndSquareLocation(), XYAxis.class);
	    Logger.logValidadInputs("Parsed END LOCATION", Arrays.asList(endLocation));
	    
	    Jumper jumper = new Jumper(new Position(startLocation), moves.toArray(new Move[moves.size()]));
	    stoneXyAxisList.forEach(xyAxis -> {
		try {
		    board.addStone(new Stone(xyAxis));
		} catch (InvalidPositionException e) {
		    System.err.println("Discarding Stone at "+ xyAxis.getLocation());
		}
	    });
	    board.addJumper(jumper);
	}catch (NumberFormatException  e) {
	    throw new InputParseException(input.getBoardSize()); 
	}catch (BoardSizeException e) {
	    throw new InputParseException(e.getMessage());
	}
    }
    
    
    
}
