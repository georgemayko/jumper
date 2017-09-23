package br.com.gm.jumper.model;

import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import br.com.gm.jumper.exceptions.BoardSizeException;
import br.com.gm.jumper.exceptions.InvalidMoveException;
import br.com.gm.jumper.exceptions.InvalidPositionException;
import br.com.gm.jumper.exceptions.JumperPositionInvalidException;
import br.com.gm.jumper.exceptions.NoMovesException;

public class JumperTest {

    private Move[] horseChessMoves;

    public JumperTest() throws InvalidMoveException {
	super();
	horseChessMoves = new Move[]{new Move(1,2), new Move(2,1), new Move(1,-2), new Move(2,-1), new Move(-1,2), new Move(-2,1), new Move(-1,-2), new Move(-2,-1)};
    }

    @Test(expected=NoMovesException.class)
    public void mustNotCreateAJumperWithNoMoves() throws InvalidPositionException, NoMovesException{
	new Jumper(new Position(new XYAxis(1, 1)));
    }

    @Test
    public void mustCreateAJumperWithOneMove() throws InvalidPositionException, NoMovesException, InvalidMoveException{
	new Jumper(new Position(new XYAxis(1, 1)), new Move(1, 2));
    }

    @Test
    public void mustNotExistPossibleMovesForASizeBoardOneToAhorseChessJumper() throws BoardSizeException, NoMovesException, InvalidPositionException, JumperPositionInvalidException{
	Board board = new Board(1);
	XYAxis xyAxis = new XYAxis(1, 1);
	Jumper jumper = new Jumper(new Position(xyAxis), horseChessMoves);
	board.addJumper(jumper);
	Assert.assertEquals(0, jumper.getPossiblePositionMoves(board).size());
    }

    @Test
    public void mustNotExistPossibleMovesForASizeBoardThreeToAhorseChessJumperOnThePosition2x2() throws BoardSizeException, NoMovesException, InvalidPositionException, JumperPositionInvalidException{
	Board board = new Board(3);
	XYAxis xyAxis = new XYAxis(2, 2);
	Jumper jumper = new Jumper(new Position(xyAxis), horseChessMoves);
	board.addJumper(jumper);
	Assert.assertEquals(0, jumper.getPossiblePositionMoves(board).size());
    }


    @Test
    public void mustExistTwoPossibleMovesForASizeBoardThreeToAhorseChessJumperOnThePosition1x1() throws BoardSizeException, NoMovesException, InvalidPositionException, JumperPositionInvalidException{
	Board board = new Board(3);
	XYAxis xyAxis = new XYAxis(1, 1);
	Jumper jumper = new Jumper(new Position(xyAxis), horseChessMoves);
	board.addJumper(jumper);
        assertThat( jumper.getPossiblePositionMoves(board), 
        	containsInAnyOrder(Arrays.asList(new Position(new XYAxis(2,3)), new Position(new XYAxis(3,2))).toArray()));
    }
    
    @Test
    public void mustExistTwoPossibleMovesForASizeBoardThreeToAhorseChessJumperOnThePosition1x2() throws BoardSizeException, NoMovesException, InvalidPositionException, JumperPositionInvalidException{
	Board board = new Board(3);
	XYAxis xyAxis = new XYAxis(1, 2);
	Jumper jumper = new Jumper(new Position(xyAxis), horseChessMoves);
	board.addJumper(jumper);
        assertThat( jumper.getPossiblePositionMoves(board), 
        	containsInAnyOrder(Arrays.asList(new Position(new XYAxis(3,1)), new Position(new XYAxis(3,3))).toArray()));
    }
    
    @Test
    public void mustExistOnly2x3PossibleMoveForASizeBoardThreeToAhorseChessJumperOnThePosition1x1AndAStoneOn3x2() throws BoardSizeException, NoMovesException, InvalidPositionException, JumperPositionInvalidException{
	Board board = new Board(3);
	XYAxis xyAxis = new XYAxis(1, 1);
	Jumper jumper = new Jumper(new Position(xyAxis), horseChessMoves);
	board.addStone(new Stone(new XYAxis(3, 2)));
	board.addJumper(jumper);
        assertThat( jumper.getPossiblePositionMoves(board), 
        	containsInAnyOrder(new Position(new XYAxis(2,3))));
    }
    
    
    @Test
    public void mustExistEightPossibleMovesForASizeBoardEightToAhorseChessJumperOnThePosition4x4() throws BoardSizeException, NoMovesException, InvalidPositionException, JumperPositionInvalidException{
	Board board = new Board(8);
	XYAxis xyAxis = new XYAxis(4, 4);
	Jumper jumper = new Jumper(new Position(xyAxis), horseChessMoves);
	board.addJumper(jumper);
        assertThat( jumper.getPossiblePositionMoves(board), 
        	containsInAnyOrder(
        		Arrays.asList(
        			new Position(new XYAxis(2,3)), 
        			new Position(new XYAxis(2,5)),
        			new Position(new XYAxis(3,2)), 
        			new Position(new XYAxis(3,6)),
        			new Position(new XYAxis(5,2)), 
        			new Position(new XYAxis(5,6)),
        			new Position(new XYAxis(6,3)), 
        			new Position(new XYAxis(6,5))
        			).toArray()));
    }

}
