package src;

public class CombinacoesAbordagem1{  
      
    private int numeros[] = {1,2,3,4,5,6,7,8,9,10};  
    private int quantidade = 3;  
    private int resultado[] = new int[3];  
  
    private int count = 0;  
  
    private void busca(int inicio,int fim, int profundidade){  
  
        if ( (profundidade + 1) >= quantidade)  
        for(int x = inicio; x <= fim; x++){  
            resultado[profundidade] = numeros[x];  
            // faz alguma coisa com um dos resultados possiveis  
            count++;  
            System.out.println(resultado[0] + ", " + resultado[1] + ", " + resultado[2] + "\n");  
        }  
    else  
        for(int x = inicio; x <= fim; x++){  
            resultado[profundidade] = numeros[x];  
            busca(x + 1,fim + 1,profundidade + 1);  
        }  
    }  
  
    public static void main(String args[]){  
  
        CombinacoesAbordagem1 comb = new CombinacoesAbordagem1();  
        comb.busca(0, (10-3), 0);  
        System.out.println("Total de combinacoes: " + comb.count);  
  
    }  
}  