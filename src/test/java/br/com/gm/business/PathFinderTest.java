package br.com.gm.business;

import org.junit.Assert;
import org.junit.Test;

import br.com.gm.jumper.exceptions.BoardSizeException;
import br.com.gm.jumper.exceptions.InvalidMoveException;
import br.com.gm.jumper.exceptions.InvalidPositionException;
import br.com.gm.jumper.exceptions.JumperPositionInvalidException;
import br.com.gm.jumper.exceptions.NoMovesException;
import br.com.gm.jumper.model.Board;
import br.com.gm.jumper.model.Jumper;
import br.com.gm.jumper.model.Move;
import br.com.gm.jumper.model.Position;
import br.com.gm.jumper.model.Result;
import br.com.gm.jumper.model.XYAxis;


public class PathFinderTest {
    
    private Move[] horseChessMoves;

    public PathFinderTest() throws InvalidMoveException {
	super();
	horseChessMoves = new Move[]{new Move(1,2), new Move(2,1), new Move(1,-2), new Move(2,-1), new Move(-1,2), new Move(-2,1), new Move(-1,-2), new Move(-2,-1)};
    }
    
    
    @Test
    public void mustReturnNumberOfStepsZeroWhenStartAndEndPositionAreTheSame() throws BoardSizeException, NoMovesException, InvalidPositionException, InvalidMoveException, JumperPositionInvalidException{
	Board board = new Board(1);
	Jumper jumper = new Jumper(new Position(new XYAxis(1,1)), horseChessMoves);
	board.addJumper(jumper);
	Result result = new PathFinder().findShortestPath(jumper, jumper.getActualPosition(), board);
	Assert.assertEquals(0, result.getNumberOfPaths());
    }
    
    
    @Test
    public void mustReturnNumberOfStepsOneWhenStartAndEndPositionAreConnectedByOneMove() throws BoardSizeException, NoMovesException, InvalidPositionException, InvalidMoveException, JumperPositionInvalidException{
	Board board = new Board(3);
	Jumper jumper = new Jumper(new Position(new XYAxis(1,1)), horseChessMoves);
	board.addJumper(jumper);
	Result result = new PathFinder().findShortestPath(jumper, new Position(new XYAxis(2, 3)), board);
	Assert.assertEquals(1, result.getNumberOfPaths());
    }
    
    @Test
    public void a() throws BoardSizeException, NoMovesException, InvalidPositionException, InvalidMoveException, JumperPositionInvalidException{
	Board board = new Board(8);
	Jumper jumper = new Jumper(new Position(new XYAxis(4,4)), horseChessMoves);
	board.addJumper(jumper);
	Result result = new PathFinder().findShortestPath(jumper, new Position(new XYAxis(1, 1)), board);
	Assert.assertEquals(2, result.getNumberOfPaths());
    }
    
    
}
