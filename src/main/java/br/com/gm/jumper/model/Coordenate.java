package br.com.gm.jumper.model;

import lombok.Getter;

@Getter
public class Coordenate {

    private int x;
    private int y;
    
    public Coordenate(int x, int y) {
	super();
	this.x = x;
	this.y = y;
    }
    
}
