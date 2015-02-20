package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinacoesAbordagem5 {

	 public static void main(String[] args) {
		 
		 List<String> entrada = new ArrayList<String>();
		 entrada.add("1");
		 entrada.add("2");
		 entrada.add("3");
		 entrada.add("4");
		 entrada.add("5");
		 entrada.add("6");
		 entrada.add("7");
		 entrada.add("8");
		 entrada.add("9");
		 
	        List<String> combinations = getCombinations(entrada);
	        Collections.sort(combinations, new Comparadora());
	        for (String string : combinations) {
	        	System.out.println(string);
				
			}
	        
	    }
	    
	    public static List<String> getCombinations(List<String> entrada) {
	    	List<String> results = new ArrayList<String>();
	        for (int i = 0; i < entrada.size(); i++) {
	            for (int j = 0; j <  results.size(); j++) {
	                results.add(entrada.get(i) + entrada.get(j));
	            }
	        }
	        return results;
	    }

}
