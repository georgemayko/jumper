package br.com.gm.business;

import br.com.gm.jumper.exceptions.BoardSizeException;
import br.com.gm.jumper.model.Board;
import br.com.gm.jumper.model.Move;
import br.com.gm.jumper.model.Stone;
import br.com.gm.jumper.util.InputProperties;
import br.com.gm.jumper.util.StringToCoordenateConverter;

public class JumperBusiness {

    public void createScenario(InputProperties input) throws NumberFormatException, BoardSizeException{
	new Board(Integer.parseInt(input.getBoardSize()));
	StringToCoordenateConverter.convertToSet(input.getJumperMoves(), Move.class);
	StringToCoordenateConverter.convertToSet(input.getStones(), Stone.class);
    }
}
