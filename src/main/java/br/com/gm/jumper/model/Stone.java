package br.com.gm.jumper.model;

import br.com.gm.jumper.exceptions.InvalidPositionException;

public class Stone extends Position implements BoardSquare{

    public Stone(XYAxis xyAxis) throws InvalidPositionException {
	super(xyAxis);
    }
}
