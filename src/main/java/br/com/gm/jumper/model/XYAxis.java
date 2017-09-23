package br.com.gm.jumper.model;

import lombok.Getter;

@Getter
public class XYAxis {

    private int xAxis;
    private int yAxis;
    
    public XYAxis(int xAxis, int yAxis) {
	super();
	this.xAxis = xAxis;
	this.yAxis = yAxis;
    }
    
}
