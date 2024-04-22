package tree;

public class Main {

	public static void main(String[] args) {
		ArvoreBin arvore = new ArvoreBin();
        arvore.inserir(10);
        arvore.inserir(5);
        arvore.inserir(20);
        arvore.inserir(3);
       

        System.out.println("Caminhamento pré-ordem:");
        arvore.preOrdem();

        System.out.println("\nCaminhamento em ordem:");
        arvore.emOrdem();

        System.out.println("\nCaminhamento pós-ordem:");
        arvore.posOrdem();
        
        System.out.println("\nRemover:");
        arvore.remover(10);
        
        System.out.println("\nCaminhamento em ordem:");
        arvore.emOrdem();
		
        System.out.println("\nmin");
        
        arvore.buscarMin();
        
        /*
        arvore.remover(3);
        
        System.out.println("\nCaminhamento em ordem:");
        arvore.emOrdem();
        */
		//Salvar no arquivo dot pra visualização 
		//arvore.gerarArqDot("arvoreBin.dot");

	}

}
