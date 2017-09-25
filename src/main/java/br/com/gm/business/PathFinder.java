package br.com.gm.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import br.com.gm.jumper.exceptions.JumperPositionInvalidException;
import br.com.gm.jumper.exceptions.NoMovesException;
import br.com.gm.jumper.model.Board;
import br.com.gm.jumper.model.Jumper;
import br.com.gm.jumper.model.Position;

public class PathFinder {

    Queue<Step> startToEnd = new LinkedList<Step>();
    Queue<Step> endToStart = new LinkedList<Step>();

//    public Result findShortestPath( Jumper jumper, Position endPosition, Board board) throws NoMovesException, JumperPositionInvalidException{
//	Jumper endJumper = new Jumper(endPosition, jumper.getMoves().toArray( new Move[jumper.getMoves().size()]));
//	board.addJumper(jumper);
//	AtomicInteger numberOfSteps= new AtomicInteger(0);
//	//return a(numberOfSteps, board, endPosition, Arrays.asList(jumper));
//	return a(numberOfSteps, board, endPosition, Arrays.asList(jumper));
//    }


    public JumperTree findShortestPathJumperTree( Jumper jumper, Position endPosition, Board board) throws NoMovesException, JumperPositionInvalidException{
	board.addJumper(jumper);
	JumperTree tree = new JumperTree(new Node(jumper.getActualPosition()));
	return b(board, endPosition, Arrays.asList(jumper.getActualPosition()), tree);
    }



   /* private Result a (AtomicInteger numberOfSteps, Board board, Position endPosition, List<Jumper> jumpers){
	numberOfSteps.incrementAndGet();
	if(jumpers.stream().filter(j -> j.getActualPosition().equals(endPosition)).count() > 0){
	    return new Result(numberOfSteps.get(), 0);
	}else{
	    long jumperMatchedToEnd = jumpers.stream().filter(jumper -> jumper.getPossiblePositionMoves(board).stream().filter(p -> p.equals(endPosition)).count() >0).count();


	    jumpers.forEach(j -> {try {board.addJumper(j);} catch (JumperPositionInvalidException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }});


	    if(jumperMatchedToEnd == 0){
		List<Jumper> jumpersToReview = new ArrayList<Jumper>();
		jumpers.forEach(jumper ->{
		    jumper.getPossiblePositionMoves(board).forEach(position -> jumpersToReview.add(new Jumper(position, jumper)));
		});
		return this.a(numberOfSteps, board, endPosition, jumpersToReview);
	    } 
	    jumpers.stream().filter(jumper -> jumper.getPossiblePositionMoves(board).stream().filter(p -> p.equals(endPosition)).count() >0).forEach(r ->System.out.println(r.getActualPosition().getXyAxis().getLocation()));
	    return new Result(numberOfSteps.get(), (int) jumperMatchedToEnd,"");
	}
    }
*/

    private JumperTree b (Board board, Position endPosition, List<Position> positions, JumperTree tree){
	System.out.println("Start filter:("+positions.size()+")\t" +GregorianCalendar.getInstance().getTime());
	if(positions.stream().filter(p -> p.equals(endPosition)).count() > 0){
	    System.out.println("Start finished: \t" +GregorianCalendar.getInstance().getTime());
	    return tree;
	}else{
	    System.out.println("More step:\t" +GregorianCalendar.getInstance().getTime());
	    Set<Position> positionsToProcess = new HashSet<Position>();
	    positions.forEach(position ->{
		new Jumper(position, board.getJumper()).getPossiblePositionMoves(board)
		.forEach(newPosition -> {
		    positionsToProcess.add(newPosition);
		    tree.addNode(position, newPosition);
		});
	    });
	    return this.b(board, endPosition, new ArrayList<Position>(positionsToProcess), tree);
	}
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
