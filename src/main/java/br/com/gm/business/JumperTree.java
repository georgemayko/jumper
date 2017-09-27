package br.com.gm.business;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import br.com.gm.jumper.model.Position;
import br.com.gm.jumper.model.Result;
import lombok.Getter;

@Getter
public class JumperTree {

    private Node root;

    public JumperTree(Node root) {
	super();
	this.root = root;
    }

    public void addNode(Position positionParent, Position positionNode){
	if(root.getPosition().equals(positionParent)){
	    root.addChildNode(new Node(positionNode));
	}else{
	    Set<Node> nodesParent = findNodeWithPosition(root.getChildNodes(), positionParent);
	    nodesParent.forEach(parent -> {
		if( parent.getParent() != null &&
			!parent.getParent().getPosition().equals(positionNode)){
		    parent.addChildNode(new Node(positionNode));
		}
	    });
	}
    }

    protected Set<Node> findNodeWithPosition(Set<Node> nodes, Position position){
	Set<Node> nodeList = nodes.stream().filter(node -> node.getPosition().equals(position)).collect(Collectors.toSet());
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
	    for (Node node : this.findNodeWithPosition(root.getChildNodes(), position)) {
		AtomicInteger steps = new AtomicInteger(0);
		StringBuilder sb = new StringBuilder();
		Node parent = node;
		while (parent.getParent() != null){
		    steps.incrementAndGet();
		    sb.insert(0, parent.getPosition().getLocation());
		    parent = parent.getParent();
		}
		result.addPath(sb.toString());
		result.setNumberOfSteps(steps.get());
	    }
	}
	return result;

    }
}
