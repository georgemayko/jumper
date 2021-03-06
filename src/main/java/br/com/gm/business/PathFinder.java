package br.com.gm.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;

import br.com.gm.jumper.exceptions.InvalidPositionException;
import br.com.gm.jumper.exceptions.JumperPositionInvalidException;
import br.com.gm.jumper.exceptions.NoMovesException;
import br.com.gm.jumper.model.Board;
import br.com.gm.jumper.model.Jumper;
import br.com.gm.jumper.model.Position;
import br.com.gm.jumper.model.Stone;

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


    public JumperTree findShortestPathJumperTree(Position endPosition, Board board) throws NoMovesException, JumperPositionInvalidException{
	JumperTree tree = new JumperTree(new Node(board.getJumper().getActualPosition()));
	if(!board.isValidPositionForMove(endPosition))
	    return tree; 
	return findShortestPathUsingTreeCoordinator(board, endPosition, board.getJumper().getActualPosition());
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

    private JumperTree findShortestPathUsingTreeCoordinator(Board board, Position endPosition, Position actualPosition) {
	try{
	    TreeCoordinator treeCoordinator = new TreeCoordinator(new JumperTree(new Node(actualPosition)), new JumperTree(new Node(endPosition)));
	    return mountJumperTree(board, Arrays.asList(endPosition), Arrays.asList(actualPosition),treeCoordinator);
	}catch(NoMovesException e){
	    return new JumperTree(new Node(endPosition));
	}
    }



    private JumperTree mountJumperTree (Board board, List<Position> endPosition, List<Position> positions, TreeCoordinator treeCoordinator) throws NoMovesException{
	if( positions.isEmpty() || endPosition.isEmpty()){
	    throw new NoMovesException();
	}
	if(!Collections.disjoint(positions, endPosition)){
	    treeCoordinator.joinTrees(CollectionUtils.intersection(positions, endPosition));
	    return treeCoordinator.getFullTree();
	}else{
	    if(positions.size() <= endPosition.size()){
		List<Position> positionsToProcess = getNewPositionsToProcess(board, positions, treeCoordinator.getHeader(),true);
		return this.mountJumperTree(board, endPosition, positionsToProcess, treeCoordinator);
	    }
	    else{
		List<Position> positionsToProcess = getNewPositionsToProcess(board, endPosition, treeCoordinator.getTail(), false);
		return this.mountJumperTree(board, positionsToProcess, positions, treeCoordinator);
	    }
	}
    }



    private List<Position> getNewPositionsToProcess(Board board, List<Position> positions, JumperTree tree, boolean addStone) {
	Set<Position> positionsToProcess = new HashSet<Position>();
	positions.forEach(position ->{
	    new Jumper(position, board.getJumper()).getPossiblePositionMoves(board)
	    .forEach(newPosition -> {
		positionsToProcess.add(newPosition);
		tree.addNode(position, newPosition);
		if(addStone){
		    try{
			board.addStone(new Stone(position.getXyAxis()));
		    } catch(InvalidPositionException e){ }
		}
	    });
	});
	return new ArrayList<Position>(positionsToProcess);
    }

    private JumperTree b (Board board, Position endPosition, List<Position> positions, JumperTree tree){
	if( positions.isEmpty()){
	    return new JumperTree(new Node(endPosition));
	}
	if( positions.stream().filter(p -> p.equals(endPosition)).count() > 0){
	    return tree;
	}else{
	    Set<Position> positionsToProcess = new HashSet<Position>();
	    positions.forEach(position ->{
		new Jumper(position, board.getJumper()).getPossiblePositionMoves(board)
		.forEach(newPosition -> {
		    positionsToProcess.add(newPosition);
		    tree.addNode(position, newPosition);
		    try{
			board.addStone(new Stone(position.getXyAxis()));
		    } catch(InvalidPositionException e){ }
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
