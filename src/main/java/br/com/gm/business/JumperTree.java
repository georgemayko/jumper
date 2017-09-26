package br.com.gm.business;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import br.com.gm.jumper.model.Position;
import br.com.gm.jumper.model.Result;
import lombok.Getter;

@Getter
public class JumperTree {

    private Node root;

    public JumperTree(Node root/*, Position endPosition*/) {
	super();
	this.root = root;
	//this.endPosition = endPosition;
    }

    public void addNode(Position positionParent, Position positionNode){
	if(root.getPosition().equals(positionParent)){
	    root.addChildNode(new Node(positionNode));
	}else{
	    List<Node> nodesParent = findNodeWithPosition(root.getChildNodes(), positionParent);
	    nodesParent.forEach(parent -> {
		if( parent.getParent() != null &&
			!parent.getParent().getPosition().equals(positionNode)){		    
		    parent.addChildNode(new Node(positionNode));
		}
	    });
	}
    }

    private List<Node> findNodeWithPosition(Set<Node> nodes, Position position){
	List<Node> nodeList = nodes.stream().filter(node -> node.getPosition().equals(position)).collect(Collectors.toList());
	if(nodeList.isEmpty()){
	    Set<Node> nodeToLookFor = new HashSet<Node>();
	    nodes.forEach(node -> nodeToLookFor.addAll(node.getChildNodes()));
	    if(nodeToLookFor.isEmpty())
		return null;
	    return findNodeWithPosition(nodeToLookFor, position);
	}
	return nodeList;
    }

    public Result getResult(Position position){
	Result result = new Result();
	if(!root.getChildNodes().isEmpty()){
	    this.findNodeWithPosition(root.getChildNodes(), position).forEach( node ->{
		AtomicInteger steps = new AtomicInteger(0);
		StringBuilder sb = new StringBuilder();
		Node parent = node;
		while (parent.getParent() != null){
		    steps.incrementAndGet();
		    sb.insert(0, parent.getPosition().getLocation());
		    parent = parent.getParent();
		}
		System.out.println(sb.toString());
		result.addPath(sb.toString());
		result.setNumberOfSteps(steps.get());
	    });
	}
	return result;

    }
}
