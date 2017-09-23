package br.com.gm.jumper.model;

import org.junit.Assert;
import org.junit.Test;

import br.com.gm.jumper.exceptions.BoardSizeException;
import br.com.gm.jumper.exceptions.InvalidPositionException;

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
	 Assert.assertTrue(board.getXyAxisSet().contains(stone));
    }
    
    @Test
    public void mustNotAddStoneOnBoard() throws InvalidPositionException, BoardSizeException{
	Stone stone = new Stone(new XYAxis(3, 1));
	 Board board = new Board(1);
	 board.addStone(stone);
	 Assert.assertFalse(board.getXyAxisSet().contains(stone));
    }
    
}
