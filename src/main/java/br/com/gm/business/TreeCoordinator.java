package br.com.gm.business;

import java.util.Collection;

import br.com.gm.jumper.model.Position;
import lombok.Getter;

@Getter
public class TreeCoordinator {

    private JumperTree header;
    private JumperTree tail;


    public TreeCoordinator(JumperTree header, JumperTree tail) {
	super();
	this.header = header;
	this.tail = tail;
    }

    public void joinTrees(Collection<Position> collection){
	if(!tail.getRoot().getChildNodes().isEmpty()){
	    collection.forEach(position -> {
		System.out.println("INTERSEÇÃO: " + position.getLocation());
		for (Node node : tail.findNodeWithPosition(tail.getRoot().getChildNodes(), position)) {
		    Node actualNode = node;
		    while (actualNode.getParent()  != null){
			System.out.println("PAI :" + actualNode.getPosition().getLocation());
			System.out.println("FILHO :" + actualNode.getParent().getPosition().getLocation());
			header.addNode(actualNode.getPosition(), actualNode.getParent().getPosition());
			actualNode = actualNode.getParent();
		    }   
		};
	    });
	};
    }

    public JumperTree getFullTree(){
	return header;
    }

}
