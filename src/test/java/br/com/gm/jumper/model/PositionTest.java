package br.com.gm.jumper.model;

import org.junit.Assert;
import org.junit.Test;

import br.com.gm.jumper.exceptions.InvalidPositionException;

public class PositionTest {

    
    @Test(expected=InvalidPositionException.class)
    public void mustNotCreateAPositionWithXAxisNegative() throws InvalidPositionException{
	new Position(-1, 10);
    }
    
    @Test(expected=InvalidPositionException.class)
    public void mustNotCreateAPositionWithYAxisNegative() throws InvalidPositionException{
	new Position(20, -1);
    }
    
    
    @Test(expected=InvalidPositionException.class)
    public void mustNotCreateAPositionWithXAndYAxisNegative() throws InvalidPositionException{
	new Position(-1, -10);
    }
    
    public void mustCreateAPositionWithYAxisPositive() throws InvalidPositionException{
	Assert.assertNotNull(new Position(0, 1));
    }
    
}
