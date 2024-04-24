
package tree;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class ArvoreBin {
	private Nodo raiz;
	
	

    public Nodo getRaiz() {
		return raiz;
	}

	public ArvoreBin() {
        raiz = null;
    }
	
    /*
    public void inserir(int valor) {
        raiz = inserir1(valor);
    }
	*/
    public Nodo inserir(int valor) {
    		Nodo  novoNodo = new Nodo(valor); 
    		
    		

    	    // Arvore esta vazia
    	    if (raiz == null) {
    	        this.raiz = novoNodo;
    	        return novoNodo; // Retorna o novo nó se a árvore estiver vazia
    	    } else {
    	        Nodo atual = this.raiz;

    	        while (true) {

    	            // verificar se já o valor existente
    	            if (novoNodo.getValor() == atual.getValor()) {
    	                return null; // Retorna null se o valor já existir na árvore
    	            }

    	            // comparar novo Nodo menor atual, se for, vai para esquerda
    	            if (novoNodo.getValor() < atual.getValor()) {

    	                if (atual.getEsq() == null) {
    	                    atual.setEsq(novoNodo);
    	                    return novoNodo; // Retorna o novo nó se for inserido à esquerda
    	                } else {
    	                    atual = atual.getEsq();
    	                }

    	            } else {
    	                if (atual.getDir() == null) {
    	                    atual.setDir(novoNodo);
    	                    return novoNodo; // Retorna o novo nó se for inserido à direita
    	                } else {
    	                    atual = atual.getDir();
    	                }
    	            }
    	        }
    	    }
    		
    	

    }
    
    
    public void preOrdem() {
        preOrdem(raiz);
    }

    private void preOrdem(Nodo raiz) {
        if(raiz != null) {
        	System.out.println(raiz.getValor()); // Imprime o valor do nó raiz
            preOrdem(raiz.getEsq()); // Visita recursivamente o filho esquerdo da raiz
            preOrdem(raiz.getDir());
        }
    }
 
    public void emOrdem() {
    	emOrdem(raiz);
    }

    private void emOrdem(Nodo raiz) {
    	if(raiz != null) { // vai ser nulo  quando não tiver mais "filho"
			emOrdem(raiz.getEsq());
			System.out.println(raiz.getValor());//nãa há necessida disso
			emOrdem(raiz.getDir());
		}
    }

    public void posOrdem() {
        posOrdem(raiz);
    }

    private void posOrdem(Nodo raiz) {
    	if(raiz != null) { // vai ser nulo  quando não tiver mais "filho"
			posOrdem(raiz.getEsq());
			posOrdem(raiz.getDir());
			System.out.println(raiz.getValor());//nãa há necessida disso
		
			}
    }

    public Nodo remover(Nodo raiz, int valor) {
    	// Se a raiz for nula, return raiz
    	if (raiz == null)
            return raiz;
    	
    	//valor a ser removido for menor que o valor da raiz
        if (valor < raiz.getValor())
            raiz.setEsq(remover(raiz.getEsq(), valor));
        
        //valor a ser removido for maior que o valor da raiz
        else if (valor > raiz.getValor())
            raiz.setDir(remover(raiz.getDir(), valor));
        
       
        else {
        	// Se o nó a ser removido é uma folha
        	if (raiz.getEsq() == null && raiz.getDir() == null) {
                raiz = null;
            } 
        	
        	// Se o nó tem apenas um filho à direita
        	else if (raiz.getEsq() == null)
                raiz = raiz.getDir();
        	
        	// Se o nó tem apenas um filho à esquerda
            else if (raiz.getDir() == null)
                raiz = raiz.getEsq();
        	
        	// Se o nó tem dois filhos
            else {
                raiz.setValor(minValue(raiz.getDir()));
                raiz.setDir(remover(raiz.getDir(), raiz.getValor()));
            }
        }

        return raiz;
    }
    
    public Nodo buscar( int valor) {
        Nodo atual = raiz;
        while (atual != null) {
            if (atual.getValor() == valor) {
                return atual;
            } else if (valor < atual.getValor()) {
                atual = atual.getEsq();
            } else {
                atual = atual.getDir();
            }
        }
        return null; // Retorna null se o valor não for encontrado na árvore
    }


    public  int minValue(Nodo no) {
        int minValor = no.valor;
        while (no.getEsq() != null) {
            minValor = no.getEsq().valor;
            no = no.getEsq();
        }
        return minValor;
    }
    	
    	

    public void gerarArqDot(String filename) {
    	try (BufferedWriter out = new BufferedWriter(new FileWriter(filename))) {
            out.write("digraph ArvoreBin {\n");
            escreverPreOrdemDot(raiz, out);
            out.write("}");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    private void escreverPreOrdemDot(Nodo raiz, BufferedWriter out) throws IOException {
    	if (raiz != null) {
            out.write(raiz.getValor() + ";\n"); // Escreve o valor do nó
            if (raiz.getEsq() != null) {
                out.write(raiz.getValor() + " -> " + raiz.getEsq().getValor() + " [label=\"esquerda\"];\n");
            }
            if (raiz.getDir() != null) {
                out.write(raiz.getValor() + " -> " + raiz.getDir().getValor() + " [label=\"direita\"];\n");
            }
            escreverPreOrdemDot(raiz.getEsq(), out); // Visita recursivamente o filho esquerdo
            escreverPreOrdemDot(raiz.getDir(), out); // Visita recursivamente o filho direito
        }
    }
    
    
    
    
}
    
