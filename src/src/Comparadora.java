package src;

import java.util.Comparator;

class Comparadora implements Comparator<String> {

 

	@Override
	public int compare(String arg0, String arg1) {
        if (arg0.length() > arg1.length()) {
            return 1;
        } else if (arg0.length() < arg1.length()) {
            return -1;
        } else {
            return 0;
        }
	}


	
	
}