public class Formativa1 {
    public class Node {
        private Integer info;
        private Integer prox;

        public Node() {
            info = null;
            prox = null;
        }
    }

    public class ListaEncadeada {
        private Node[] Lista;
        private Integer primeiro;

        public ListaEncadeada(int tamanho) {
            Lista = new Node[tamanho];
            primeiro = null;
        }

        public void removeElemento(int valor) {
            if (primeiro == null) {
                System.out.println("Erro: Lista vazia");
                return;
            }

            if (Lista[primeiro].info.equals(valor)) {
                primeiro = Lista[primeiro].prox;
                return;
            }

            Integer atual = primeiro;
            while (atual != null && Lista[atual].prox != null) {
                if (Lista[Lista[atual].prox].info.equals(valor)) {
                    Lista[atual].prox = Lista[Lista[atual].prox].prox;
                    return;
                }
                atual = Lista[atual].prox;
            }

            System.out.println("Erro: Elemento não encontrado");
        }
    }
}
