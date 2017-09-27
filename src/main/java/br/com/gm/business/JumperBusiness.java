package br.com.gm.business;

import java.util.Set;

import br.com.gm.jumper.exceptions.BoardSizeException;
import br.com.gm.jumper.model.Board;
import br.com.gm.jumper.model.Move;
import br.com.gm.jumper.model.XYAxis;
import br.com.gm.jumper.util.InputProperties;
import br.com.gm.jumper.util.StringToCoordenateConverter;

public class JumperBusiness {

    public void createScenario(InputProperties input) throws NumberFormatException, BoardSizeException{
	Board board =new Board(Integer.parseInt(input.getBoardSize()));
	Set<Move> moves = StringToCoordenateConverter.convertToSet(input.getJumperMoves(), Move.class);
	Set<XYAxis> stones = StringToCoordenateConverter.convertToSet(input.getStones(), XYAxis.class);
	
	//stones.forEach(stone -> board.addStone(stone));
    }
}
