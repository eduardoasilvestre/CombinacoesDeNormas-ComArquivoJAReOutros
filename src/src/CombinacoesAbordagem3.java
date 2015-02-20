package src;

public class CombinacoesAbordagem3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "abcdefghijklmopqrstuwxyz";

		int k = 23;

		int len = str.length();

		printAllKLengthRec(str, k, "");

	}

	private static void printAllKLengthRec(String str, int k, String output) {
		if (k == 0) {
			System.out.println(output);
		}
		for (int i = 0; i < str.length(); i++) {
			printAllKLengthRec(str.substring(0, i) + str.substring(i + 1),	k - 1, output + str.charAt(i));
		}

	}

}
