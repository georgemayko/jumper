package br.com.gm.jumper.model;

import br.com.gm.jumper.exceptions.InvalidPositionException;
import lombok.Getter;

@Getter
public class Position implements BoardSquare{
    
    private XYAxis xyAxis;

    public Position(XYAxis xyAxis) throws InvalidPositionException {
	super();
	if(xyAxis.getXAxis() < 0 || xyAxis.getYAxis() < 0)
	    throw new InvalidPositionException();
	this.xyAxis = xyAxis;
    }

}
