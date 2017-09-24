package br.com.gm.business;

import java.util.HashSet;
import java.util.Set;

import br.com.gm.jumper.model.Board;
import br.com.gm.jumper.model.Jumper;
import lombok.Getter;

@Getter
public class JumperTree {

    private Jumper jumperRoot;
    private Set<Jumper> nodes;
    private Boolean fetchedNodes = Boolean.FALSE;
    
    public JumperTree(Jumper jumperRoot, Board board) {
	super();
	
	this.jumperRoot = jumperRoot;
	this.nodes = new HashSet<Jumper>();
    }
    
    public void fetchNodes(Board board){
	this.jumperRoot.getPossiblePositionMoves(board).forEach(position ->
	    nodes.add(new Jumper(position, jumperRoot))
	);
    }
    
}
