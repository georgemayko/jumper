package br.com.gm.business;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

import br.com.gm.jumper.model.Result;
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

    public static void logResult(Result result) {
	System.out.println("--------------Result--------------");
	System.out.println(String.format("Number of steps: %d", result.getNumberOfSteps()));
	System.out.println(String.format("Number of paths: %d", result.getNumberOfPaths()));
	AtomicInteger countAtomic = new AtomicInteger(1);
	result.getPaths().forEach( path -> System.out.println(String.format("Path %d: %s", countAtomic.getAndIncrement() ,path)));
    } 
}
