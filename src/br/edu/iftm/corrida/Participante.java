package br.edu.iftm.corrida;

public class Participante implements Runnable {

	public static final int LOOPS = 10;
	
	private String nome;
	private int velocidade;
	
	public Participante(String nome, int velocidade) {
		this.nome = nome;
		this.velocidade = velocidade;
	}
	
	public String getNome() { return nome; }
	public int getVelocidade() { return velocidade; }
	
	private int tempoDormir() {
		return velocidade * 20;
	}
	
	@Override
	public void run() {
		try {
			for(int volta = 0; volta < LOOPS; volta++) {
				Thread.sleep(this.tempoDormir());
				System.out.printf("[%s] AVANCOU UM PASSO. (%dms)\n", nome, (volta + 1) * this.tempoDormir());
			}
		} 
		catch(InterruptedException e) { 
			e.printStackTrace(); 
		}
	}
	
}
