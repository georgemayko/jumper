package br.com.gm.jumper.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Result {

    @Setter
    private int numberOfSteps = 0;
    private List<String> paths;
    
    public Result(){
	super();
	this.paths = new ArrayList<String>();
    }
    
    public void addPath(String path){
	this.paths.add(path);
    }
    
    public int getNumberOfPaths(){
	return this.paths.size();
    }
    
    
}
