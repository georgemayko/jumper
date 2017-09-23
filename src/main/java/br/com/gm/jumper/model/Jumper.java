package br.com.gm.jumper.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import br.com.gm.jumper.exceptions.NoMovesException;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Jumper {

    private Position initialPosition;
    private Position finalPosition;
    private Set<Move> moves;

    @Setter
    private Position actualPosition;
    
    public Jumper(Position initialPosition, Position finalPosition,Move... moves) throws NoMovesException {
	super();
	this.initialPosition = initialPosition;
	this.finalPosition = finalPosition;
	this.actualPosition = initialPosition;
	if(moves.length == 0)
	    throw new NoMovesException();
	this.moves = new HashSet<Move>(Arrays.asList(moves));
    }
   
    
}
