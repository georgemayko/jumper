package br.com.gm.jumper.model;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

@Getter
public class Result {

    private int numberOfSteps;
    private int numberOfPaths;
    private List<String> paths;
    
    public Result(int numberOfSteps,int numberOfPaths, String... paths) {
	super();
	this.numberOfSteps = numberOfSteps;
	this.numberOfPaths = numberOfPaths;
	this.paths = Arrays.asList(paths);
    }
    
    
}
