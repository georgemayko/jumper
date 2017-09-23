package br.com.gm.jumper.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import br.com.gm.jumper.exceptions.InvalidPositionException;
import br.com.gm.jumper.exceptions.NoMovesException;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Jumper{

    private Set<Move> moves;

    @Setter
    private Position actualPosition;
    
    public Jumper(Position initialPosition, Move... moves) throws NoMovesException {
	super();
	this.actualPosition = initialPosition;
	if(moves.length == 0)
	    throw new NoMovesException();
	this.moves = new HashSet<Move>(Arrays.asList(moves));
    }
    
    public Set<Position> getPossiblePositionMoves(Board board){
	Set<Position> positionSet = new HashSet<Position>();
	this.moves.forEach(move ->{
	    try{
		Position position = getNew(actualPosition, move);
		if(board.isValidPositionForMove(position))
			positionSet.add(position);
	    }catch( InvalidPositionException e){   }
	});
	return positionSet;
    }

    private Position getNew(Position position, Move move) throws InvalidPositionException{
	XYAxis xyAxis = position.getXyAxis();
	return new Position(new XYAxis(xyAxis.getXAxis()+ move.getXAxis(), xyAxis.getYAxis() + move.getYAxis()));
    }
    
}
