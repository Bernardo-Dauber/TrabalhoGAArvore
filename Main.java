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

        // Realize o caminhamento pré-ordem para exibir os valores da árvore
        System.out.println("Caminhamento pré-ordem:");
        arvore.preOrdem();

        String caminhoDoArquivo = "D:\\Graphviz\\bin\\dotFiles\\ArvoreBinGerado.dot";

        // Gere o arquivo DOT com o caminhamento pré-ordem da árvore na pasta especificada
        arvore.gerarArqDot(caminhoDoArquivo);

        // Exiba uma mensagem informando que o arquivo DOT foi gerado	
        System.out.println("Arquivo DOT gerado com sucesso: " + caminhoDoArquivo);
    }

}
