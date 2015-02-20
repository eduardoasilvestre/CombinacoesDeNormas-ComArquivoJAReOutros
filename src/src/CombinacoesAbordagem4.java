package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinacoesAbordagem4 {

	public static void main(String[] args) {
		List<String> combinations = getCombinations("ABCDEF");

		Collections.sort(combinations, new Comparadora());
		for (String string : combinations) {
			System.out.println(string);

		}
		System.out.println("TOTAL DE COMBINAÇÕES GERADAS: "
				+ combinations.size());

	}

	public static List<String> getCombinations(String text) {
		List<String> results = new ArrayList<String>();
		for (int i = 0; i < text.length(); i++) {
			// Record size as we will be adding to the list
			int resultsLength = results.size();
			for (int j = 0; j < resultsLength; j++) {
				results.add(text.charAt(i) + results.get(j));
			}
			results.add(Character.toString(text.charAt(i)));
		}

		for (int i = 0; i < results.size(); i++) {
			if (results.get(i).length() < 2) {
				results.remove(i);
			}
		}
		
		for(int i= 2; i <=text.length();i++) {
		
		}

			return results;
	}

}
