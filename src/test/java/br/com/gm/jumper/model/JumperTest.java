package br.com.gm.jumper.model;

import org.junit.Test;

import br.com.gm.jumper.exceptions.InvalidMoveException;
import br.com.gm.jumper.exceptions.InvalidPositionException;
import br.com.gm.jumper.exceptions.NoMovesException;

public class JumperTest {
    
    @Test(expected=NoMovesException.class)
    public void mustNotCreateAJumperWithNoMoves() throws InvalidPositionException, NoMovesException{
	new Jumper(new Position(new XYAxis(1, 1)));
    }
    
    public void mustCreateAJumperWithOneMove() throws InvalidPositionException, NoMovesException, InvalidMoveException{
	new Jumper(new Position(new XYAxis(1, 1)), new Move(1, 2));
    }
    
}
