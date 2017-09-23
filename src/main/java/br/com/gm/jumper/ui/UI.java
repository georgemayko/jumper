package br.com.gm.jumper.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.gm.jumper.exceptions.BoardSizeException;
import br.com.gm.jumper.model.Board;

public class UI {

    public void run(){
	askBoardSize();
    }
    
    public void askJumperPossibleMoves(){
	showMessage("Jumper moves:");
	
    }

    private void askBoardSize() {
	showMessage("Board Size: ");
	try{
	    new Board(readInt());
	}catch (BoardSizeException e) {
	    System.err.println("Board Size is invalid");
	    this.askBoardSize();
	}
    }
    
    private void showMessage(String message){
	System.out.print(message);
    }
    
    private int readInt(){
	Scanner sc = new Scanner(System.in);
	try{
	    return sc.nextInt();
	}catch ( InputMismatchException e) {
	    System.out.print("The value is not valid. Inform the correct value: ");
	    return readInt();
	}
	finally {
	    sc.close();
	}
    }

}
