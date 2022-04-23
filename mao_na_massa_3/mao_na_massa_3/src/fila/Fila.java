package fila;

public class Fila implements IFila {

	private static final int capacidade = 5; // capacidade total da fila
	private Object[] Fila;  //Array que representa a fila
	private int tam; 
	private int fim = -1; //final da fila

	public int getFim() {
		return fim;
	}

	public void setFim(int fim) {
		this.fim = fim;
	}

	public int getTam() {
		return tam;
	}
	
	public int getCapacidade() {
		return capacidade;
	}

	public Fila(){
		this(capacidade);
	}

	public Fila(int cap){
		tam = capacidade;
		Fila = new Object[tam];
	}

	public int tamanho() {
		return fim+1;
	}

	public boolean estaVazia() {
		return (fim == -1) ? true : false;
	}

	public boolean estaCheia() {
		return (fim == tam) ? true : false;
	}

	public void insereNaFila(Object obj) throws FilaCheiaException {
		if(fim+1 == capacidade) {
			throw new FilaCheiaException("Fila cheia");
		}
		fim++;
		Fila[fim] = obj;
	}

	public Object removeDaFila() throws FilaVaziaException {
		if(fim == -1) {
			throw new FilaVaziaException("Fila vazia");
		}
		Object item = Fila[0];
		for(int k = 1; k <= fim; k++) {
			Fila[k-1] = Fila[k];
		}
		Fila[fim]=null;
		fim--;
		return item;
	}

	public void limpaFila(){
		for(int i=0; i < tam; i++)
			Fila[i] = null;
		fim=-1;
	}
}
