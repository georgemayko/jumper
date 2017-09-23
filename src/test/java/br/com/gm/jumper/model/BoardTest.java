package br.com.gm.jumper.model;

import org.junit.Test;

import br.com.gm.jumper.exceptions.BoardSizeException;

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
    
}
