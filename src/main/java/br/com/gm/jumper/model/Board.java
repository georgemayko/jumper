package br.com.gm.jumper.model;

import java.util.HashSet;
import java.util.Set;

import br.com.gm.jumper.exceptions.BoardSizeException;
import lombok.Getter;

@Getter
public class Board {
    
    private final int minHeight = 1;
    private final int minWidth = 1;
    private int maxHeight;
    private int maxWidth;
    
    private Set<Coordenate> coordenateList;
    
    public Board(int maxHeight, int maxWidth) throws BoardSizeException {
	super();
	if(maxHeight < minHeight || maxWidth < minWidth)
	    throw new BoardSizeException();
	this.maxHeight = maxHeight;
	this.maxWidth = maxWidth;
	this.coordenateList = new HashSet<Coordenate>();
	createCoordenatesOfTheBoard();
    }
    
    public Board(int size) throws BoardSizeException{
	new Board(size, size);
    }
    
    private void createCoordenatesOfTheBoard() {
	for(int width = minWidth; width<= maxWidth; width++){
	    for(int height = minHeight; height<= maxHeight; height++){
		coordenateList.add(new Coordenate(width, height));
	    }
	}
    }
}
