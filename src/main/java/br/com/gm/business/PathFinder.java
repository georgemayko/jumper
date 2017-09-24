package br.com.gm.business;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

import br.com.gm.jumper.exceptions.JumperPositionInvalidException;
import br.com.gm.jumper.exceptions.NoMovesException;
import br.com.gm.jumper.model.Board;
import br.com.gm.jumper.model.Jumper;
import br.com.gm.jumper.model.Move;
import br.com.gm.jumper.model.Position;
import br.com.gm.jumper.model.Result;

public class PathFinder {

    Queue<Step> startToEnd = new LinkedList<Step>();
    Queue<Step> endToStart = new LinkedList<Step>();
    
    public Result findShortestPath( Jumper jumper, Position endPosition, Board board) throws NoMovesException, JumperPositionInvalidException{
	Jumper endJumper = new Jumper(endPosition, jumper.getMoves().toArray( new Move[jumper.getMoves().size()]));
	board.addJumper(jumper);
	//board.addJumper(endJumper);
	AtomicInteger numberOfSteps= new AtomicInteger(0);
	if(jumper.getActualPosition() == endJumper.getActualPosition()){
	    return new Result(numberOfSteps.get(), 0);
	}
	else{
	    numberOfSteps.incrementAndGet();
	    Long numberOfPaths = jumper.getPossiblePositionMoves(board).stream().filter(position-> position.equals(endPosition)).count();
	    return new Result(numberOfSteps.get(), numberOfPaths.intValue(), "");
	}
	//return null;
    }
    
//    public void find(Jumper start, Jumper end, Board board){
//	AtomicInteger numberOfSteps= new AtomicInteger(0);
//	JumperTree startTree = new JumperTree(start, board);
//	//JumperTree endTree = new JumperTree(end, board);
//	startTree.fetchNodes(board);
//	Step step = new Step(numberOfSteps.getAndIncrement(), Arrays.asList(startTree));
//	
//    }
//    

//    public void find(Jumper end, Board board, AtomicInteger step, JumperTree... jumperTrees){
//	System.out.println(step.incrementAndGet());
//	Boolean encontrado = false;
//	for (JumperTree start : jumperTrees) {
//	    start.getNodes().forEach(node ->{
//		node.getPossiblePositionMoves(board).forEach(p ->{
//			if(p.equals(end.getActualPosition())){
//			    encontrado = true;
//			}
//		    });
//	    });
//	}
//	if(encontrado)
//	    System.out.println("Passos :"+ step.incrementAndGet());
//	else{
//	    List<JumperTree> newTree = new HashMap<String>(); 
//	    this.find(end, board, step, jumperTrees);
//	}
//	startToEnd.
//    }

}
