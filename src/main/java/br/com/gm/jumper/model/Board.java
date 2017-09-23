package br.com.gm.jumper.model;

import java.util.HashSet;
import java.util.Set;

import br.com.gm.jumper.exceptions.BoardSizeException;
import lombok.Getter;

@Getter
public class Board {
    
    private final int minSize = 1;
    private int maxSize = 100;
    
    private int size;
    
    private Set<Coordenate> coordenateList;
    
    public Board(int size) throws BoardSizeException{
	super();
	if(size < minSize || size > maxSize)
	    throw new BoardSizeException();
	this.size = size;
	this.coordenateList = new HashSet<Coordenate>();
	createCoordenatesOfTheBoard();
    }
    
    private void createCoordenatesOfTheBoard() {
	for(int x = minSize; x <= size; x++){
	    for(int y = minSize; y<= size; y++){
		coordenateList.add(new Coordenate(x, y));
	    }
	}
    }
}
