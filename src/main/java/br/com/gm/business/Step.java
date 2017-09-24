package br.com.gm.business;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Step {
    
    private int numberOfStep;
    private List<JumperTree> treeList;
    public Step(int numberOfStep, List<JumperTree> treeList) {
	super();
	this.numberOfStep = numberOfStep;
	this.treeList = treeList;
    }
    
}
