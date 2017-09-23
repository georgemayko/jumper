package br.com.gm.jumper.model;

import org.junit.Assert;
import org.junit.Test;

import br.com.gm.jumper.exceptions.BoardSizeException;
import br.com.gm.jumper.exceptions.InvalidMoveException;
import br.com.gm.jumper.exceptions.InvalidPositionException;
import br.com.gm.jumper.exceptions.JumperPositionInvalidException;
import br.com.gm.jumper.exceptions.NoMovesException;

public class BoardTest {

    @Test(expected = BoardSizeException.class)
    public void mustNotCreateBoardWithNegativeSize() throws BoardSizeException{
	new Board(-1);
    }

    @Test(expected = BoardSizeException.class)
    public void mustNotCreateBoardWithSizeZero() throws BoardSizeException{
	new Board(0);
    }

    @Test(expected = BoardSizeException.class)
    public void mustNotCreateBoardWithSizeBiggerThanOneHundred() throws BoardSizeException{
	new Board(101);
    }

    @Test 
    public void mustCreateBoardWithSizeEqualsOne() throws BoardSizeException {
	new Board(1);
    }

    @Test
    public void mustCreateBoardWithSizeEqualsOneHundred() throws BoardSizeException{
	new Board(100);
    }

    @Test
    public void mustAddStoneOnBoard() throws InvalidPositionException, BoardSizeException{
	Stone stone = new Stone(new XYAxis(1, 1));
	Board board = new Board(1);
	board.addStone(stone);
	Assert.assertEquals(stone, board.getXyAxisMap().get(stone.getXyAxis()));
    }

    @Test
    public void mustNotAddStoneOnBoard() throws InvalidPositionException, BoardSizeException{
	Stone stone = new Stone(new XYAxis(3, 1));
	Board board = new Board(1);
	board.addStone(stone);
	Assert.assertNull(board.getXyAxisMap().get(stone));
    }


    @Test
    public void mustAddJumperOnBoard() throws InvalidPositionException, BoardSizeException, NoMovesException, InvalidMoveException, JumperPositionInvalidException{
	Jumper jumper = new Jumper(new Position(new XYAxis(1, 1)), new Move(1,2));
	Board board = new Board(1);
	board.addJumper(jumper);
	Assert.assertEquals(jumper.getActualPosition(), board.getXyAxisMap().get(jumper.getActualPosition().getXyAxis()));
    }
    
    
    @Test(expected=JumperPositionInvalidException.class)
    public void mustNotAddJumperOutOfBoard() throws InvalidPositionException, BoardSizeException, NoMovesException, InvalidMoveException, JumperPositionInvalidException{
	Jumper jumper = new Jumper(new Position(new XYAxis(1, 8)), new Move(1,2));
	Board board = new Board(1);
	board.addJumper(jumper);
    }
    
    @Test(expected=JumperPositionInvalidException.class)
    public void mustNotAddJumperWhenThereIsAStoneOnTheActualPositionOnBoard() throws InvalidPositionException, BoardSizeException, NoMovesException, InvalidMoveException, JumperPositionInvalidException{
	Jumper jumper = new Jumper(new Position(new XYAxis(1, 1)), new Move(1,2));
	Stone stone = new Stone(new XYAxis(1, 1));
	Board board = new Board(5);
	board.addStone(stone);
	board.addJumper(jumper);
    }

    @Test
    public void mustBeAValidPositionForMoveWhenIsAValidPositionOnBoard() throws InvalidPositionException, BoardSizeException{
	Board board = new Board(1);
	Assert.assertTrue(board.isValidPositionForMove(new Position(new XYAxis(1, 1))));
    }
    
    @Test
    public void mustNotBeAValidPositionForMoveWhenIsAValidPositionOnBoard() throws InvalidPositionException, BoardSizeException{
	Board board = new Board(5);
	Assert.assertFalse(board.isValidPositionForMove(new Position(new XYAxis(1, 6))));
    }
    
    
    @Test
    public void mustNotBeAValidPositionForMoveWhenAStoneIsAddedOnThePositionToBoard() throws InvalidPositionException, BoardSizeException{
	Board board = new Board(5);
	XYAxis xyAxis =new XYAxis(1, 2);
	board.addStone(new Stone(xyAxis));
	Assert.assertFalse(board.isValidPositionForMove(new Position(xyAxis)));
    }
    
    @Test
    public void mustNotBeAValidPositionForMoveWhenAJumperIsAddedOnThePositionToBoard() throws InvalidPositionException, BoardSizeException, JumperPositionInvalidException, NoMovesException, InvalidMoveException{
	Board board = new Board(5);
	XYAxis xyAxis =new XYAxis(1, 3);
	board.addJumper(new Jumper(new Position(xyAxis), new Move(1,2)));
	Assert.assertFalse(board.isValidPositionForMove(new Position(xyAxis)));
    }
    
    
}
