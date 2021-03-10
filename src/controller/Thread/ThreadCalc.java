package controller.Thread;

public class ThreadCalc extends Thread{
	private int[] vetor;
	private int x;

	public ThreadCalc(int x, int[] vetor) {
		this.vetor = vetor;
		this.x=x;
	}
	@Override
	public void run() {
		ThreadSoma();
	}
	
	private void ThreadSoma() {
		int soma=0;
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		synchronized(this) {
			for(int i = 0; i<5 ; i++){
				soma += vetor[i];
			}
			System.out.println("Linha " + (x+1) + " = " + soma);
		}
	}
}	
