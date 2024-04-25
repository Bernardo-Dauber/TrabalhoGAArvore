package tree;



public class Main {

	public static void main(String[] args) {
		ArvoreBin arvore = new ArvoreBin();

        // Insira alguns valores na árvore
        arvore.inserir(10);
        arvore.inserir(5);
        arvore.inserir(15);
        arvore.inserir(3);
        arvore.inserir(7);
        arvore.inserir(12);
        arvore.inserir(17);

        
        String caminhoDoArquivo = "D:\\Graphviz\\bin\\dotFiles\\ArvoreBinGeradoInserir.dot";
        arvore.gerarArqDot(caminhoDoArquivo);
    
        String caminhoDoArquivo2 = "D:\\Graphviz\\bin\\dotFiles\\ArvoreBinGeradoRemoverRaiz.dot";
        arvore.remover(arvore.getRaiz(), 10);
        arvore.gerarArqDot(caminhoDoArquivo2);
        
        String caminhoDoArquivo4 = "D:\\Graphviz\\bin\\dotFiles\\ArvoreBinGeradoRemoverPai.dot";
        arvore.remover(arvore.getRaiz(), 5);
        arvore.gerarArqDot(caminhoDoArquivo4);
        
        String caminhoDoArquivo3 = "D:\\Graphviz\\bin\\dotFiles\\ArvoreBinGeradoInserirNovamente.dot";
        arvore.inserir(2);
        arvore.inserir(50);
        arvore.gerarArqDot(caminhoDoArquivo3);
        
        
        String caminhoDoArquivo5 = "D:\\Graphviz\\bin\\dotFiles\\ArvoreBinGeradoRemoverNodos.dot";
        arvore.remover(arvore.getRaiz(), 17);
        arvore.remover(arvore.getRaiz(), 7);
        arvore.gerarArqDot(caminhoDoArquivo5);
        
        
        
        System.out.println("Arquivo DOT gerado com sucesso: " + caminhoDoArquivo);
    }

}
