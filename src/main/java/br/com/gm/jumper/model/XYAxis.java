package br.com.gm.jumper.model;

import org.apache.commons.lang3.builder.EqualsBuilder;

import lombok.Getter;

@Getter
public class XYAxis implements BoardSquare{

    private int xAxis;
    private int yAxis;
    
    public XYAxis(int xAxis, int yAxis) {
	super();
	this.xAxis = xAxis;
	this.yAxis = yAxis;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }
}
