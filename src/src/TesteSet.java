package src;

import java.util.HashSet;
import java.util.Set;

public class TesteSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<String> s= new HashSet<>();
		s.add("branca");
		s.add("preta");
		s.add("vermelha");
		s.add("azul");
		s.add("lilás");
		System.out.println(s.contains("branca"));
		System.out.println("removendo elementos");
		
		System.out.println(difference(s, "branca"));
	}
	
	 public static <T> Set<T> difference(Set<T> setA, String cor) {
		    Set<T> tmp = new HashSet<T>(setA);
		    tmp.remove(cor);
		    return tmp;
		  }

}
