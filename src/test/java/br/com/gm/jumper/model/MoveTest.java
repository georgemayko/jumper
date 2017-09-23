package br.com.gm.jumper.model;

import org.junit.Assert;
import org.junit.Test;

import br.com.gm.jumper.exceptions.InvalidMoveException;

public class MoveTest {
    
    @Test(expected=InvalidMoveException.class)
    public void mustNotCreateMoveWithXAndYAxisEqualZero() throws InvalidMoveException{
	new Move(0, 0);
    }
    
    public void mustCreateMoveWithXAxisEqualZeroAndYaxisPositive() throws InvalidMoveException{
	Assert.assertNotNull(new Move(0, 3));
    }
    
    public void mustCreateMoveWithXAxisEqualZeroAndYaxisNegative() throws InvalidMoveException{
	Assert.assertNotNull(new Move(0, -3));
    }
    
    public void mustCreateMoveWithYAxisEqualZeroAndXAxisPositive() throws InvalidMoveException{
	Assert.assertNotNull(new Move(1, 0));
    }
    
    public void mustCreateMoveWithYAxisEqualZeroAndXAxisNegative() throws InvalidMoveException{
	Assert.assertNotNull(new Move(1, 0));
    }
    
    public void mustCreateMoveWithXAndYAxisPositive() throws InvalidMoveException{
	Assert.assertNotNull(new Move(1, 3));
    }
    
    public void mustCreateMoveWithXAndYAxisNegative() throws InvalidMoveException{
	Assert.assertNotNull(new Move(-3, -5));
    }
    

   

}
