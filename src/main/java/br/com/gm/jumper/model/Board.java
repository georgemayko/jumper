package br.com.gm.jumper.model;

import java.util.HashSet;
import java.util.Set;

import br.com.gm.jumper.exceptions.BoardSizeException;
import br.com.gm.jumper.exceptions.JumperPositionInvalidException;
import lombok.Getter;

@Getter
public class Board {

    private final int minSize = 1;
    private int maxSize = 100;

    private int size;

    private Set<BoardSquare> xyAxisSet;

    public Board(int size) throws BoardSizeException{
	super();
	if(size < minSize || size > maxSize)
	    throw new BoardSizeException();
	this.size = size;
	this.xyAxisSet = new HashSet<BoardSquare>();
	createCoordenatesOfTheBoard();
    }

    private void createCoordenatesOfTheBoard() {
	for(int x = minSize; x <= size; x++){
	    for(int y = minSize; y<= size; y++){
		xyAxisSet.add(new XYAxis(x, y));
	    }
	}
    }

    public void addJumper(Jumper jumper) throws JumperPositionInvalidException{
	if(!xyAxisSet.contains(jumper.getInitialPosition()) ||
		!xyAxisSet.contains(jumper.getFinalPosition()))
	    throw new JumperPositionInvalidException();
    }

    public void addStone(Stone stone){
	if(xyAxisSet.contains(stone.getXyAxis())){
	    xyAxisSet.remove(stone.getXyAxis());
	    xyAxisSet.add(stone);
	}
    }
}
