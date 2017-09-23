package br.com.gm.jumper.model;

import java.util.Set;

import javax.swing.text.Position;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Jumper {
    
    private Position initialPosition;
   private Position finalPosition;
    private Set<Move> possibleMoves;
    
    @Setter
    private Position actualPosition;
    
    
    
    
}
