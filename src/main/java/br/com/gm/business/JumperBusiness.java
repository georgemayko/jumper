package br.com.gm.business;

import java.util.Arrays;
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
import br.com.gm.jumper.model.Result;
import br.com.gm.jumper.model.Stone;
import br.com.gm.jumper.model.XYAxis;
import br.com.gm.jumper.util.InputProperties;
import br.com.gm.jumper.util.StringToCoordenateConverter;

public class JumperBusiness {
    
    private Board board;
    private Position startPosition;
    private Position endPosition;
     
    public void createScenario(InputProperties input) throws InputParseException{
	try{
	    Logger.log("--------Parsing inputs---------");
	    int boarSize =  Integer.parseInt(input.getBoardSize());
	    
	    Set<Move> moves = StringToCoordenateConverter.convertToSet(input.getJumperMoves(), Move.class);
	    Logger.logValidadInputs("Parsed MOVES", moves);
	    
	    Set<XYAxis> stoneXyAxisList = StringToCoordenateConverter.convertToSet(input.getStones(), XYAxis.class);
	    Logger.logValidadInputs("Parsed STONES", stoneXyAxisList);

	    XYAxis startLocation = StringToCoordenateConverter.convert(input.getStartSquareLocation(), XYAxis.class);
	    this.startPosition = new Position(startLocation);
	    Logger.logValidadInputs("Parsed START LOCATION", Arrays.asList(startLocation));
	    
	    XYAxis endLocation = StringToCoordenateConverter.convert(input.getEndSquareLocation(), XYAxis.class);
	    this.endPosition = new Position(endLocation);
	    Logger.logValidadInputs("Parsed END LOCATION", Arrays.asList(endLocation));
	    
	    initialize(boarSize, this.startPosition, this.endPosition, stoneXyAxisList,  moves);
	}catch (NumberFormatException | InvalidPositionException e) {
	    throw new InputParseException(input.getBoardSize()); 
	}
    }

    private void initialize(int boarSize, Position startPosition, Position endPosition, Set<XYAxis> stoneXyAxisList,
	    Set<Move> moves) throws InputParseException  {
	try {
	    this.board = new Board(boarSize);
	    this.startPosition = startPosition;
	    this.endPosition = endPosition;
	    Jumper jumper = new Jumper(startPosition, moves.toArray(new Move[moves.size()]));
	    this.board.addJumper(jumper);
	    for (XYAxis stoneXYAxis : stoneXyAxisList) {
		try{
		    board.addStone(new Stone(stoneXYAxis));
		}catch (InvalidPositionException e) {
		    System.err.println("Discarding stone: "+ e.getMessage());
		}
	    }
	} catch (BoardSizeException | NoMovesException | JumperPositionInvalidException e) {
	    throw new InputParseException(e.getMessage());
	}
    }

    public Result process() throws NoMovesException, JumperPositionInvalidException {
	return new PathFinder().findShortestPathJumperTree(endPosition, board).getResult(this.endPosition);
    }
    
    
    
}
