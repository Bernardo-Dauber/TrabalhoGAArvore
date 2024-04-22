package tree;

public class ArvoreBin {
	private Nodo raiz;

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

    public boolean remover(int valor) {
        
    	//Buscar elemento da arvore para ser removido
    			Nodo atual = this.raiz; 
    			Nodo paiAtual = null; 
    			while(atual != null) { // chegou há um valor que não existe na árvore
    				if (atual != null) {
    				    paiAtual = atual; // Movido para dentro do bloco if
    				    if (atual.getValor() == valor) {
    				        break;
    				    } else if (atual.getValor() < paiAtual.getValor()) {
    				        paiAtual = atual;
    				        atual = atual.getEsq();
    				    } else {
    				        paiAtual = atual;
    				        atual = atual.getDir();
    				    }
    				}

    			}
    			
    			//verificar se existe o elemento
    			if(atual != null) {
    				
    					
    				/*CASO: TEM 2 FILHOS OU SÓ NA DIREITA*/
    				if(atual.getDir() != null) {
    					
    						Nodo substituto = atual.getDir();
    		                Nodo paiSubstituto = atual;
    		                while(substituto.getEsq() != null){
    		                    paiSubstituto = substituto;
    		                    substituto = substituto.getEsq();
    		                }
    		                substituto.setEsq(atual.getEsq());
    		                if (paiAtual != null){
    		                    if (atual.getValor()< paiAtual.getValor()){ //atual < paiAtual
    		                        paiAtual.setEsq(substituto);
    		                    }else{
    		                        paiAtual.setDir(substituto);
    		                    }
    		                }else{ //se não tem paiAtual, então é a raiz
    		                    this.raiz = substituto;
    		                }
    					
    					//remover elemento
    					if(atual.getValor()< paiAtual.getValor()) {// substituto < paiSubstituto
    						paiSubstituto.setEsq(null);
    					}else{
    						paiSubstituto.setDir(null);
    					}
    				
    				}
    				
    				
    					/*CASO tem filho só a esquerda*/ 
    				
    				else if(atual.getEsq() != null) {
    					
    					Nodo substituto = atual.getEsq(); 
    					Nodo paiSubstituto = atual;
    					
    					while(substituto.getDir() != null) {
    						paiSubstituto = substituto;
    						substituto = substituto.getDir();	
    					}
    					
    					//substituir pelo atual
    					
    					if (paiAtual != null){
    	                    if (atual.getValor()< paiAtual.getValor()){ //atual < paiAtual
    	                        paiAtual.setEsq(substituto);
    	                    }else{
    	                        paiAtual.setDir(substituto);
    	                    }
    	                }else{ //se for a raiz
    	                    this.raiz = substituto;
    	                }
    					
    					
    					//remover elemento
    					if(atual.getValor() > paiAtual.getValor()) {// substituto < paiSubstituto
    						paiSubstituto.setEsq(null);
    					}else{
    						paiSubstituto.setDir(null);
    					}
    					
    				}
    				
    				
    				/*CASO NÃO TEM FILHO*/
    				
    				else {//não tem filho 
    					if (paiAtual != null){
    	                    if (atual.getValor()< paiAtual.getValor()){ //atual < paiAtual
    	                        paiAtual.setEsq(null);
    	                    }else{
    	                        paiAtual.setDir(null);
    	                    }
    	                }else{ //é a raiz
    	                    this.raiz = null;
    	                }
    	            }

    	            return true;
    	        }else{
    	            return false;
    	        }
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


    public void  buscarMin() {
        
    	Nodo atual = raiz; 
    	while(atual.getEsq() != null) {
    		atual = atual.getEsq();    	
    	}
    	
    	System.out.println( atual.valor);
    }
    	
    	
/*
    public void gerarArqDot(String filename) {
        // Implementação aqui
    }

    private void escreverPreOrdemDot(Nodo raiz, BufferedWriter out) throws IOException {
        // Implementação aqui
    }
*/
}
