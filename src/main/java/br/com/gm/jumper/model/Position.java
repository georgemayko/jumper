package br.com.gm.jumper.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.com.gm.jumper.exceptions.InvalidPositionException;
import lombok.Getter;

@Getter
public class Position implements BoardSquare{

    private XYAxis xyAxis;

    public Position(XYAxis xyAxis) throws InvalidPositionException {
	super();
	if(xyAxis.getXAxis() < 0 || xyAxis.getYAxis() < 0)
	    throw new InvalidPositionException();
	this.xyAxis = xyAxis;
    }

    @Override
    public String getLocation() {
	return this.xyAxis.getLocation();
    }

    @Override
    public boolean equals(Object obj) {
	if (obj instanceof Position == false)
	{
	    return false;
	}
	if (this == obj)
	{
	    return true;
	}
	return new EqualsBuilder().append(this.getXyAxis(), ((Position) obj).getXyAxis()).build();
    }

    @Override
    public int hashCode() {
	return HashCodeBuilder.reflectionHashCode(this);
    }

}
