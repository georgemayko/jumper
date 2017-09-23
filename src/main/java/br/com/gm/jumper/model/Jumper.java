package br.com.gm.jumper.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Jumper {

    private Position initialPosition;
    private Position finalPosition;
    private Set<Move> moves;

    @Setter
    private Position actualPosition;
    
    public Jumper(Position initialPosition, Position finalPosition) {
	super();
	this.initialPosition = initialPosition;
	this.finalPosition = finalPosition;
	this.actualPosition = initialPosition;
    }
    
    public void setMoves(Move... moves){
	this.moves = new HashSet<Move>(Arrays.asList(moves));
    }
    
}
