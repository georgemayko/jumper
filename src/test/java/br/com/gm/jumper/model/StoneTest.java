package br.com.gm.jumper.model;

import org.junit.Assert;
import org.junit.Test;

import br.com.gm.jumper.exceptions.InvalidPositionException;

public class StoneTest {
    
    
    @Test(expected=InvalidPositionException.class)
    public void mustNotCreateAStoneWithXAxisNegative() throws InvalidPositionException{
	new Stone(-1, 10);
    }
    
    @Test(expected=InvalidPositionException.class)
    public void mustNotCreateAStoneWithYAxisNegative() throws InvalidPositionException{
	new Stone(20, -1);
    }
    
    @Test(expected=InvalidPositionException.class)
    public void mustNotCreateAStoneWithXAndYAxisNegative() throws InvalidPositionException{
	new Stone(-1, -10);
    }
    
    public void mustCreateAStoneWithYAxisPositive() throws InvalidPositionException{
	Assert.assertNotNull(new Stone(0, 1));
    }
    
    
}
