package br.com.gm.jumper.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
    
    @Override
    public String getLocation() {
	return String.format("(%d,%d)", xAxis , yAxis);
    }
}
