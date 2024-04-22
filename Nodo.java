package tree;

public class Nodo {
	int valor;
    Nodo esq, dir;
	
    public Nodo(int valor) {
		this.valor = valor; 
	}
	public int getValor() {
		return valor ;
	}
	public void setValor(int info) {
		this.valor = info;
	}
	public Nodo getEsq() {
		return esq;
	}
	public void setEsq(Nodo esq) {
		this.esq = esq;
	}
	public Nodo getDir() {
		return dir;
	}
	public void setDir(Nodo dir) {
		this.dir = dir;
	}
    
    
    
}
