package view;
import controller.Thread.ThreadCalc;
public class Principal {

	public static void main(String[] args) {
		int matriz [][] = new int [3][5];
		int []vetor = new int [5];
		int tempo = 1000;
		
		for(int linha = 0 ; linha < 3 ; linha++) {
			for (int coluna = 0 ; coluna < 5; coluna++) {
				matriz[linha][coluna] = (int)(Math.random()*11);
			}
		}
		
		for(int linha = 0; linha < 3 ; linha++) {
			for (int coluna = 0; coluna < 5 ; coluna++) {
				System.out.print("["+matriz[linha][coluna]+"]");
			}
		System.out.println("\n");	
		}
		
		for(int linha = 0; linha < 3; linha++) {
			for (int coluna = 0; coluna < 5; coluna++) {;
					vetor [coluna] = matriz[linha][coluna];
			}
			System.out.println("\n");
			Thread T = new ThreadCalc(linha, vetor);
			T.start();
			synchronized(T){
				try {
					T.wait();
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
	}
}

