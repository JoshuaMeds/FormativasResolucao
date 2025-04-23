public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        int[] valores = {14, 15, 4, 9, 7, 18, 3, 5, 16, 20, 17, 9, 5};

        for (int v : valores) arvore.inserir(v);

        System.out.println("Arvore dividida:");
        arvore.imprimirRamosSeparados();

        arvore.removerMaior();
        arvore.removerMenor();
        arvore.remover(9);

        System.out.println("\nApos remocoes:");
        arvore.imprimirRamosSeparados();
    }
}
