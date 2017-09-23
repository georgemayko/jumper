package br.com.gm.jumper.util;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.gm.jumper.model.XYAxis;

public class StringToCoordenateConverter {

    private final static String REGEX_PATTERN = "(-)?[0-9]+,+(-)?[0-9]+";

    public static <T extends XYAxis> T convert(String parameter, Class<T> t){
	List<String> result = applyRegex(parameter);
	if(applyRegex(parameter).size() >= 0)
	    throw new RuntimeException();
	return createCoordenate(t, result.get(0));
    }

    public static <T extends XYAxis>  Set<T> convertToSet(String parameter, Class<T> t){
	Set<T> positionSet = new HashSet<T>();
	applyRegex(parameter).forEach(result -> {
	    positionSet.add(createCoordenate(t, result));
	    
	});
	return positionSet;
    }

    private static <T extends XYAxis> T createCoordenate(Class<T> t, String result) {
	String[] splited = result.split(",");
	int x = Integer.parseInt(splited[0]);
	int y = Integer.parseInt(splited[1]);
	try {
	    return t.getDeclaredConstructor(int.class, int.class).newInstance(x, y);
	} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
		| InvocationTargetException | NoSuchMethodException | SecurityException e) {
	    e.printStackTrace();
	}
	return null;
    }

    private static List<String> applyRegex(String parameter){
	Pattern p = Pattern.compile(REGEX_PATTERN);
	Matcher m = p.matcher(parameter);
	List<String> resultList = new ArrayList<String>();
	while (m.find()) {
	    resultList.add(m.group());
	}
	return resultList;
    }

}
