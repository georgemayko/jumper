package br.com.gm.jumper.model;

import org.junit.Test;

import br.com.gm.jumper.exceptions.BoardSizeException;

public class BoardTest {

    
    @Test(expected = BoardSizeException.class)
    public void mustNotCreateBoardWithNegativeWidth() throws BoardSizeException{
	new Board(5, -1);
    }
    
    @Test(expected = BoardSizeException.class)
    public void mustNotCreateBoardWithNegativeHeight() throws BoardSizeException{
	new Board(-1, 2);
    }
    
    @Test(expected = BoardSizeException.class)
    public void mustNotCreateBoardWithWidthZero() throws BoardSizeException{
	new Board(5, 0);
    }
    
    @Test(expected = BoardSizeException.class)
    public void mustNotCreateBoardWithHeightZero() throws BoardSizeException{
	new Board(0, 10);
    }
    
    
    @Test 
    public void mustCreateBoardWithWidthAndHeightEqualsOne() throws BoardSizeException {
	new Board(1, 1);
    }
    
    @Test
    public void mustCreateBoardWithWidthAndHeightEqualsBiggerThanOne() throws BoardSizeException{
	new Board(5, 2);
    }
}
