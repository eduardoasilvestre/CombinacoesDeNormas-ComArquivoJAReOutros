package src;

public class CombinacoesAbordagem2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CombinacoesAbordagem2 combinacoesAbordagem3 = new CombinacoesAbordagem2();
		
		int v[] = new int[100];
		combinacoesAbordagem3.combinations(v, 1, 10, 1, 10);
		
		/* generate all combinations of n elements taken
         * k at a time, starting with combinations containing 1
         * in the first position.
         */

	}
	
	void combinations (int v[], int start, int n, int k, int maxk) {
        int     i;

        /* k here counts through positions in the maxk-element v.
         * if k > maxk, then the v is complete and we can use it.
         */
        if (k > maxk) {
                /* insert code here to use combinations as you please */
                for (i=1; i<=maxk; i++) System.out.print(v[i]);
                System.out.println();
                return;
        }

        /* for this k'th element of the v, try all start..n
         * elements in that position
         */
        for (i=start; i<=n; i++) {

                v[k] = i;

                /* recursively generate combinations of integers
                 * from i+1..n
                 */
                combinations (v, i+1, n, k+1, maxk);
        }
}

}
