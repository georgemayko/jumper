package br.com.gm.business;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

import br.com.gm.jumper.exceptions.InvalidPositionException;
import br.com.gm.jumper.model.Position;
import br.com.gm.jumper.model.XYAxis;

public class JumperTreeTest {
    
    @Test
    public void mustAddARootForStartPosition() throws InvalidPositionException{
	Node nodeRoot = new Node(new Position(new XYAxis(1, 1)));
	JumperTree tree = new JumperTree(nodeRoot);
	Assert.assertEquals(new Position(new XYAxis(1, 1)), tree.getRoot().getPosition());
    }
    
    
    @Test
    public void mustAddFirstLevelChildForRootNode() throws InvalidPositionException{
	Node nodeRoot = new Node(new Position(new XYAxis(1, 1)));
	JumperTree tree = new JumperTree(nodeRoot);
	tree.addNode(new Position(new XYAxis(1, 1)), new Position(new XYAxis(1, 2)));
	Assert.assertEquals(1, tree.getRoot().getChildNodes().size());
	Assert.assertEquals(new Position(new XYAxis(1, 2)), tree.getRoot().getChildNodes().iterator().next().getPosition());
    }
    
    
    @Test
    public void mustAddSecondLevelChildForRootNode() throws InvalidPositionException{
	Node nodeRoot = new Node(new Position(new XYAxis(1, 1)));
	JumperTree tree = new JumperTree(nodeRoot);
	//Adding a child for the root node
	tree.addNode(new Position(new XYAxis(1, 1)), new Position(new XYAxis(1, 2)));
	//Adding a child for the last node added;
	tree.addNode(new Position(new XYAxis(1, 2)), new Position(new XYAxis(1, 3)));
	Assert.assertEquals(1, tree.getRoot().getChildNodes().size());
	Assert.assertEquals(new Position(new XYAxis(1, 3)), tree.getRoot().getChildNodes().iterator().next().getChildNodes().iterator().next().getPosition());
    }
    
    
    @Test
    public void mustNotConsiderANodeRelatedToTheParentOfHisParent() throws InvalidPositionException{
	Node nodeRoot = new Node(new Position(new XYAxis(4, 4)));
	JumperTree tree = new JumperTree(nodeRoot);
	//Adding a child for the root node
	tree.addNode(new Position(new XYAxis(4, 4)), new Position(new XYAxis(2, 3)));
	//Adding a child for the last node added;
	tree.addNode(new Position(new XYAxis(2, 3)), new Position(new XYAxis(4, 4)));
	//Assert.assertEquals(1, tree.getTotalOfSteps(new Position(new XYAxis(2, 3))));
	Assert.assertEquals(1, tree.getRoot().getChildNodes().size());
	Assert.assertEquals(0, tree.getRoot().getChildNodes().iterator().next().getChildNodes().size());
    }
    
    
    
    @Test
    public void mustNotAddTwiceTheSameSecondLevelChildForRootNode() throws InvalidPositionException{
	Node nodeRoot = new Node(new Position(new XYAxis(1, 1)));
	JumperTree tree = new JumperTree(nodeRoot);
	//Adding a child for the root node
	tree.addNode(new Position(new XYAxis(1, 1)), new Position(new XYAxis(1, 2)));
	//Adding a child for the last node added;
	tree.addNode(new Position(new XYAxis(1, 2)), new Position(new XYAxis(1, 3)));
	//Adding the same Child 
	tree.addNode(new Position(new XYAxis(1, 2)), new Position(new XYAxis(1, 3)));
	Assert.assertEquals(1, tree.getRoot().getChildNodes().size());
	Assert.assertEquals(new Position(new XYAxis(1, 3)), tree.getRoot().getChildNodes().iterator().next().getChildNodes().iterator().next().getPosition());
    }
    
    @Test
    public void a() throws InvalidPositionException{
	Position rootPosition = new Position(new XYAxis(4, 4));
	Node root = new Node(new Position(new XYAxis(4, 4)));
	JumperTree tree = new JumperTree(root);
	//Adding a child for the root;
	tree.addNode(rootPosition, new Position(new XYAxis(3, 2)));
	tree.addNode(rootPosition, new Position(new XYAxis(2, 3)));
	//Adding
	tree.addNode(new Position(new XYAxis(3, 2)), new Position(new XYAxis(1, 1)));
	tree.addNode(new Position(new XYAxis(2, 3)), new Position(new XYAxis(1, 1)));
	int numberOfSecondLevelChilds = 0;
	//tree.getRoot().getChildNodes().forEach(firstLevelChild -> numberOfThirdLevelChilds+=firstLevelChild.getChildNodes().size());
	Iterator<Node> iteratorFirsLevelChild = tree.getRoot().getChildNodes().iterator();
	while(iteratorFirsLevelChild.hasNext()){
	    numberOfSecondLevelChilds +=iteratorFirsLevelChild.next().getChildNodes().size();
	}
	
	Assert.assertEquals(2, numberOfSecondLevelChilds);
    }
    
    
    @Test
    public void b() throws InvalidPositionException{
	Position rootPosition = new Position(new XYAxis(4, 4));
	Node root = new Node(new Position(new XYAxis(4, 4)));
	JumperTree tree = new JumperTree(root);
	//Adding two childs for the root;
	tree.addNode(rootPosition, new Position(new XYAxis(3, 2)));
	tree.addNode(rootPosition, new Position(new XYAxis(2, 3)));
	//Adding One child for each parent of first LevelChild
	tree.addNode(new Position(new XYAxis(3, 2)), new Position(new XYAxis(2, 2)));
	tree.addNode(new Position(new XYAxis(2, 3)), new Position(new XYAxis(2, 2)));
	
	
	//Adding One child for each parent of first LevelChild
	tree.addNode(new Position(new XYAxis(2, 2)), new Position(new XYAxis(1, 1)));
	
	int numberOfThirdLevelChilds = 0;
	//tree.getRoot().getChildNodes().forEach(firstLevelChild -> numberOfThirdLevelChilds+=firstLevelChild.getChildNodes().size());
	Iterator<Node> iteratorFirsLevelChild = tree.getRoot().getChildNodes().iterator();
	while(iteratorFirsLevelChild.hasNext()){
	    Iterator<Node> iteratorSecondLevelChild =iteratorFirsLevelChild.next().getChildNodes().iterator();
	    while(iteratorSecondLevelChild.hasNext()){
		numberOfThirdLevelChilds +=iteratorSecondLevelChild.next().getChildNodes().size();
	    }
	}
	
	Assert.assertEquals(2, numberOfThirdLevelChilds);
    }
    
    
    public void c() throws InvalidPositionException{
	Position rootPosition = new Position(new XYAxis(4, 4));
	Node root = new Node(new Position(new XYAxis(4, 4)));
	JumperTree tree = new JumperTree(root);
	//Adding two childs for the root;
	tree.addNode(rootPosition, new Position(new XYAxis(3, 2)));
	tree.addNode(rootPosition, new Position(new XYAxis(2, 3)));
	//Adding One child for each parent of first LevelChild
	tree.addNode(new Position(new XYAxis(3, 2)), new Position(new XYAxis(2, 2)));
	tree.addNode(new Position(new XYAxis(2, 3)), new Position(new XYAxis(2, 2)));
	
	//Adding One child for each parent of first LevelChild
	tree.addNode(new Position(new XYAxis(2, 2)), new Position(new XYAxis(1, 1)));

	//Adding One Child for Position 1,1 that is related to Position 2,3 and 3,2 
	tree.addNode(new Position(new XYAxis(1, 1)), new Position(new XYAxis(5, 5)));
	
	int numberOfFourthLevelChilds = 0;

	Iterator<Node> iteratorFirsLevelChild = tree.getRoot().getChildNodes().iterator();
	while(iteratorFirsLevelChild.hasNext()){
	    Iterator<Node> iteratorSecondLevelChild =iteratorFirsLevelChild.next().getChildNodes().iterator();
	    while(iteratorSecondLevelChild.hasNext()){
		Iterator<Node> iteratorThirdLevelChild =iteratorSecondLevelChild.next().getChildNodes().iterator();
		while(iteratorThirdLevelChild.hasNext()){
		    numberOfFourthLevelChilds +=iteratorThirdLevelChild.next().getChildNodes().size();
		}
		
	    }
	}
	
	Assert.assertEquals(2, numberOfFourthLevelChilds);
    }
    
    
    
    
    
}