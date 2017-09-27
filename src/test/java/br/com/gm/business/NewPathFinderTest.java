package br.com.gm.business;

import org.junit.Assert;
import org.junit.Test;

import br.com.gm.jumper.exceptions.BoardSizeException;
import br.com.gm.jumper.exceptions.InvalidMoveException;
import br.com.gm.jumper.exceptions.InvalidPositionException;
import br.com.gm.jumper.exceptions.JumperPositionInvalidException;
import br.com.gm.jumper.exceptions.NoMovesException;
import br.com.gm.jumper.model.Board;
import br.com.gm.jumper.model.Jumper;
import br.com.gm.jumper.model.Move;
import br.com.gm.jumper.model.Position;
import br.com.gm.jumper.model.Result;
import br.com.gm.jumper.model.Stone;
import br.com.gm.jumper.model.XYAxis;


public class NewPathFinderTest {
    
    private Move[] horseChessMoves;

    public NewPathFinderTest() throws InvalidMoveException {
	super();
	horseChessMoves = new Move[]{new Move(1,2), new Move(2,1), new Move(1,-2), new Move(2,-1), new Move(-1,2), new Move(-2,1), new Move(-1,-2), new Move(-2,-1)};
    }
    
    @Test
    public void mustReturnNumberOfStepsZeroWhenStartAndEndPositionAreTheSame() throws BoardSizeException, NoMovesException, InvalidPositionException, InvalidMoveException, JumperPositionInvalidException{
	Board board = new Board(1);
	Jumper jumper = new Jumper(new Position(new XYAxis(1,1)), horseChessMoves);
	board.addJumper(jumper);
	
	JumperTree tree = new PathFinder().findShortestPathJumperTree(new Position(new XYAxis(1, 1)), board);
	Result result = tree.getResult(new Position(new XYAxis(1, 1)));
	Assert.assertEquals(0, result.getNumberOfSteps());
	Assert.assertEquals(0, result.getNumberOfPaths());
    }
    
    @Test
    public void mustReturnNumberOfStepsOneWhenStartAndEndPositionAreConnectedByOneMove() throws BoardSizeException, NoMovesException, InvalidPositionException, InvalidMoveException, JumperPositionInvalidException{
	Board board = new Board(3);
	Jumper jumper = new Jumper(new Position(new XYAxis(1,1)), horseChessMoves);
	board.addJumper(jumper);
	
	JumperTree tree = new PathFinder().findShortestPathJumperTree(new Position(new XYAxis(2, 3)), board);
	Result result = tree.getResult(new Position(new XYAxis(2, 3)));
	Assert.assertEquals(1, result.getNumberOfSteps());
	Assert.assertEquals(1, result.getNumberOfPaths());
    }
    
    @Test
    public void mustReturnTwoStepsAndTwoPathsForABoardWithSize4AndStartingIn4X4AndEnding1x1() throws BoardSizeException, NoMovesException, InvalidPositionException, InvalidMoveException, JumperPositionInvalidException{
	Board board = new Board(4);
	Jumper jumper = new Jumper(new Position(new XYAxis(4,4)), horseChessMoves);
	board.addJumper(jumper);
	JumperTree tree = new PathFinder().findShortestPathJumperTree(new Position(new XYAxis(1, 1)), board);
	Result result = tree.getResult(new Position(new XYAxis(1, 1)));
	Assert.assertEquals(2, result.getNumberOfSteps());
	Assert.assertEquals(2, result.getNumberOfPaths());
    }
    
    @Test
    public void mustHaveThreePathsAndFiveSteps() throws BoardSizeException, NoMovesException, InvalidPositionException, InvalidMoveException, JumperPositionInvalidException{
	Board board = new Board(8);
	Jumper jumper = new Jumper(new Position(new XYAxis(1,8)), horseChessMoves);
	board.addJumper(jumper);
	
	//(1,6), (2,6), (3,6), (4,6), (5,6), (1,5), (4,5)
	board.addStone(new Stone(new XYAxis(1,6)));
	board.addStone(new Stone(new XYAxis(2,6)));
	board.addStone(new Stone(new XYAxis(3,6)));
	board.addStone(new Stone(new XYAxis(4,6)));
	board.addStone(new Stone(new XYAxis(5,6)));
	board.addStone(new Stone(new XYAxis(1,5)));
	board.addStone(new Stone(new XYAxis(4,5)));
	
	JumperTree tree = new PathFinder().findShortestPathJumperTree(new Position(new XYAxis(1, 1)), board);
	Result result = tree.getResult(new Position(new XYAxis(1, 1)));
	Assert.assertEquals(5, result.getNumberOfSteps());
	Assert.assertEquals(3, result.getNumberOfPaths());
    }
    
    
    @Test
    public void mustNotHaveStepsAndPathWhenTheWayToEndIsBlockedByStones() throws BoardSizeException, NoMovesException, InvalidPositionException, InvalidMoveException, JumperPositionInvalidException{
	Board board = new Board(3);
	Jumper jumper = new Jumper(new Position(new XYAxis(1,1)), horseChessMoves);
	board.addJumper(jumper);
	board.addStone(new Stone(new XYAxis(1,3)));
	board.addStone(new Stone(new XYAxis(3,3)));
	JumperTree tree = new PathFinder().findShortestPathJumperTree(new Position(new XYAxis(2, 1)), board);
	Result result = tree.getResult(new Position(new XYAxis(2, 1)));
	Assert.assertEquals(0, result.getNumberOfSteps());
	Assert.assertEquals(0, result.getNumberOfPaths());
    }
    
    
    
//    @Test
//    public void d() throws BoardSizeException, NoMovesException, InvalidPositionException, InvalidMoveException, JumperPositionInvalidException{
//	Board board = new Board(20);
//	Jumper jumper = new Jumper(new Position(new XYAxis(20,20)), horseChessMoves);
//	board.addJumper(jumper);
//	JumperTree tree = new PathFinder().findShortestPathJumperTree(jumper, new Position(new XYAxis(1, 1)), board);
//	Result result = tree.getResult(new Position(new XYAxis(1, 1)));
//	Assert.assertEquals(0, result.getNumberOfSteps());
//	Assert.assertEquals(0, result.getNumberOfPaths());
//    }
    
    
    @Test
    public void mustNotHavePathAndStepsWhenEndPositionIsAStonePosition() throws BoardSizeException, NoMovesException, InvalidPositionException, JumperPositionInvalidException{
	Board board = new Board(8);
	Jumper jumper = new Jumper(new Position(new XYAxis(1,8)), horseChessMoves);
	board.addJumper(jumper);
	board.addStone(new Stone(new XYAxis(1, 1)));
	JumperTree tree = new PathFinder().findShortestPathJumperTree(new Position(new XYAxis(1, 1)), board);
	Result result = tree.getResult(new Position(new XYAxis(1, 1)));
	Assert.assertEquals(0, result.getNumberOfSteps());
	Assert.assertEquals(0, result.getNumberOfPaths()); 
    }
    
    
}