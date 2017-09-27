package br.com.gm.business;

import java.util.Collection;

import br.com.gm.jumper.model.XYAxis;

public class Logger {
    
    public static <T extends XYAxis> void logValidadInputs(String field, Collection<T> processedValues){
	StringBuilder sb = new StringBuilder();
	sb.append(field).append(": ");
	for (XYAxis xyAxis : processedValues) {
	    sb.append(xyAxis.getLocation());
	}
	System.out.println(sb.toString());
    }
    
    public static void log(String message){
	System.out.println(message);
    } 
}
