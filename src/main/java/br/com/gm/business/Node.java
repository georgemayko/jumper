package br.com.gm.business;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.com.gm.jumper.model.Position;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Node {

    private Position position;
    @Setter
    private Node parent;
    private Set<Node> childNodes;

    public Node(Position position){
	this.position = position;
	this.childNodes = new HashSet<Node>();
    }

    public void addChildNode(Node node) {
	node.setParent(this);
	this.childNodes.add(node);
    }
    
    
    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
