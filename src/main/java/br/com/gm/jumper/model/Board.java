package br.com.gm.jumper.model;

import java.util.HashMap;
import java.util.Map;

import br.com.gm.jumper.exceptions.BoardSizeException;
import br.com.gm.jumper.exceptions.JumperPositionInvalidException;
import lombok.Getter;

@Getter
public class Board {

    private final int minSize = 1;
    private int maxSize = 100;

    private int size;

    private Map<XYAxis, BoardSquare> xyAxisMap;
    private Jumper jumper;

    public Board(int size) throws BoardSizeException{
	super();
	if(size < minSize || size > maxSize)
	    throw new BoardSizeException(String.format("Board size should be betwen %d and %d", minSize, maxSize));
	this.size = size;
	this.xyAxisMap = new HashMap<XYAxis,BoardSquare>();
	createXYAxisOfTheBoard();
    }

    private void createXYAxisOfTheBoard() {
	for(int x = minSize; x <= size; x++){
	    for(int y = minSize; y<= size; y++){
		XYAxis xyAxis = new XYAxis(x, y);
		xyAxisMap.put(xyAxis, xyAxis);
	    }
	}
    }

    public void addJumper(Jumper jumper) throws JumperPositionInvalidException{
	if(!xyAxisMap.containsKey(jumper.getActualPosition().getXyAxis())
		|| xyAxisMap.get(jumper.getActualPosition().getXyAxis()) instanceof Stone)
	    throw new JumperPositionInvalidException();
	this.jumper = jumper;
	this.updateXYAxisSet(jumper.getActualPosition());
    }
    
    private <T extends Position> void updateXYAxisSet(T object){
	this.xyAxisMap.put(object.getXyAxis(), object);
    }

    public void addStone(Stone stone){
	if(xyAxisMap.containsKey(stone.getXyAxis())){
	    updateXYAxisSet(stone);
	}
    }

    public boolean isValidPositionForMove(Position position) {
	if(!xyAxisMap.containsKey(position.getXyAxis())
		|| xyAxisMap.get(position.getXyAxis()) instanceof Position)
	    return false;
	return true;
    }
    
}
