package br.edu.iftm.corrida;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws InterruptedException {
		// Declarações
		Scanner scanner = new Scanner(System.in);
		int qtdParticipantes;
		Participante[] participantes;
		Thread[] threads;
		String nome;
		int velocidade;
		
		// Ler e criar vetor
		System.out.print("Insira a quantidade de participantes: ");
		qtdParticipantes = Integer.parseInt(scanner.nextLine());
		participantes = new Participante[qtdParticipantes];
		threads = new Thread[qtdParticipantes];
		
		// Ler dados
		for(int i = 0; i < qtdParticipantes; i++) {
			System.out.printf("Insira o nome do participante %d: ", i + 1);
			nome = scanner.nextLine();
			
			do {
				System.out.printf("Insira a velocidade do participante %d (de 0 a 100): ", i + 1);
				velocidade = Integer.parseInt(scanner.nextLine());
			}
			while(velocidade < 0 || velocidade > 100);
			
			participantes[i] = new Participante(nome, velocidade);
			threads[i] = new Thread(participantes[i]);
		}

		// Correr!
		System.out.println("\n[ INICIO DA CORRIDA ]");
		for(int i = 0; i < qtdParticipantes; i++) 
			threads[i].start();
		
		// Aguardar
		for(int i = 0; i < qtdParticipantes; i++) 
			threads[i].join();
		System.out.println("[ FIM DA CORRIDA ]");
		
		// Limpar
		scanner.close();		
		scanner = null;
		participantes = null;
		threads = null;
		nome = null;
	}

}
